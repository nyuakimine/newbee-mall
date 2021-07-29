package ltd.newbee.mall.controller.mall;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.dao.NewBeeMallGoodsMapper;
import ltd.newbee.mall.entity.DetailTitle;
import ltd.newbee.mall.entity.RestaurantDesc;
import ltd.newbee.mall.entity.TabelogCategory;
import ltd.newbee.mall.entity.TbGenre;
import ltd.newbee.mall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.service.NewBeeMallGoodsService;

@SpringBootTest
class GoodsControllerTest<ReviewUserInf, GoodsImageEntity> {

//    private static final GoodsQa GoodsQa = null;
//    private static final String  = null;
    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    private NewBeeMallGoodsService newBeeMallCarouselService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;
    @Autowired
    private NewBeeMallGoodsMapper goodsMapper;

    @Test
    public void testGetDetailTitle() {
	long id = 1L;
	List<DetailTitle> list = goodsMapper.getDetailTitle(id);
	DetailTitle dt = list.get(0);
	String name = dt.getName();
	assertEquals("nn", name);
	String star = dt.getStar();
	assertEquals("nn", star);
	String score = dt.getScore();
	assertEquals("nn", score);
	String commentNum = dt.getCommentNum();
	assertEquals("nn", commentNum);
	String saveNum = dt.getSaveNum();
	assertEquals("nn", saveNum);
    }

    @Test
    public void testGoodsImageService() {
	long id = 1L;
	List<RestaurantDesc> list = goodsMapper.getRestaurantDesc(id);
	RestaurantDesc rd = list.get(0);
	String nearbyStation = rd.getNearbyStation();
	assertEquals("nn", nearbyStation);
	long genreId = rd.getGenreId();
	assertEquals(11L, genreId);
	String nightBudget = rd.getNightBudget();
	assertEquals("nn", nightBudget);
	String dayBudget = rd.getDayBudget();
	assertEquals("nn", dayBudget);
	String restDay = rd.getRestDay();
	assertEquals("nn", restDay);
	String genreName = rd.getGenreName();
	assertEquals("nn", genreName);

    }

    @Test
    public void testTabelogCategory() {
	long parentId = 1L;
	List<TabelogCategory> list = goodsMapper.getTabelogCategory(parentId);
	TabelogCategory tc = list.get(0);
	long categoryId = tc.getCategoryId();
	assertEquals(1, categoryId);
	String categoryName = tc.getCategoryName();
	assertEquals("1", categoryName);
    }

