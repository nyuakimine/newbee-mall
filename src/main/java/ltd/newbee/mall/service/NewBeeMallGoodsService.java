/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service;

import java.util.Date;
import java.util.List;

import ltd.newbee.mall.controller.vo.GoodsReviewVo;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.GoodsCoupon;
import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.GoodsReviewHelpNum;
import ltd.newbee.mall.entity.GoodsSale;
import ltd.newbee.mall.entity.IndexConfig;
import ltd.newbee.mall.entity.InsertKeyword;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.entity.TbCategory;
import ltd.newbee.mall.entity.TbSale;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

public interface NewBeeMallGoodsService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    String saveNewBeeMallGoods(NewBeeMallGoods goods);

    /**
     * 批量新增商品数据
     *
     * @param newBeeMallGoodsList
     * @return
     */
    void batchSaveNewBeeMallGoods(List<NewBeeMallGoods> newBeeMallGoodsList);

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    String updateNewBeeMallGoods(NewBeeMallGoods goods);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    NewBeeMallGoods getNewBeeMallGoodsById(Long id);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids
     * @return
     */
    Boolean batchUpdateSellStatus(Long[] ids,int sellStatus);

    /**
     * 商品搜索
     *
     * @param pageUtil
     * @return
     */
    PageResult searchNewBeeMallGoods(PageQueryUtil pageUtil);
    
    
    /*niuxiaofeng
     * ctrl+shift+o
     * 
     * Pagination 91
     */    
    List<GoodsImage> getGoodsImageEntityByGoodsId(Long goodsId);
    List<GoodsDesc> getGoodsDescEntityByGoodsId(Long goodsId);
    List<GoodsQa> getGoodsQaEntityByGoodsId(Long goodsId);
    List<GoodsReview> getGoodsReviewEntityByGoodsId(Long goodsId);
    List<ReviewUserInfo> getReviewUserInfoEntityByGoodsId(Long goodsId);    
    PageResult getPaginationEntityByGoodsId(PageQueryUtil pageUtil);

    /*niuxiaofeng
    *
    * helpedNum
    *submitDate排序
    */  
    PageResult getHelpedNumEntityByGoodsId(PageQueryUtil pageUtil);

    PageResult getSubmitDateEntityByGoodsId(PageQueryUtil pageUtil);

    int insertGoodsQaSelective(GoodsQa question);

    String saveGoodsQa(GoodsQa qa);

    String updateIndexConfig(IndexConfig indexConfig);
    
    Long getMaxQaId(Long goodsId);
    /* 
     * niuxiaofeng
     * show more review
     */
    List<GoodsReviewVo> getGoodsReviews(Long goodsId);
    /* 
     * niuxiaofeng
     * HelpNum
     */
    boolean addHelpNum(GoodsReviewHelpNum goodsReviewHelpNum);
    /* 
     * niuxiaofeng
     * updateReviewNum
     */
    boolean updateReviewNum(GoodsReviewHelpNum goodsReviewHelpNum);

    long getGoodsReviewHelpNum(int reviewId);
    /* 
     * niuxiaofeng
     * insertKeyWord by niu 20210510
     */
    int insertKeyword(InsertKeyword keywordId);
    /* 
     * niuxiaofeng
     * getMaxKeywordID
     */
    Long getMaxKeywordId(Long userId);
    /* 
     * niuxiaofeng
     * sale 2021/05/11
     */
    List<TbSale>TbSale(Long id); 
    List<TbCategory>TbCategory(Long id);
    List<GoodsSale>GoodsSale();   
    List<GoodsCoupon>GoodsCoupon(Long couponId);
    /* 
     * niuxiaofeng
     * sale insert 20210511
     */
    int insertTbSale(TbSale id);
    Boolean insertTbCategory(TbCategory id);
    int insertGoodsSale(GoodsSale id);
    int insertGoodsCoupon(GoodsCoupon couponId);
    /* 
     * niuxiaofeng
     * Download add by niu 2021/05/14 
     */
    List<GoodsSale> getGoodsSaleDownload(Integer[] ids);
    /* 
     * niuxiaofeng
     * add by niu 2021/05/16
     */
    PageResult goodsSalePagAndSort(PageQueryUtil pageUtil);
    /* 
     * niuxiaofeng
     * add by niu 2021/05/24
     * insertSaleMaxId
     */
    Long insertSale(Long id);
    /* 
     * niuxiaofeng
     * add by niu 2021/06/01
     * GoodsSale
     */
   // List<GoodsSale>GoodsSaleId(GoodsSale id); 
    /* 
     * niuxiaofeng
     * add by niu 2021/06/01
     * getCategoryMaxId
     */
   // Boolean CategoryMaxId(Long id);
   
}