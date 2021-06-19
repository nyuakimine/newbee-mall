/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.entity.CampaignSet;
import ltd.newbee.mall.entity.CategoryIdAndId;
import ltd.newbee.mall.entity.GoodsSale;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.SaleIdAndInfo;
import ltd.newbee.mall.entity.TbCategory;
import ltd.newbee.mall.entity.TbSale;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
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
public class GoodsCategoryController {
    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;
  
   @GetMapping({ "/goodsCategory","/goodsCategory.html" })
   public String category(HttpServletRequest request,Long categoryId,GoodsSale id,Long goodsId) {
         //該当カテゴリがキャンペーンの適応有無をチェックする。
         List<CategoryIdAndId> tCategory = newBeeMallCategoryService.CategoryIdAndName(categoryId); 
         //キャンペーンの抽出
         List<GoodsSale> goodsSaleList = newBeeMallGoodsService.GoodsSale();
         request.setAttribute("goodsSaleList", goodsSaleList);
         request.setAttribute("tCategory", tCategory);
         return "admin/goodsCategory";
        }
   //added by niu 2021/06/02 insertprimaryGoods
   @RequestMapping(value = "/goods/primaryGoods", method = RequestMethod.POST)
   @ResponseBody
   public Result insertPrimaryGoods(@RequestBody CampaignSet campaignSet) {
       TbSale list = new TbSale();
       Integer count = null;
       Integer countTs = null;
       Long saleId = newBeeMallCategoryService.campaignMaxId();
       campaignSet.setId(saleId);
       list.setId(campaignSet.getCampaginId());
       list.setGoodsId(campaignSet.getPrimaryGoodsId());
       list.setStartDate(campaignSet.getStartDate());
       list.setEndDate(campaignSet.getEndDate());
       if(campaignSet !=null) {
	   countTs = newBeeMallGoodsService.insertTbSale(list);
       }
       if(list != null) {
           count = newBeeMallCategoryService.campaignSet(campaignSet);
       }
       if(!(count > 0))  {
       return ResultGenerator.genFailResult("投稿失敗！");
       }      
       return ResultGenerator.genSuccessResult(count);    
   }
   //added by niu 2021/06/04 SecondCategoryIdAndName
   @RequestMapping(value = "/secondCategory", method = RequestMethod.POST)
   @ResponseBody
   public Result popup(@RequestBody Long categoryId) {
       Map<Object, List> result = new HashMap<>();
       Long parentId = categoryId;
       Long goodsCategoryId = categoryId;
       List<GoodsSale> gsM = newBeeMallGoodsService.GoodsSale();
       List<CategoryIdAndId> cm = newBeeMallCategoryService.SecondCategoryIdAndName(parentId);
       List<SaleIdAndInfo> goodsList = newBeeMallGoodsService.getSubGoods(goodsCategoryId);
       if (!goodsList.isEmpty()) {
	   result.put("gsM", gsM);
	   result.put("list", goodsList);
       } else {
	   result.put("gsM", gsM);
	   result.put("list", cm);
       }
       return ResultGenerator.genSuccessResult(result);
   }
   //added by niu 2021/06/01 insertTbcategory
   @RequestMapping(value = "/insertAndDeleteCategory", method = RequestMethod.POST)
   @ResponseBody
   public Result insertAndDeleteCategory(@RequestBody TbCategory tbCategory) {
       Integer count = null;
       if (!tbCategory.getFlag()) {
	   Boolean deleteResult = newBeeMallCategoryService.deleteCaId(tbCategory.getCategoryId());
	   if (deleteResult) {
	       return ResultGenerator.genSuccessResult();
	   }
	   return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
       } else {
	   Boolean insert = newBeeMallGoodsService.insertTbCategory(tbCategory);
	   if (insert) {
	       if (tbCategory != null) {
		   count = newBeeMallGoodsService.insertTbCategoryId(tbCategory);
	       }
	       if (!(count > 0)) {
		   return ResultGenerator.genFailResult("投稿失敗！");
	       }
	       return ResultGenerator.genSuccessResult(count);
	   }
	   return ResultGenerator.genFailResult("有効期限外！");
       }
   }
   // @PostMapping("/subGoodsName")
   @RequestMapping(value = "/subGoodsName", method = RequestMethod.POST)
   @ResponseBody
   public Result getGiftGoods(@RequestBody SaleIdAndInfo saleIdAndInfo) {
       if(!saleIdAndInfo.getFlag()){//删除成功
	   boolean deleteResult = newBeeMallCategoryService.deleteTbsaleAndCampSet(saleIdAndInfo.getGoodsId());
       if(deleteResult) {
           return ResultGenerator.genSuccessResult();
      }
       return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
       } else {
	   List<SaleIdAndInfo> goodsList = newBeeMallGoodsService.getSubGoods(saleIdAndInfo.getGoodsCategoryId());
   return ResultGenerator.genSuccessResult(goodsList);
       }
   }
}