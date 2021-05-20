/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.GoodsSaleVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.GoodsSale;
import ltd.newbee.mall.entity.InsertKeyword;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.NewBeeMallUtils;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@Controller
@RequestMapping("/admin")
public class GoodsSaleController {

    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;
    @Autowired
    private StandardServletMultipartResolver standardServletMultipartResolver;
    //add by niu 2021/05/16
    //@RequestMapping(value = "/goods/sale", method = RequestMethod.POST)
    @GetMapping({ "/goods/sale","/goodsSale.html" })
  
    public String goodsSale(@RequestParam Map<String, Object> params, HttpServletRequest request) {
	if (StringUtils.isEmpty(params.get("page"))) {
	    params.put("page", 1);
	}
	params.put("limit",2);//Constants.GOODS_SEARCH_PAGE_LIMIT
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
	// 封装商品数据
	PageQueryUtil pageUtil = new PageQueryUtil(params);
	
	request.setAttribute("pageResult", newBeeMallGoodsService.goodsSalePagAndSort(pageUtil));
	
	return "admin/goodsSale";
    }
    
    // 伪代码
    @RequestMapping(value = "/searchHistory/getSearchHistory", method = RequestMethod.POST)
    @ResponseBody
    public Result getSearchHistory(HttpSession httpSession) {
    	List<NewBeeMallGoods> list = new ArrayList<NewBeeMallGoods>();

    	NewBeeMallGoods goods1 = new NewBeeMallGoods();
    	NewBeeMallGoods goods2 = new NewBeeMallGoods();
    	NewBeeMallGoods goods3 = new NewBeeMallGoods();
    	
    	goods1.setGoodsId(10700L);
    	goods1.setGoodsName("iphone10");
    	list.add(goods1);
    	goods2.setGoodsId(10003L);
    	goods2.setGoodsName("无印良品 MUJI 基础润肤化妆水");
    	list.add(goods2);
    	goods3.setGoodsId(10004L);
    	goods3.setGoodsName("无印良品 MUJI 柔和洁面泡沫");
    	list.add(goods3);
    
    	return ResultGenerator.genSuccessResult(list);
    }
    
    //add by niu 20210520 keyword
    //get hit goods
    @RequestMapping(value = "/goods/search", method = RequestMethod.POST)
    @ResponseBody
    public Result getHitGoodsList(@RequestBody String goodsName) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("keyword", goodsName);
    	params.put("page", 1);
    	params.put("limit", 9);
        //params.put("start", 0);
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallGoodsService.searchNewBeeMallGoods(pageUtil));
    }
    //added by niu 2021/05/10 insertKeyword
    @RequestMapping(value = "/goods/insertKeyword", method = RequestMethod.POST)
   //  @GetMapping({"/goods/insertKeyword"})
    @ResponseBody
    public Result insertKeyword(@RequestBody InsertKeyword keywordId, HttpSession httpSession) {
	NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
	if(user != null) {
	      keywordId.setUserId(user.getUserId());
        }
	SimpleDateFormat i = new SimpleDateFormat();
		i.applyPattern("yyyy-MM-dd HH:mm:ss a");
		Date date = new Date();
	Integer count = null;  
        Long keyWordId = newBeeMallGoodsService.getMaxKeywordId(keywordId.getUserId());
        keywordId.setId(keyWordId);
        keywordId.setDate(date);
        
        if(keywordId != null) {
            count = newBeeMallGoodsService.insertKeyword(keywordId);
        }
        if(!(count > 0))  {
        return ResultGenerator.genFailResult("投稿失敗！");
        }      
        return ResultGenerator.genSuccessResult(count);    
    }
  
}