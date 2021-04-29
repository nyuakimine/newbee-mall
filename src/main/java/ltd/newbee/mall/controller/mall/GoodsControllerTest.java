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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;

import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@SpringBootTest
class GoodsControllerTest<ReviewUserInf, GoodsImageEntity> {

    private static final GoodsQa GoodsQa = null;
    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    private NewBeeMallGoodsService newBeeMallCarouselService;
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
	java.util.Date submitDate = f.getSubmitDate();
	assertEquals("2050-04-29 00:00:00", submitDate);

	GoodsQa g = list.get(0);
	String answer = g.getAnswer();
	assertEquals("だめ！", answer);

	GoodsQa h = list.get(0);
	java.util.Date answerDate = h.getAnswerDate();
	assertEquals("1998-05-06 00:00:00", answerDate);

	GoodsQa i = list.get(0);
	String helpedNum = i.getHelpedNum();
	assertEquals("999", helpedNum);

	GoodsQa j = list.get(0);
	Long id = j.getId();
	assertEquals("001", id);

    }

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
 //Paginationのtest
     @Test
      public void testPagination() { 

             Map<String,Object> params = new HashMap<String,Object>();
             params.put("page","1"); 
             params.put("limit","3");
             PageQueryUtil pageUtil = new PageQueryUtil(params); 
             PageResult a =newBeeMallGoodsService.getPaginationEntityByGoodsId(pageUtil);
	      
	        List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
	        int size = 0;
	        if(qaList != null || !qaList.isEmpty()) {
	          size = qaList.size(); 
	          }
	        assertEquals(3,size); 
	      
	        assertEquals("1",qaList.get(0).getId());
	        assertEquals("2",qaList.get(1).getId());
	        assertEquals("3",qaList.get(2).getId());     
      }
     //niu
                 @Test
                 public void testSort() { 
                     Map<String,Object> params = new HashMap<String,Object>();
//                     params.put("orderBy","id"); 
                     params.put("orderBy","B"); 
                     params.put("page","1"); 
                     params.put("limit","3");
                     PageQueryUtil pageUtil = new PageQueryUtil(params); 
                     PageResult a =newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);  
                    
                     List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
            	        int size = 0;
            	        if(qaList != null || !qaList.isEmpty()) {
            	          size = qaList.size(); 
            	          }
            	        assertEquals(3,size); 	      
            	        assertEquals("2563",qaList.get(2).getHelpedNum());
            	        assertEquals("999",qaList.get(0).getHelpedNum());
            	        assertEquals("989",qaList.get(1).getHelpedNum());
                 }
            	    //20210427    
	        @Test
	        public void testHelpedNumSort() { 
	            Map<String,Object> params = new HashMap<String,Object>();
	           // params.put("orderBy","id"); 
	            params.put("orderBy","submitDate"); 
	            params.put("page","1"); 
	            params.put("limit","3");
	            PageQueryUtil pageUtil = new PageQueryUtil(params); 
	            PageResult a =newBeeMallGoodsService.getHelpedNumEntityByGoodsId(pageUtil);  
	           
	            List<GoodsQa> qaList = (List<GoodsQa>) a.getList();
	   	        int size = 0;
	   	        if(qaList != null || !qaList.isEmpty()) {
	   	          size = qaList.size(); 
	   	          }
	   	        assertEquals(3,size); 	      
	   	        assertEquals("2021-04-15 00:00:00",qaList.get(2).getSubmitDate());
	   	        assertEquals("2050-04-29 00:00:00",qaList.get(0).getSubmitDate());
	   	        assertEquals("2040-05-06 00:00:00",qaList.get(1).getSubmitDate());


//	 params.put("orderBy","submitDate"); 
//	 PageResult b =newBeeMallGoodsService.getSubmitDateEntityByGoodsId(pageUtil);
     }
     
         @Test
         public void testInsertGoods(){ 
    	 GoodsQa qa = new GoodsQa ();	
    	 qa.setId(22L);
    	 qa.setQuestion("变绿变绿变绿变绿!!!");			 
    	 qa.setAnswer("好运来变绿！！！");
    	 //qa.setSubmitDate(20140205);	 
    	 //qa.setAnswerDate(20100806);	 	
    	 qa.setGoodsId(1256L);
    	 String v = newBeeMallGoodsService.saveGoodsQa(qa);
             assertEquals(ServiceResultEnum.SUCCESS.getResult(),v);
         }
}
