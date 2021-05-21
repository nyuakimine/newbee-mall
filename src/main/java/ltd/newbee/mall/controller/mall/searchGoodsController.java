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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.GoodsDescVO;
import ltd.newbee.mall.controller.vo.GoodsImageVO;
import ltd.newbee.mall.controller.vo.GoodsQaVO;
import ltd.newbee.mall.controller.vo.GoodsReviewVo;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.controller.vo.ReviewUserInfoVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReviewHelpNum;
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

@RestController
public class searchGoodsController {

    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;
    //get hit goods
    @RequestMapping(value = "/goods/search", method = RequestMethod.GET)
    //public GoodsQa getHitGoodsList(@RequestBody String goodsName)
    //getの場合、@RequestBodyは使えない、postのみです。
    //getは@RequestParam
    //add by niu 202105010 //keyword
    public Result getHitGoodsList(@RequestParam String goodsName) {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("keyword",goodsName);       
        params.put("page",1); 
        params.put("limit",9);
       
        PageQueryUtil pageUtil = new PageQueryUtil(params); 
        PageResult a =newBeeMallGoodsService.searchNewBeeMallGoods(pageUtil);
        return ResultGenerator.genSuccessResult(a);
        }  
    //add by niu 2021/05/20 keyword
    @RequestMapping(value = "/goods/searchSale", method = RequestMethod.GET)
    public Result searchSale(@RequestParam String name) {
    	Map<String, Object> paramsSale = new HashMap<String, Object>();
    	paramsSale.put("keyword", name);
    	paramsSale.put("page", 1);
    	paramsSale.put("limit", 5);
        PageQueryUtil pageUtil = new PageQueryUtil(paramsSale);
        return ResultGenerator.genSuccessResult(newBeeMallGoodsService.goodsSalePagAndSort(pageUtil));
    }
}