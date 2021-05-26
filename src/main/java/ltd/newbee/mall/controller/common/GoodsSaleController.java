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
import ltd.newbee.mall.entity.GoodsQa;
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
	params.put("limit",10);//Constants.GOODS_SEARCH_PAGE_LIMIT
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
    //added by niu 2021/05/24 insertSale
    @RequestMapping(value = "/goods/insertSale", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSale(@RequestBody GoodsSale goodsSale) {
	GoodsSale list = new GoodsSale();
        Integer count = null;  
        Long saleId = newBeeMallGoodsService.insertSale(goodsSale.getId());
        list.setId(saleId);
        list.setName(goodsSale.getName());
        list.setStartDate(goodsSale.getStartDate());
        list.setEndDate(goodsSale.getEndDate());
        list.setCampaign(goodsSale.getCampaign());
        list.setContent1(goodsSale.getContent1());
        list.setContent2(goodsSale.getContent2());
        list.setContent3(goodsSale.getContent3());
        list.setContent4(goodsSale.getContent4());
        list.setContent5(goodsSale.getContent5());
        list.setFlag(goodsSale.getFlag());
        if(list != null) {
            count = newBeeMallGoodsService.insertGoodsSale(list);
        }
        if(!(count > 0))  {
        return ResultGenerator.genFailResult("投稿失敗！");
        }      
        return ResultGenerator.genSuccessResult(count);    
    }
}