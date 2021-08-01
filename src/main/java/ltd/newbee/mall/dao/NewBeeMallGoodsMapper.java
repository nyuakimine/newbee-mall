/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ltd.newbee.mall.entity.DetailTitle;
import ltd.newbee.mall.entity.GenreAndStation;
import ltd.newbee.mall.entity.GoodsCoupon;
import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.GoodsReviewHelpNum;
import ltd.newbee.mall.entity.GoodsSale;
import ltd.newbee.mall.entity.InsertKeyword;
import ltd.newbee.mall.entity.ModalLikeNum;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.RestaurantDesc;
import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.entity.SaleIdAndInfo;
import ltd.newbee.mall.entity.StockNumDTO;
import ltd.newbee.mall.entity.TabelogCategory;
import ltd.newbee.mall.entity.TbCategory;
import ltd.newbee.mall.entity.TbGenre;
import ltd.newbee.mall.entity.TbSale;
import ltd.newbee.mall.entity.TopCoupon;
import ltd.newbee.mall.entity.TopCourse;
import ltd.newbee.mall.entity.TopHygiene;
import ltd.newbee.mall.entity.TopImg;
import ltd.newbee.mall.entity.TopKodawari;
import ltd.newbee.mall.entity.TopNoticeComment;
import ltd.newbee.mall.entity.TopPostphoto;
import ltd.newbee.mall.util.PageQueryUtil;

public interface NewBeeMallGoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(NewBeeMallGoods record);

    int insertSelective(NewBeeMallGoods record);

    NewBeeMallGoods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(NewBeeMallGoods record);

    int updateByPrimaryKeyWithBLOBs(NewBeeMallGoods record);

    int updateByPrimaryKey(NewBeeMallGoods record);

    List<NewBeeMallGoods> findNewBeeMallGoodsList(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoods(PageQueryUtil pageUtil);

    List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds);

    List<NewBeeMallGoods> findNewBeeMallGoodsListBySearch(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoodsBySearch(PageQueryUtil pageUtil);

    int batchInsert(@Param("newBeeMallGoodsList") List<NewBeeMallGoods> newBeeMallGoodsList);

    int updateStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    int batchUpdateSellStatus(@Param("orderIds")Long[] orderIds,@Param("sellStatus") int sellStatus);

    int getTotalGoodsQa(PageQueryUtil pageUtil);
     /**
     * @param goodsId
     * @return
     */
    List<GoodsImage> getImageList(Long goodsId); 
    //get goodsReview
    List<GoodsReview> getGoodsReview(Long goodsId);
    List<GoodsQa> getGoodsQa(Long goodsId);   
    List<GoodsDesc> getGoodsDesc(Long goodsId);
  
    List<ReviewUserInfo> getReviewUserInfoList(Long goodsId);
    List<GoodsQa> getPagination(PageQueryUtil pageUtil);
    /**
     * @param helped,SubmitDate排序
     * @retur
     */
    List<GoodsQa> getHelpedNum(PageQueryUtil pageUtil);
    List<GoodsQa> getSubmitDate(PageQueryUtil pageUtil);
    /**
     * @param insertGoodsQuestionRequired
     * @retur
     */
    int insertGoodsQa(GoodsQa question);
    //added by niu 2021/04/29 qaInsert
    int insertGoodsQaSelective(GoodsQa question);
    //get max qa id
    Long getMaxQaId(Long goodsId);    
    boolean insertHelpNum(GoodsReviewHelpNum goodsReviewHelpNum);
    boolean updateReviewNum(GoodsReviewHelpNum goodsReviewHelpNum);
    long getGoodsReviewHelpNum(int reviewId);
    //insertKeyWord by niu 2021/05/10
    int instKeyword(InsertKeyword keywordId);
    //getMaxKeywordID
    Long getMaxKeywordId(Long userId);
    //sale 2021/05/11
    List<TbSale> getTbSale(Long id); 
    List<TbCategory> getTbCategory(Long id);
    List<GoodsSale> getGoodsSale();   
    List<GoodsCoupon> getGoodsCoupon(Long couponId);
    //sale insert 2021/05/11
    int insertTbSale(TbSale id);
    //int insertTbCategory(TbCategory id);
    int insertGoodsSale(GoodsSale id);
    int insertGoodsCoupon(GoodsCoupon couponId);
    String saveInsertKeyword(InsertKeyword insertKeyword);
    //Download add by niu 2021/05/14 
    List<GoodsSale> getGoodsSaleDownload(Integer[] ids);
    //goodsSalePagAndSort add by niu 2021/05/16	
    List<GoodsSale> goodsSalePagAndSort(PageQueryUtil pageUtil);
    int getGoodsSaleTotal(PageQueryUtil pageUtil);
    Long insertSale(Long id);
    int getGoodsCouponTotal(PageQueryUtil pageUtil);
    //2021/06/01
    //List<GoodsSale> getGoodsSaleId(Long id);  
    //boolean insertTbCategory(TbCategory id);
    int insertTbCategory(TbCategory id);
    //判断是否在日期范围内
    List<GoodsSale> getGoodsSaleId(Long id);
    //获取赠送商品goodsId
    List<NewBeeMallGoods> findNewBeeMallGoodsListBySub(Long goodsId);
    List<SaleIdAndInfo> findNewBeeMallGoodsListByCategoryId(Long goodsId);

    List<GoodsSale> getGoodsSaleId(GoodsSale id);

    List<DetailTitle> getDetailTitle(Long id);

    List<RestaurantDesc> getRestaurantDesc(Long id);

    List<TabelogCategory> getTabelogCategory(Long parentId);

    List<TbGenre> getTbGenre(Long genreId);

	List<ReviewUserInfo> getOpenReview(PageQueryUtil pageUtil);

	int getTotalOpenReview(PageQueryUtil pageUtil);

	int getTbCommentTotal();

	double getTbCommentAvg();

	List<GenreAndStation> getGenreAndStationList(Long id);

	List<TopNoticeComment> getTopNoticeComment(Long id);

	List<TopImg> getTopImg(Long id);

	List<TopKodawari> getTopKodawari(Long id);

	List<TopHygiene> getTopHygiene(Long id);

	List<TopCourse> getTopCourse(Long id);

	List<TopCoupon> getTopCoupon(Long id);

	List<TopPostphoto> getTopPostphoto(Long id);

	boolean insertModalLikeNum(ModalLikeNum modalLikeNum);

	boolean updateTopPostphoto(ModalLikeNum modalLikeNum);

	long getTopPostphotoLikeNum(int likeId);
}