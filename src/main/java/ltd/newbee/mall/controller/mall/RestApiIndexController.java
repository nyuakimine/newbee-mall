/** 
   * 严肃声明： 
   * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！ 
   * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！ 
   * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！ 
   * Copyright (c) 2019-2020 十三 all rights reserved. 
   * 版权所有，侵权必究！ 
   */
package ltd.newbee.mall.controller.mall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.IndexConfigTypeEnum;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallIndexCarouselVO;
import ltd.newbee.mall.controller.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.controller.vo.NewBeeMallIndexConfigGoodsVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.DetailTitle;
import ltd.newbee.mall.entity.GenreAndStation;
import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.GoodsReviewHelpNum;
import ltd.newbee.mall.entity.ModalLikeNum;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.PagingQa;
import ltd.newbee.mall.entity.RestaurantDesc;
import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.entity.TabelogCategory;
import ltd.newbee.mall.entity.TbGenre;
import ltd.newbee.mall.entity.TopCoupon;
import ltd.newbee.mall.entity.TopCourse;
import ltd.newbee.mall.entity.TopHygiene;
import ltd.newbee.mall.entity.TopImg;
import ltd.newbee.mall.entity.TopKodawari;
import ltd.newbee.mall.entity.TopNoticeComment;
import ltd.newbee.mall.entity.TopPostphoto;
import ltd.newbee.mall.service.NewBeeMallCarouselService;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
//import ltd.newbee.mall.util.TotalAndAvg;

@Controller
public class RestApiIndexController {

