/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service;

import java.util.List;

import ltd.newbee.mall.controller.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.CampaignSet;
import ltd.newbee.mall.entity.CategoryIdAndId;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.Price;
import ltd.newbee.mall.entity.TbCategory;
import ltd.newbee.mall.entity.TbSale;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

public interface NewBeeMallCategoryService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCategorisPage(PageQueryUtil pageUtil);

    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回分类数据(首页调用)
     *
     * @return
     */
    List<NewBeeMallIndexCategoryVO> getCategoriesForIndex();

    /**
     * 返回分类数据(搜索页调用)
     *
     * @param categoryId
     * @return
     */
    SearchPageCategoryVO getCategoriesForSearch(Long categoryId);

    /**
     * 根据parentId和level获取分类列表
     *
     * @param parentIds
     * @param categoryLevel
     * @return
     */
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
    /* 
     * niuxiaofeng
     * add by niu 2021/05/28
     * selectByLevelAndParentIds
     */
    List<GoodsCategory> findCategoryIds();
    /* 
     * niuxiaofeng
     * sale 2021/05/28
     */
    List<TbSale>TbSale(Long goodsId); 
    List<TbCategory>TbCategory(Long id);
    
    List<TbSale> TbsaleGoods(Long id);
    List<TbCategory> CategoryGoods(Long id);
    /* 
     * niuxiaofeng
     * sale 2021/05/30
     * CategoryIdAndName
     */
    List<CategoryIdAndId>CategoryIdAndName(Long categoryId);
    /* 
     * niuxiaofeng
     * sale 2021/05/30
     * deleteId
     */
    Boolean deleteCaId(Long categoryId); 
    /* 
     * niuxiaofeng
     * sale 2021/06/01
     * CampaignSet
     */
    int campaignSet(CampaignSet categoryId);
    /* 
     * niuxiaofeng
     * sale 2021/06/02
     * getcampaignMaxId
     */
    Long campaignMaxId();
    /* 
     * niuxiaofeng
     * 2021/06/04
     * getSecondCategoryIdAndName
     */
    List<CategoryIdAndId>SecondCategoryIdAndName(Long categoryId);

    List<Price> calculationPrice(Long categoryId);

    Boolean deleteTbsaleAndCampSet(Long id);  
}  

