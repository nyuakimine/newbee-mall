/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.admin;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallCategoryLevelEnum;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@Controller
@RequestMapping("/admin")
public class GoodsCategoryController {
    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;

    @GetMapping({ "/goodsCategory","/goodsCategory.html" })
    
    public String goodsCategory(@RequestParam Map<String, Object> params, HttpServletRequest request) {
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
	
	return "admin/goodsCategory";
    }
}