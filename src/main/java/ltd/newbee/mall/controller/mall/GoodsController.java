/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.GoodsDescVO;
import ltd.newbee.mall.controller.vo.GoodsImageVO;
import ltd.newbee.mall.controller.vo.GoodsQaVO;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.ReviewUserInfoVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.IndexConfig;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.PagingQa;
import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class GoodsController {

    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;

    @GetMapping({ "/search", "/search.html" })
    public String searchPage(@RequestParam Map<String, Object> params, HttpServletRequest request) {
	if (StringUtils.isEmpty(params.get("page"))) {
	    params.put("page", 1);
	}
	params.put("limit", Constants.GOODS_SEARCH_PAGE_LIMIT);
	// 封装分类数据
	if (params.containsKey("goodsCategoryId") && !StringUtils.isEmpty(params.get("goodsCategoryId") + "")) {
	    Long categoryId = Long.valueOf(params.get("goodsCategoryId") + "");
	    SearchPageCategoryVO searchPageCategoryVO = newBeeMallCategoryService.getCategoriesForSearch(categoryId);
	    if (searchPageCategoryVO != null) {
		request.setAttribute("goodsCategoryId", categoryId);
		request.setAttribute("searchPageCategoryVO", searchPageCategoryVO);
	    }
	}
	// 封装参数供前端回显
	if (params.containsKey("orderBy") && !StringUtils.isEmpty(params.get("orderBy") + "")) {
	    request.setAttribute("orderBy", params.get("orderBy") + "");
	}
	String keyword = "";
	// 对keyword做过滤 去掉空格
	if (params.containsKey("keyword") && !StringUtils.isEmpty((params.get("keyword") + "").trim())) {
	    keyword = params.get("keyword") + "";
	}
	request.setAttribute("keyword", keyword);
	params.put("keyword", keyword);
	// 搜索上架状态下的商品
	params.put("goodsSellStatus", Constants.SELL_STATUS_UP);
	// 封装商品数据
	PageQueryUtil pageUtil = new PageQueryUtil(params);
	request.setAttribute("pageResult", newBeeMallGoodsService.searchNewBeeMallGoods(pageUtil));
	return "mall/search";
    }

    @GetMapping("/goods/detail/{goodsId}")
    public String detailPage(@PathVariable("goodsId") Long goodsId, HttpServletRequest request) {
	if (goodsId < 1) {
	    return "error/error_5xx";
	}
	NewBeeMallGoods goods = newBeeMallGoodsService.getNewBeeMallGoodsById(goodsId);
	if (goods == null) {
	    NewBeeMallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
	}
	if (Constants.SELL_STATUS_UP != goods.getGoodsSellStatus()) {
	    NewBeeMallException.fail(ServiceResultEnum.GOODS_PUT_DOWN.getResult());
	}
	NewBeeMallGoodsDetailVO goodsDetailVO = new NewBeeMallGoodsDetailVO();
	BeanUtil.copyProperties(goods, goodsDetailVO);
	goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
	request.setAttribute("goodsDetail", goodsDetailVO);

	List<GoodsImage> imageList = newBeeMallGoodsService.getGoodsImageEntityByGoodsId(goodsId);
	if (imageList == null || imageList.isEmpty()) {
	    NewBeeMallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
	}

	List<GoodsImageVO> imageVoList = new ArrayList<GoodsImageVO>();
	for (int i = 0; i < imageList.size(); i++) {
	    GoodsImage image = new GoodsImage();
	    image = imageList.get(i);
	    if (image != null) {

		String path = image.getPath();
		GoodsImageVO imageVo = new GoodsImageVO();
		imageVo.setPath(path);
		imageVoList.add(imageVo);
	    } 
	}

	List<GoodsDesc> descList = newBeeMallGoodsService.getGoodsDescEntityByGoodsId(goodsId);
	if (descList == null || descList.isEmpty()) {
	    NewBeeMallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
	}

	List<GoodsDescVO> descVoList = new ArrayList<GoodsDescVO>();
//	List descEntityList = null;
	for (int i = 0; i < descList.size(); i++) {
	    GoodsDesc a = new GoodsDesc();
	    a = descList.get(i);
	    if (a != null) {

		
		  //added by niu 2021/04/20 add descList // List<GoodsDesc> descEntityList =
		  //newBeeMallGoodsService.getDescList(10700);
		 

		// copy list List<GoodsDescVO> descEntityList1
		BeanUtil.copyList(descList, GoodsDescVO.class);

		String color = a.getColor();
		GoodsDescVO descVo = new GoodsDescVO();
		descVo.setColor(color);
		descVoList.add(descVo);
		String material = a.getMaterial();
		descVo.setMaterial(material);
		String setDate = a.getSetDate();
		descVo.setSetDate(setDate);
		String size = a.getSize();
		descVo.setSize(size);
		String warpSize = a.getWarpSize();
		descVo.setWarpSize(warpSize);

		String warrantyYear = a.getWarrantyYear();
		descVo.setWarrantyYear(warrantyYear);

		String weight = a.getWeight();
		descVo.setWeight(weight);
	
		
		descVo.setGoodsId(goodsId);
		descVoList.add(descVo);
		

	    } 
	}

	/*
	 * // //added by niu 2021/04/20 add descList // List<GoodsDesc> descEntityList =
	 * newBeeMallGoodsService.getDescList(10700);
	 * 
	 * //copy list List<GoodsDescVO> descEntityList1
	 * =BeanUtil.copyList(descEntityList1,GoodsDescVO.class);
	 */
	
	Map<String,Object> params = new HashMap<>();            
        params.put("page",1); 
        params.put("limit",Constants.GOODS_QA_PAGE_LIMIT);
        params.put("orderBy","hulped_date");
        PageQueryUtil pageUtil = new PageQueryUtil(params); 
        PageResult a =newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);
        List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
	//List<GoodsQa> qaList = newBeeMallGoodsService.getGoodsQaEntityByGoodsId(goodsId);
	if (qaList == null || qaList.isEmpty()) {
	    NewBeeMallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
	}

	List<GoodsQaVO> qaVoList = new ArrayList<GoodsQaVO>();
	for (int i = 0; i < qaList.size(); i++) {
	    GoodsQa b = new GoodsQa();
	    b = qaList.get(i);
	    if (b != null) {

		String question = b.getQuestion();
		GoodsQaVO qaVo = new GoodsQaVO();
		qaVo.setQuestion(question);

		Date submitDate = b.getSubmitDate();
		qaVo.setSubmitDate(submitDate);

		String answer = b.getAnswer();
		qaVo.setAnswer(answer);
	
		Date answerDate = b.getAnswerDate();		
		qaVo.setAnswerDate(answerDate);
		
		String helpedNum = b.getHelpedNum();
		qaVo.setHelpedNum(helpedNum);
		
		qaVo.setGoodsId(goodsId);
		qaVoList.add(qaVo);				
	    } 
	}
        
	List<ReviewUserInfo> userInfoList = newBeeMallGoodsService.getReviewUserInfoEntityByGoodsId(goodsId);
	if (userInfoList == null || userInfoList.isEmpty()) {
	    NewBeeMallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
	}

	List<ReviewUserInfoVO> userInfoVoList = new ArrayList<ReviewUserInfoVO>();
	for (int i = 0; i < userInfoList.size(); i++) {
	    ReviewUserInfo d = new ReviewUserInfo();
	    d = userInfoList.get(i);
	    if (d != null) {

		String commentDate = d.getCommentDate();
		ReviewUserInfoVO userinfoVo = new ReviewUserInfoVO();
		userinfoVo.setCommentDate(commentDate);
		userInfoVoList.add(userinfoVo);		
		Integer star = d.getStar();
		userinfoVo.setStar(star);		
		String title = d.getTitle();
		userinfoVo.setTitle(title);
		String content = d.getContent();
		userinfoVo.setContent(content);		
		String picture = d.getPicture();
		userinfoVo.setPicture(picture);		
		String nickName = d.getNickName();
		userinfoVo.setNickName(nickName);		
		String GoodsName = d.getGoodsName();
		userinfoVo.setGoodsName(GoodsName);
			
	    } 
	}
        	request.setAttribute("goodsImageDetail", imageVoList);
        	request.setAttribute("goodsDescDetail", descVoList);
        	request.setAttribute("goodsQaDetail", qaVoList);
        	request.setAttribute("goodsUserInfoDetail", userInfoVoList);
        	return "mall/detail";
    }
    //20210426//niu
    @RequestMapping(value = "/goods/qaSort", method = RequestMethod.POST)
    @ResponseBody
    public Result getHelpedNumEntityByGoodsId(@RequestBody PagingQa page) {

	Map<String,Object> params = new HashMap<>();            
        params.put("page",page.getPage()); 
        params.put("limit",Constants.GOODS_QA_PAGE_LIMIT);
        params.put("orderBy","helped_num");
        PageQueryUtil pageUtil = new PageQueryUtil(params); 
        PageResult a =newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);
        return ResultGenerator.genSuccessResult(a);
        }   
    //added by niu 2021/04/29 insertqa
    @RequestMapping(value = "/goods/insertQa", method = RequestMethod.POST)
    @ResponseBody
    public Result insertGoodsQaSelective(@RequestBody GoodsQa question) {
        Integer count = null;  
        Long qaId = newBeeMallGoodsService.getMaxQaId(question.getGoodsId());
        question.setId(qaId);
        Date submitDate = new Date();
        Date answerDate = new Date();
        question.setSubmitDate(submitDate);
        question.setAnswerDate(answerDate);
        
        if(question != null) {
            count = newBeeMallGoodsService.insertGoodsQaSelective(question);
        }
        if(!(count > 0))  {
        return ResultGenerator.genFailResult("投稿失敗！");
        }      
        return ResultGenerator.genSuccessResult(count);
      
    }
}
