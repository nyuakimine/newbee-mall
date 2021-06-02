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
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.CampaignSet;
import ltd.newbee.mall.entity.CategoryIdAndId;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.GoodsReviewHelpNum;
import ltd.newbee.mall.entity.GoodsSale;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.TbCategory;
import ltd.newbee.mall.entity.TbSale;
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
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
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
   public String category(HttpServletRequest request,Long categoryId,GoodsSale id) {
         //該当カテゴリがキャンペーンの適応有無をチェックする。
         List<CategoryIdAndId> tCategory = newBeeMallCategoryService.CategoryIdAndName(categoryId); 
         //キャンペーンの抽出
         List<GoodsSale> goodsSaleList = newBeeMallGoodsService.GoodsSale();
         request.setAttribute("goodsSaleList", goodsSaleList);
         request.setAttribute("tCategory", tCategory);
         return "admin/goodsCategory";
        }
   @PostMapping(value = "/delete/categoryId")
   @ResponseBody
   public Result deleteId(@RequestBody Long categoryId) {
       boolean deleteResult = newBeeMallCategoryService.deleteCaId(categoryId);
       //删除成功
       if (deleteResult) {
           return ResultGenerator.genSuccessResult();
       }
       //删除失败
       return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
   }
 
   //added by niu 2021/06/02 insertprimaryGoods
   @RequestMapping(value = "/goods/primaryGoods", method = RequestMethod.POST)
   @ResponseBody
   public Result insertprimaryGoods(@RequestBody CampaignSet categoryId) {
       CampaignSet list = new CampaignSet();
       Integer count = null;
       Long saleId = newBeeMallCategoryService.campaignMaxId(categoryId.getId()); 
       list.setId(saleId);
       list.setPrimaryGoodsId(categoryId.getPrimaryGoodsId());
//       list.setSubGoodsId(categoryId.getSubGoodsId());
       if(list != null) {
           count = newBeeMallCategoryService.campaignSet(list);
       }
       if(!(count > 0))  {
       return ResultGenerator.genFailResult("投稿失敗！");
       }      
       return ResultGenerator.genSuccessResult(count);    
   }
   //added by niu 2021/06/01 insertTbcategory
   @RequestMapping(value = "/goods/inserTbcategory", method = RequestMethod.POST)
   @ResponseBody
   public Result insertCategory(@RequestBody TbCategory id) {
       Boolean count = null;  
       id.getStartDate();
       id.getEndDate();
       if(id != null) {
           count = newBeeMallGoodsService.insertTbCategory(id);
       }
       if(!(count))  {
       return ResultGenerator.genFailResult("投稿失敗！");
       }      
       return ResultGenerator.genSuccessResult(count);    
   }
}