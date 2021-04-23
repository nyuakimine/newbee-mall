package ltd.newbee.mall.controller.mall;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;

import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

@SpringBootTest
class GoodsControllerTest<ReviewUserInf, GoodsImageEntity> {

    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void testGoodsImageService() {
	long o = 10700L;

	List<GoodsImage> list = newBeeMallGoodsService.getGoodsImageEntityByGoodsId(o);

	GoodsImage z = list.get(0);
	Long goodsId = z.getGoodsId();
	assertEquals(10700, goodsId);

	
	GoodsImage r = list.get(0);
	String path = r.getPath();
	assertEquals("/goods-img/5488564b-8335-4b0c-a5a4-52f3f03ee728.jpg", path);

    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test1() {
	long r = 10700L;
	List<GoodsDesc> list = newBeeMallGoodsService.getGoodsDescEntityByGoodsId(r);
	
	GoodsDesc z = list.get(0);
	Long goodsId = z.getGoodsId();
	assertEquals(10700, goodsId);

	GoodsDesc n = list.get(0);
	String color = n.getColor();
	assertEquals("黑色", color);

	GoodsDesc l = list.get(0);
	String size = l.getSize();
	assertEquals("77.3mm*163.5mm*8.8mm", size);

	GoodsDesc a = list.get(0);
	String material = a.getMaterial();
	assertEquals("LCD", material);

	GoodsDesc b = list.get(0);
	String weight = b.getWeight();
	assertEquals("196.8g", weight);

	GoodsDesc c = list.get(0);
	String warrantyYear = c.getWarrantyYear();
	assertEquals("3年", warrantyYear);

	GoodsDesc d = list.get(0);
	String setDate = d.getSetDate();
	assertEquals("3分", setDate);

	GoodsDesc e = list.get(0);
	String warpSize = e.getWarpSize();
	assertEquals("30cm*50cm", warpSize);

    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test2() {
	long r = 10700L;

	List<GoodsQa> list = newBeeMallGoodsService.getGoodsQaEntityByGoodsId(r);
	
	GoodsQa z = list.get(0);
	Long goodsId = z.getGoodsId();
	assertEquals(10700, goodsId);

	GoodsQa p = list.get(0);
	String question = p.getQuestion();
	assertEquals("半額でしてくれる？", question);

	GoodsQa f = list.get(0);
	String submitDate = f.getSubmitDate();
	assertEquals("2050-04-29 00:00:00", submitDate);

	GoodsQa g = list.get(0);
	String answer = g.getAnswer();
	assertEquals("だめ！", answer);

	GoodsQa h = list.get(0);
	String answerDate = h.getAnswerDate();
	assertEquals("1998-05-06 00:00:00", answerDate);

	GoodsQa i = list.get(0);
	String helpedNum = i.getHelpedNum();
	assertEquals("999", helpedNum);

	GoodsQa j = list.get(0);
	String id = j.getId();
	assertEquals("001", id);

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test3() {
	long o = 10700L;
	List<GoodsReview> list = newBeeMallGoodsService.getGoodsReviewEntityByGoodsId(o);
	
	GoodsReview z = list.get(0);
	Long goodsId = z.getGoodsId();
	assertEquals(10700, goodsId);

	GoodsReview p = list.get(0);
	String id = p.getId();
	assertEquals("10691", id);

	GoodsReview k = list.get(0);
	Integer star = k.getStar();
	assertEquals(4, star);

	GoodsReview l = list.get(0);
	String commentDate = l.getCommentDate();
	assertEquals("2021-04-15 00:00:00", commentDate);

	GoodsReview m = list.get(0);
	String title = m.getTitle();
	assertEquals("安すぎる", title);

	GoodsReview n = list.get(0);
	String content = n.getContent();
	assertEquals("壊れてる", content);

	GoodsReview s = list.get(0);
	String picture = s.getPicture();
	assertEquals("56", picture);

	GoodsReview q = list.get(0);
	String custermerId = q.getCustermerId();
	assertEquals("1", custermerId);

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test4() {
	long p = 10700L;

	List<ReviewUserInfo> list = (List<ReviewUserInfo>) newBeeMallGoodsService.getReviewUserInfoEntityByGoodsId(p);

	ReviewUserInfo e = list.get(0);
	String title = e.getTitle();
	assertEquals("安すぎる", title);

	ReviewUserInfo k = list.get(0);
	Integer star = k.getStar();
	assertEquals(4, star);

	ReviewUserInfo n = list.get(0);
	String content = n.getContent();
	assertEquals("壊れてる", content);

	ReviewUserInfo s = list.get(0);
	String picture = s.getPicture();
	assertEquals("56", picture);

	ReviewUserInfo l = list.get(0);
	String commentDate = l.getCommentDate();
	assertEquals("2021-04-15 00:00:00", commentDate);

	ReviewUserInfo y = list.get(0);
	String nickName = y.getNickName();
	assertEquals("十三", nickName);

	ReviewUserInfo z = list.get(0);
	String goodsName = z.getGoodsName();
	assertEquals("荣耀8X 千元屏霸 91%屏占比 2000万AI双摄", goodsName);
    }
 
     @Test
      public void testPagination() { 
             Map<String,Object> params = new HashMap<String,Object>();
             params.put("page","1"); 
             params.put("limit","3");
             PageQueryUtil pageUtil = new PageQueryUtil(params); 
             PageResult a =newBeeMallGoodsService.getPaginationEntityByGoodsId(pageUtil);
	      
	        List<GoodsQa>qaList = (List<GoodsQa>) a.getList();
	        int size = 0;
	        if(qaList != null || !qaList.isEmpty()) {
	          size = qaList.size(); 
	          }
	        assertEquals(3,size); 
	        GoodsQa expect1 = new GoodsQa();
	        expect1.setId("001");
	        expect1.setQuestion("半額でしてくれる？");
	        expect1.setSubmitDate("2050-04-29 00:00:00");
	        expect1.setAnswer("だめ！");
	        expect1.setAnswerDate("1998-05-06 00:00:00");
	        expect1.setHelpedNum("999");
	      
	        GoodsQa expect2 = new GoodsQa();
	        expect2.setId("002");
	        expect2.setQuestion("どこに住んでますか");
	        expect2.setSubmitDate("2040-05-06 00:00:00");
	        expect2.setAnswer("日本");
	        expect2.setAnswerDate("1990-05-07 00:00:00");
	        expect2.setHelpedNum("989");
	        GoodsQa expect3 = new GoodsQa();
	        expect3.setId("003");
	        expect3.setQuestion("この商品の耐久性がありますか");
	        expect3.setSubmitDate("2021-04-15 00:00:00");
	        expect3.setAnswer("壊れやすい");
	        expect3.setAnswerDate("2021-04-15 00:00:00");
	        expect3.setHelpedNum("2563");
	        List<GoodsQa> expectList = new ArrayList<GoodsQa>();
	        expectList.add(expect1);
	        expectList.add(expect2);
	        expectList.add(expect3);
	        Boolean isTrue = qaList.equals(expectList);
	        assertEquals(false,isTrue);
	       
      
      }
     
    
}