	@Resource
	private NewBeeMallGoodsService newBeeMallGoodsService;
	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;
	@Resource
	private NewBeeMallCarouselService newBeeMallCarouselService;
	@Resource
	private NewBeeMallIndexConfigService newBeeMallIndexConfigService;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	@ResponseBody
	public Result categories() {
		List<NewBeeMallIndexCategoryVO> categories = newBeeMallCategoryService.getCategoriesForIndex();
		if (CollectionUtils.isEmpty(categories)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(categories);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/carousels", method = RequestMethod.POST)
	@ResponseBody
	public Result carousels() {
		List<NewBeeMallIndexCarouselVO> carousels = newBeeMallCarouselService
				.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
		if (CollectionUtils.isEmpty(carousels)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(carousels);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/hotGoodses", method = RequestMethod.POST)
	@ResponseBody
	public Result hotGoodses() {
		List<NewBeeMallIndexConfigGoodsVO> hotGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(
				IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
		if (CollectionUtils.isEmpty(hotGoodses)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(hotGoodses);
		}
	}

//20210706
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/newAndRecommendGoodses", method = RequestMethod.POST)
	@ResponseBody
	public Result newAndRecommendGoodses() {
		Map<Object, List> result = new HashMap<>();
		List<NewBeeMallIndexConfigGoodsVO> newGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(
				IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
		List<NewBeeMallIndexConfigGoodsVO> recommendGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(
				IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);
		result.put("newGoodses", newGoodses);
		result.put("recommendGoodses", recommendGoodses);
		return ResultGenerator.genSuccessResult(result);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	@GetMapping(value = "/detailLeftImg/{goodsId}")
	public Result detailLeftImg(@PathVariable("goodsId") Long goodsId) {
		List<GoodsImage> imageList = newBeeMallGoodsService.getGoodsImageEntityByGoodsId(goodsId);
		return ResultGenerator.genSuccessResult(imageList);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	@GetMapping(value = "/descList/{goodsId}")
	public Result descList(@PathVariable("goodsId") Long goodsId) {
		List<GoodsDesc> descList = newBeeMallGoodsService.getGoodsDescEntityByGoodsId(goodsId);
		return ResultGenerator.genSuccessResult(descList);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	@GetMapping(value = "/qaList/{goodsId}")
	public Result qaList(@PathVariable("goodsId") Long goodsId) {
		List<GoodsQa> qaList = newBeeMallGoodsService.getGoodsQaEntityByGoodsId(goodsId);
		return ResultGenerator.genSuccessResult(qaList);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/reviewList/{goodsId}")
	@ResponseBody
	public Result reviewList(@PathVariable("goodsId") Long goodsId) {
		List<ReviewUserInfo> reviewList = newBeeMallGoodsService.getReviewUserInfoEntityByGoodsId(goodsId);
		return ResultGenerator.genSuccessResult(reviewList);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/qaPaging")
	@ResponseBody
	public Result getHelpedNumEntityByGoodsId(@RequestBody PagingQa page) {
		if (page.getPage() == -1) {
			Map<String, Object> pages = new HashMap<>();
			pages.put("page", 1);
			pages.put("limit", 3);
			PageQueryUtil pageRe = new PageQueryUtil(pages);
			PageResult lastPage = newBeeMallGoodsService.getHelpedNumEntityByGoodsId((pageRe));
			int x = lastPage.getCurrPage();
			x = lastPage.getTotalPage();

			Map<String, Object> last = new HashMap<>();
			last.put("page", x);
			last.put("limit", 3);
			PageQueryUtil p = new PageQueryUtil(last);
			PageResult lastPageRe = newBeeMallGoodsService.getHelpedNumEntityByGoodsId((p));
			return ResultGenerator.genSuccessResult(lastPageRe);
		} else {
			Map<String, Object> params = new HashMap<>();
			params.put("page", page.getPage());
			params.put("limit", 3);
			PageQueryUtil pageUtil = new PageQueryUtil(params);
			PageResult a = newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);
			return ResultGenerator.genSuccessResult(a);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@CrossOrigin(origins = "http://localhost:3000")
	// @SuppressWarnings("rawtypes")
	@PostMapping(value = "/showAndCloseReview")
	@ResponseBody
	public Result showReviewList(@RequestBody ReviewUserInfo reviewUserInfo) {

		List<ReviewUserInfo> showFilter = new ArrayList<ReviewUserInfo>();
		if (reviewUserInfo.getIds() == null || StringUtils.isEmpty(reviewUserInfo.getIds())) {
			Map<String, Object> result = new HashMap<>();
			result.put("page", 1);
			result.put("goodsId", reviewUserInfo.getGoodsId());
			result.put("limit", Constants.GOODS_QA_PAGE_LIMIT);
			PageQueryUtil pageUtil = new PageQueryUtil(result);
			PageResult showThreeLists = newBeeMallGoodsService.getOpenReview(pageUtil);

			return ResultGenerator.genSuccessResult(showThreeLists);
		} else {
			
			Integer[] reviewIds = reviewUserInfo.getIds();
			List<Integer> filterList = Arrays.asList(reviewIds);
			
			List<ReviewUserInfo> showAll = newBeeMallGoodsService
					.getReviewUserInfoEntityByGoodsId(reviewUserInfo.getGoodsId());
			
			showFilter = showAll.stream().filter(el -> !filterList.contains(el.getId())).collect(Collectors.toList());
			return ResultGenerator.genSuccessResult(showFilter);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/insertQa")
	@ResponseBody
	public Result insertGoodsQaSelective(@RequestBody GoodsQa question) {
		Integer count = null;
		Long qaId = newBeeMallGoodsService.getMaxQaId(question.getGoodsId());
		question.setId(qaId);
		Date submitDate = new Date();
		Date answerDate = new Date();
		question.setSubmitDate(submitDate);
		question.setAnswerDate(answerDate);
		if (question != null) {
			count = newBeeMallGoodsService.insertGoodsQaSelective(question);
		}
		if (!(count > 0)) {
			return ResultGenerator.genFailResult("投稿失敗！");
		}
		return ResultGenerator.genSuccessResult(count);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/helpNum", method = RequestMethod.POST)
	@ResponseBody
	public Result helpNum(@RequestBody GoodsReviewHelpNum reviewId, HttpSession httpSession) {
		NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
		if (user != null) {
			reviewId.setUserId(user.getUserId());
		}
		boolean addFlag = newBeeMallGoodsService.addHelpNum(reviewId);
		if (addFlag) {
			boolean updateFlag = newBeeMallGoodsService.updateReviewNum(reviewId);
			if (updateFlag) {
				long helpNum = newBeeMallGoodsService.getGoodsReviewHelpNum(reviewId.getReviewId());
				return ResultGenerator.genSuccessResult(helpNum);
			} else {
				return ResultGenerator.genFailResult("改修失敗！！！");
			}
		} else {
			return ResultGenerator.genFailResult("挿入失敗！！！");
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/detailTitle", method = RequestMethod.POST)
	@ResponseBody
	public Result detailTitle(@RequestBody DetailTitle detail) {
		 int totalCount=newBeeMallGoodsService.tbCommentTotal();
		 double tbCommentAvg =newBeeMallGoodsService.tbCommentAvg();
		List<DetailTitle> detailTitle = newBeeMallGoodsService.detailTitle(detail.getId());
		detailTitle.get(0).getScore();
		detailTitle.get(0).setScore(tbCommentAvg);
		detailTitle.get(0).getCommentNum();
		detailTitle.get(0).setCommentNum(totalCount);
		
		if (CollectionUtils.isEmpty(detailTitle)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(detailTitle);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/restaurantDesc", method = RequestMethod.POST)
	@ResponseBody
	public Result restaurantDesc(@RequestBody RestaurantDesc restaurantDesc) {
		List<RestaurantDesc> restaurant = newBeeMallGoodsService.restaurantDesc(restaurantDesc.getId());
		if (CollectionUtils.isEmpty(restaurant)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(restaurant);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/tabelogCategory", method = RequestMethod.POST)
	@ResponseBody
	public Result tabelogCategory(@RequestParam Long parentId) {
		List<TabelogCategory> tabelogCategory = newBeeMallGoodsService.tabelogCategory(parentId);
		if (CollectionUtils.isEmpty(tabelogCategory)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(tabelogCategory);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/tbGenre", method = RequestMethod.POST)
	@ResponseBody
	public Result tbGenre(@RequestParam Long genreId) {
		List<TbGenre> tbGenre = newBeeMallGoodsService.tbGenre(genreId);
		if (CollectionUtils.isEmpty(tbGenre)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(tbGenre);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/genreAndStation", method = RequestMethod.POST)
	@ResponseBody
	public Result GenreAndStation(@RequestBody GenreAndStation genreAndStation) {
		List<GenreAndStation> GenreAndStation = newBeeMallGoodsService.genreAndStationList(genreAndStation.getId());
		if (CollectionUtils.isEmpty(GenreAndStation)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(GenreAndStation);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topNoticeComment", method = RequestMethod.POST)
	@ResponseBody
	public Result TopNoticeComment(@RequestBody TopNoticeComment topNoticeComment) {
		List<TopNoticeComment> topList = newBeeMallGoodsService.topNoticeComment(topNoticeComment.getId());
		if (CollectionUtils.isEmpty(topList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(topList);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topImg", method = RequestMethod.POST)
	@ResponseBody
	public Result topImg(@RequestBody TopImg topImg) {
		List<TopImg> topImgList = newBeeMallGoodsService.topImg(topImg.getId());
		if (CollectionUtils.isEmpty(topImgList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(topImgList);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topKodawari", method = RequestMethod.POST)
	@ResponseBody
	public Result topKodawari(@RequestBody TopKodawari topKodawari) {
		List<TopKodawari> kodawariList = newBeeMallGoodsService.topKodawari(topKodawari.getId());
		if (CollectionUtils.isEmpty(kodawariList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(kodawariList);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topHygiene", method = RequestMethod.POST)
	@ResponseBody
	public Result topHygiene(@RequestBody TopHygiene topHygiene) {
		List<TopHygiene> topHygieneList = newBeeMallGoodsService.topHygiene(topHygiene.getId());
		if (CollectionUtils.isEmpty(topHygieneList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(topHygieneList);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topCourse", method = RequestMethod.POST)
	@ResponseBody
	public Result topCourse(@RequestBody TopCourse topCourse) {
		List<TopCourse> topCourseList = newBeeMallGoodsService.topCourse(topCourse.getId());
		if (CollectionUtils.isEmpty(topCourseList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(topCourseList);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topCoupon", method = RequestMethod.POST)
	@ResponseBody
	public Result topCoupon(@RequestBody TopCoupon topCoupon) {
		List<TopCoupon> topCouponList = newBeeMallGoodsService.topCoupon(topCoupon.getId());
		if (CollectionUtils.isEmpty(topCouponList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(topCouponList);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/topPostphoto", method = RequestMethod.POST)
	@ResponseBody
	public Result topPostphoto(@RequestBody TopPostphoto topPostphoto) {
		List<TopPostphoto> topPostphotoList = newBeeMallGoodsService.topPostphoto(topPostphoto.getId());
		if (CollectionUtils.isEmpty(topPostphotoList)) {
			return ResultGenerator.genErrorResult(Constants.CATEGORY_FETCH_ERROR,
					Constants.CATEGORY_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(topPostphotoList);
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/modalLikeNum", method = RequestMethod.POST)
	@ResponseBody
	public Result modalLikeNum(@RequestBody ModalLikeNum modalLikeNum) {
//		, HttpSession httpSession
//		TopPostphoto user = (TopPostphoto) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
//		if (user != null) {
//			modalLikeNum.setUserId(user.getUserId());
//		}
		boolean addFlag = newBeeMallGoodsService.addLikeNum(modalLikeNum);
		if (addFlag) {
			boolean updateFlag = newBeeMallGoodsService.updateLikeNum(modalLikeNum);
			if (updateFlag) {
				long likeNum = newBeeMallGoodsService.topPostphotoLikeNum(modalLikeNum.getLikeId());
				return ResultGenerator.genSuccessResult(likeNum);
			} else {
				return ResultGenerator.genFailResult("改修失敗！！！");
			}
		} else {
			return ResultGenerator.genFailResult("挿入失敗！！！");
		}
	}
}