    @Test
    public void testTbGenre() {
	long genreId = 1L;
	List<TbGenre> list = goodsMapper.getTbGenre(genreId);
	TbGenre tg = list.get(0);
	String name1 = tg.getName1();
	assertEquals("11", name1);
	String name2 = tg.getName2();
	assertEquals("111", name2);
	String name3 = tg.getName3();
	assertEquals("1111", name3);
    }

//    @Test
//    public void testGoodsImageService() {
//	long o = 10700L;
//
//	List<GoodsImage> list = newBeeMallGoodsService.getGoodsImageEntityByGoodsId(o);
//
//	GoodsImage z = list.get(0);
//	Long goodsId = z.getGoodsId();
//	assertEquals(10700, goodsId);
//
//	GoodsImage r = list.get(0);
//	String path = r.getPath();
//	assertEquals("/goods-img/5488564b-8335-4b0c-a5a4-52f3f03ee728.jpg", path);
//
//    }
//
//    @Test
//    public void test1() {
//	long r = 10700L;
//	List<GoodsDesc> list = newBeeMallGoodsService.getGoodsDescEntityByGoodsId(r);
//
//	GoodsDesc z = list.get(0);
//	Long goodsId = z.getGoodsId();
//	assertEquals(10700, goodsId);
//
//	GoodsDesc n = list.get(0);
//	String color = n.getColor();
//	assertEquals("黑色", color);
//
//	GoodsDesc l = list.get(0);
//	String size = l.getSize();
//	assertEquals("77.3mm*163.5mm*8.8mm", size);
//
//	GoodsDesc a = list.get(0);
//	String material = a.getMaterial();
//	assertEquals("LCD", material);
//
//	GoodsDesc b = list.get(0);
//	String weight = b.getWeight();
//	assertEquals("196.8g", weight);
//
//	GoodsDesc c = list.get(0);
//	String warrantyYear = c.getWarrantyYear();
//	assertEquals("3年", warrantyYear);
//
//	GoodsDesc d = list.get(0);
//	String setDate = d.getSetDate();
//	assertEquals("3分", setDate);
//
//	GoodsDesc e = list.get(0);
//	String warpSize = e.getWarpSize();
//	assertEquals("30cm*50cm", warpSize);
//
//    }
//
//    @Test
//    public void test2() {
//	long r = 10700L;
//
//	List<GoodsQa> list = newBeeMallGoodsService.getGoodsQaEntityByGoodsId(r);
//
//	GoodsQa z = list.get(0);
//	Long goodsId = z.getGoodsId();
//	assertEquals(10700, goodsId);
//
//	GoodsQa p = list.get(0);
//	String question = p.getQuestion();
//	assertEquals("半額でしてくれる？", question);
//
//	GoodsQa f = list.get(0);
//	java.util.Date submitDate = f.getSubmitDate();
//	assertEquals("2050-04-29 00:00:00", submitDate);
//
//	GoodsQa g = list.get(0);
//	String answer = g.getAnswer();
//	assertEquals("だめ！", answer);
//
//	GoodsQa h = list.get(0);
//	java.util.Date answerDate = h.getAnswerDate();
//	assertEquals("1998-05-06 00:00:00", answerDate);
//
//	GoodsQa i = list.get(0);
//	String helpedNum = i.getHelpedNum();
//	assertEquals("999", helpedNum);
//
//	GoodsQa j = list.get(0);
//	Long id = j.getId();
//	assertEquals("001", id);
//
//    }
//
//    @Test
//    public void test3() {
//	long o = 10700L;
//	List<GoodsReview> list = newBeeMallGoodsService.getGoodsReviewEntityByGoodsId(o);
//
//	GoodsReview z = list.get(0);
//	Long goodsId = z.getGoodsId();
//	assertEquals(10700, goodsId);
//
//	GoodsReview p = list.get(0);
//	int id = p.getId();
//	assertEquals(10691, id);
//
//	GoodsReview k = list.get(0);
//	Integer star = k.getStar();
//	assertEquals(4, star);
//
//	GoodsReview l = list.get(0);
//	String commentDate = l.getCommentDate();
//	assertEquals("2021-04-15 00:00:00", commentDate);
//
//	GoodsReview m = list.get(0);
//	String title = m.getTitle();
//	assertEquals("安すぎる", title);
//
//	GoodsReview n = list.get(0);
//	String content = n.getContent();
//	assertEquals("壊れてる", content);
//
//	GoodsReview s = list.get(0);
//	String picture = s.getPicture();
//	assertEquals("56", picture);
//
//	GoodsReview q = list.get(0);
//	String custermerId = q.getCustermerId();
//	assertEquals("1", custermerId);
//
//    }
//
//    @Test
//    public void test4() {
//	long p = 10700L;
//
//	List<ReviewUserInfo> list = (List<ReviewUserInfo>) newBeeMallGoodsService.getReviewUserInfoEntityByGoodsId(p);
//
//	ReviewUserInfo e = list.get(0);
//	String title = e.getTitle();
//	assertEquals("安すぎる", title);
//
//	ReviewUserInfo k = list.get(0);
//	Integer star = k.getStar();
//	assertEquals(4, star);
//
//	ReviewUserInfo n = list.get(0);
//	String content = n.getContent();
//	assertEquals("壊れてる", content);
//
//	ReviewUserInfo s = list.get(0);
//	String picture = s.getPicture();
//	assertEquals("56", picture);
//
//	ReviewUserInfo l = list.get(0);
//	String commentDate = l.getCommentDate();
//	assertEquals("2021-04-15 00:00:00", commentDate);
//
//	ReviewUserInfo y = list.get(0);
//	String nickName = y.getNickName();
//	assertEquals("十三", nickName);
//
//	ReviewUserInfo z = list.get(0);
//	String goodsName = z.getGoodsName();
//	assertEquals("荣耀8X 千元屏霸 91%屏占比 2000万AI双摄", goodsName);
//    }
//
//    // Paginationのtest
//    @Test
//    public void testPagination() {
//
//	Map<String, Object> params = new HashMap<String, Object>();
//	params.put("page", "1");
//	params.put("limit", "3");
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult a = newBeeMallGoodsService.getPaginationEntityByGoodsId(pageUtil);
//
//	List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
//	int size = 0;
//	if (qaList != null || !qaList.isEmpty()) {
//	    size = qaList.size();
//	}
//	assertEquals(3, size);
//
//	assertEquals("1", qaList.get(0).getId());
//	assertEquals("2", qaList.get(1).getId());
//	assertEquals("3", qaList.get(2).getId());
//    }
//
//    // niu
//    @Test
//    public void testSort() {
//	Map<String, Object> params = new HashMap<String, Object>();
////                     params.put("orderBy","id"); 
//	params.put("orderBy", "B");
//	params.put("page", "1");
//	params.put("limit", "3");
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult a = newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);
//
//	List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
//	int size = 0;
//	if (qaList != null || !qaList.isEmpty()) {
//	    size = qaList.size();
//	}
//	assertEquals(3, size);
//	assertEquals("2563", qaList.get(2).getHelpedNum());
//	assertEquals("999", qaList.get(0).getHelpedNum());
//	assertEquals("989", qaList.get(1).getHelpedNum());
//    }
//
//    // 20210427
//    @Test
//    public void testHelpedNumSort() {
//	Map<String, Object> params = new HashMap<String, Object>();
//	// params.put("orderBy","id");
//	params.put("orderBy", "submitDate");
//	params.put("page", "1");
//	params.put("limit", "3");
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult a = newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);
//
//	List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
//	int size = 0;
//	if (qaList != null || !qaList.isEmpty()) {
//	    size = qaList.size();
//	}
//	assertEquals(3, size);
//	assertEquals("2021-04-15 00:00:00", qaList.get(2).getSubmitDate());
//	assertEquals("2050-04-29 00:00:00", qaList.get(0).getSubmitDate());
//	assertEquals("2040-05-06 00:00:00", qaList.get(1).getSubmitDate());
////	 params.put("orderBy","submitDate"); 
////	 PageResult b =newBeeMallGoodsService.getSubmitDateEntityByGoodsId(pageUtil);
//    }
//
//    @Test
//    public void testInsertGoods() {
//	GoodsQa qa = new GoodsQa();
//	qa.setId(22L);
//	qa.setQuestion("变绿变绿变绿变绿!!!");
//	qa.setAnswer("好运来变绿！！！");
//	// qa.setSubmitDate(20140205);
//	// qa.setAnswerDate(20100806);
//	qa.setGoodsId(1256L);
//	String v = newBeeMallGoodsService.saveGoodsQa(qa);
//	assertEquals(ServiceResultEnum.SUCCESS.getResult(), v);
//    }
//2021/05/18
//    @Test
//    public void testGoodsSale() {
//	long o = 1L;
//
//	List<GoodsSale> list = newBeeMallGoodsService.GoodsSale(o);
//
//	Long id = list.get(0).getId();
//	assertEquals(1, id);
//
//	String name = list.get(0).getName();
//	assertEquals("大甩卖", name);

    // SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

