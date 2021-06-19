/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.CampaignSet;
import ltd.newbee.mall.entity.CategoryIdAndId;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.Price;
import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.entity.TbCategory;
import ltd.newbee.mall.entity.TbSale;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long categoryId);

    GoodsCategory selectByLevelAndName(@Param("categoryLevel") Byte categoryLevel, @Param("categoryName") String categoryName);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

    List<GoodsCategory> findGoodsCategoryList(PageQueryUtil pageUtil);

    int getTotalGoodsCategories(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);

    List<TbSale> getTbSale(Long goodsId); 
    List<TbCategory> getTbCategory(Long categoryId);
  //selectByLevelAndParentIds 2021/05/28
    List<GoodsCategory> findCategoryId();
    
    List<TbSale> getTbsaleGoods(Long id);
    List<TbCategory> getCategoryGoods(Long id);
    //2021/05/30
    List<CategoryIdAndId>getCategoryIdAndName(Long categoryId);  
    //2021/05/30
    int deletePaK(Long categoryId);
    //2021/06/01 
    int insertCampaignSet(CampaignSet categoryId);
    //2021/06/02 getcampaignMaxId
    Long getCampaignMaxId();
    //2021/06/04 getSecondCategoryIdAndName
    List<CategoryIdAndId>getSecondCategoryIdAndName(Long categoryId);  
    List<Price>getPrice(Long categoryId);
    int deleteTbsale(Long id);  
}