//	GoodsSale a = list.get(0);
//	java.util.Date startDate = a.getStartDate();
//	assertEquals(2021/05/13, startDate);
//
//	GoodsSale c = list.get(0);
//	java.util.Date endDate = c.getEndDate();
//	assertEquals(2021-04-04, endDate);

//	String campaign = list.get(0).getCampaign();
//	assertEquals("满三百减一百", campaign);
//	
//	String content1 = list.get(0).getContent1();
//	assertEquals(null, content1);
//	
//	String content2 = list.get(0).getContent2();
//	assertEquals(null, content2);
//	
//	String content3 = list.get(0).getContent3();
//	assertEquals(null, content3);
//    
//	String content4 = list.get(0).getContent4();
//	assertEquals(null, content4);
//	
//	String content5 = list.get(0).getContent5();
//	assertEquals(null, content5);
//
//	String flag = list.get(0).getFlag();
//	assertEquals(null, flag);
//    }

    // TbSale
//    @Test
//    public void testTbSale() {
//	long o = 1L;
//
//	List<TbSale> list = newBeeMallGoodsService.TbSale(o);
//
//	Long id = list.get(0).getId();
//	assertEquals(1, id);
//
//	String name = list.get(0).getName();
//	assertEquals("大甩卖", name);

//  @Test
//  public void testSaPage() {
//
//	Map<String, Object> params = new HashMap<String, Object>();
//	params.put("page",1);
//	params.put("limit",10);
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult a = newBeeMallGoodsService.goodsSalePagAndSort(pageUtil);
//
//	List<GoodsSale> qaList = (List<GoodsSale>) a.getList();
//	int size = 0;
//	if (qaList != null || !qaList.isEmpty()) {
//	    size = qaList.size();
//	}
//	assertEquals(3, size);
//	Long q = 1L;
//	Long b = 2L;
//	Long c = 5L;
//	assertEquals(q, qaList.get(0).getId());
//	assertEquals(b, qaList.get(1).getId());
//	assertEquals(c, qaList.get(2).getId());
//  }
    // 獲取數據，page是1時初始化頁面
//    @Test
//    public void testPage1() {
//	Map<String, Object> params = new HashMap<>();
//	params.put("page", 1);
//	params.put("limit", 2);
//	// params.put("keyword", "甩");
//	params.put("ascOrDesc", "desc");
//	// params.put("ascOrDesc", "asc");
//	params.put("orderBy", "id");
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult result = newBeeMallGoodsService.goodsSalePagAndSort((pageUtil));
//	List<GoodsSale> List = (List<GoodsSale>) result.getList();
//	// confirm size = limit
//	int size = 0;
//	if (List != null || !List.isEmpty()) {
//	    size = List.size();
//	}
//	assertEquals(2, size);
//	Long a = 1L;
//	Long b = 2L;
//	assertEquals(a, List.get(0).getId());
//	assertEquals(b, List.get(1).getId());
//	assertEquals("大甩卖", List.get(0).getName());
//	assertEquals("清倉處理", List.get(1).getName());
//	SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
//	String startDate1 = dmyFormat.format(List.get(0).getStartDate());
//	String startDate2 = dmyFormat.format(List.get(1).getStartDate());
//	String endDate3 = dmyFormat.format(List.get(0).getEndDate());
//	String endDate4 = dmyFormat.format(List.get(1).getEndDate());
//	assertEquals("2021-05-13", startDate1);
//	assertEquals("2021-05-13", startDate2);
//	assertEquals("2021-04-04", endDate3);
//	assertEquals("2022-04-04", endDate4);
//	assertEquals("满三百减一百", List.get(0).getCampaign());
//	assertEquals("买一送一", List.get(1).getCampaign());
//	assertEquals(null, List.get(0).getContent1());
//	assertEquals(null, List.get(1).getContent1());
//	assertEquals(null, List.get(0).getContent2());
//	assertEquals(null, List.get(1).getContent2());
//	assertEquals("有效", List.get(0).getFlag());
//	assertEquals("有效", List.get(1).getFlag());
//    }
//
////下一頁
//    @Test
//    public void testPage2() {
//	Map<String, Object> params = new HashMap<>();
//	params.put("page", 2);
//	params.put("limit", 2);
//	// params.put("keyword", "甩");
//	params.put("ascOrDesc", "desc");
//	// params.put("ascOrDesc", "asc");
//	params.put("orderBy", "id");
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult result = newBeeMallGoodsService.goodsSalePagAndSort((pageUtil));
//	List<GoodsSale> List = (List<GoodsSale>) result.getList();
//	// confirm size = limit
//	int size = 0;
//	if (List != null || !List.isEmpty()) {
//	    size = List.size();
//	}
//	assertEquals(2, size);
//	Long a = 3L;
//	Long b = 4L;
//	assertEquals(a, List.get(0).getId());
//	assertEquals(b, List.get(1).getId());
//	assertEquals("雙十一", List.get(0).getName());
//	assertEquals("年末大降價", List.get(1).getName());
//	SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
//	String startDate1 = dmyFormat.format(List.get(0).getStartDate());
//	String startDate2 = dmyFormat.format(List.get(1).getStartDate());
//	String endDate3 = dmyFormat.format(List.get(0).getEndDate());
//	String endDate4 = dmyFormat.format(List.get(1).getEndDate());
//	assertEquals("2021-05-15", startDate1);
//	assertEquals("2021-05-16", startDate2);
//	assertEquals("2022-05-01", endDate3);
//	assertEquals("2026-03-04", endDate4);
//	assertEquals("打折50%", List.get(0).getCampaign());
//	assertEquals("直降九九九", List.get(1).getCampaign());
//	assertEquals(null, List.get(0).getContent1());
//	assertEquals(null, List.get(1).getContent1());
//	assertEquals(null, List.get(0).getContent2());
//	assertEquals(null, List.get(1).getContent2());
//	assertEquals("無效", List.get(0).getFlag());
//	assertEquals("無效", List.get(1).getFlag());
//    }
//
//    // keyword
//    @Test
//    public void testKeyword() {
//	Map<String, Object> params = new HashMap<>();
//	params.put("page", 1);
//	params.put("limit", 3);
//	params.put("keyword", "甩");
//	// params.put("ascOrDesc", "desc");
//	params.put("ascOrDesc", "asc");
//	params.put("orderBy", "id");
//	PageQueryUtil pageUtil = new PageQueryUtil(params);
//	PageResult result = newBeeMallGoodsService.goodsSalePagAndSort((pageUtil));
//	List<GoodsSale> List = (List<GoodsSale>) result.getList();
//	// confirm size = limit
//	int size = 0;
//	if (List != null || !List.isEmpty()) {
//	    size = List.size();
//	}
//	assertEquals(1, size);
//	Long a = 1L;
//	assertEquals(a, List.get(0).getId());
//
//	assertEquals("大甩卖", List.get(0).getName());
//
//	SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
//	String startDate1 = dmyFormat.format(List.get(0).getStartDate());
//	String endDate3 = dmyFormat.format(List.get(0).getEndDate());
//	assertEquals("2021-05-13", startDate1);
//	assertEquals("2021-04-04", endDate3);
//
//	assertEquals("满三百减一百", List.get(0).getCampaign());
//
//	assertEquals(null, List.get(0).getContent1());
//
//	assertEquals(null, List.get(0).getContent2());
//
//	assertEquals("有效", List.get(0).getFlag());
//    }

    // 2021/06/03 カテゴリの抽出&該当カテゴリがキャンペーンの適応有無をチェックする。
//    @Test
//    public void testTCategory() {
//	Long categoryId = 16L;
//	List<CategoryIdAndId> tCategory = newBeeMallCategoryService.CategoryIdAndName(categoryId);
//	CategoryIdAndId z = tCategory.get(1);
//	Long id = z.getId();
//	assertEquals(7, id);
//	String categoryName = tCategory.get(1).getCategoryName();
//    	assertEquals("女装 男装 穿搭", categoryName);
//    	Long parentId = tCategory.get(1).getParentId();
//    	assertEquals(0, parentId);
//	SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
//	String startDate1 = dmyFormat.format(tCategory.get(1).getStartDate());
//	String endDate3 = dmyFormat.format(tCategory.get(1).getEndDate());
//	assertEquals("2021-06-02", startDate1);
//	assertEquals("2021-06-04", endDate3);
//    }
//    //2021/06/03 キャンペーンの抽出
//    @Test
//       public void testGoodsSale() {
//    	List<GoodsSale> list = newBeeMallGoodsService.GoodsSale();
//    
//    	Long id = list.get(0).getId();
//    	assertEquals(1, id);
//    
//    	String name = list.get(0).getName();
//    	assertEquals("大甩卖", name);
//
//        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
// 	String startDate1 = dmyFormat.format(list.get(0).getStartDate());
// 	String endDate3 = dmyFormat.format(list.get(0).getEndDate());
// 	assertEquals("2021-05-13", startDate1);
// 	assertEquals("2022-04-04", endDate3);
//
//    	String campaign = list.get(0).getCampaign();
//    	assertEquals("满三百减一百", campaign);
//    	
//    	String content1 = list.get(0).getContent1();
//    	assertEquals(null, content1);
//    	
//    	String content2 = list.get(0).getContent2();
//    	assertEquals(null, content2);
//    	
//    	String content3 = list.get(0).getContent3();
//    	assertEquals(null, content3);
//        
//    	String content4 = list.get(0).getContent4();
//    	assertEquals(null, content4);
//    	
//    	String content5 = list.get(0).getContent5();
//    	assertEquals(null, content5);
//    
//    	String flag = list.get(0).getFlag();
//    	assertEquals("有效", flag);
//        }
//    
//  @Test
//  public void testInsertCategory() {
//	CategoryIdAndId Category = new CategoryIdAndId();
//	Category.setCategoryId(59L);
//	//Category.setCategoryName("运动 户外 乐器");
//	Category.setId(2L);
//	//Category.setStartDate("变绿变绿变绿变绿!!!");
//	//Category.setEndDate("好运来变绿！！！");
//	//String v = newBeeMallCategoryService.TbCategory(Long id);
//	//assertEquals(ServiceResultEnum.SUCCESS.getResult(), v);
//  }
//    //2021/06/03
//    @Test
//    public void testDeleteCaId() {
//	Long categoryId = 15L;
//	boolean deleteResult = newBeeMallCategoryService.deleteCaId(categoryId);
//	  
//    }
}