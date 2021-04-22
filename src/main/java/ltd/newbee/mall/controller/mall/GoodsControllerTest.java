package ltd.newbee.mall.controller.mall;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.entity.GoodsDesc;
import ltd.newbee.mall.entity.GoodsImage;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.ReviewUserInfo;
import ltd.newbee.mall.service.NewBeeMallGoodsService;

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
	assertEquals("この商品の耐久性がありますか", question);

	GoodsQa f = list.get(0);
	String submitDate = f.getSubmitDate();
	assertEquals("2021-04-15 00:00:00", submitDate);

	GoodsQa g = list.get(0);
	String answer = g.getAnswer();
	assertEquals("はい、そうですね、スカイツリーから落ちても問題ないです", answer);

	GoodsQa h = list.get(0);
	String answerDate = h.getAnswerDate();
	assertEquals("2021-04-15 00:00:00", answerDate);

	GoodsQa i = list.get(0);
	String helpedNum = i.getHelpedNum();
	assertEquals("10", helpedNum);

	GoodsQa j = list.get(0);
	String id = j.getId();
	assertEquals("1", id);

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test3() {
	long o = 10700L;
	List<GoodsReview> list =

		newBeeMallGoodsService.getGoodsReviewEntityByGoodsId(o);
	
	GoodsReview z = list.get(0);
	Long goodsId = z.getGoodsId();
	assertEquals(10700, goodsId);

	GoodsReview p = list.get(0);
	String id = p.getId();
	assertEquals("1", id);

	GoodsReview k = list.get(0);
	Integer star = k.getStar();
	assertEquals(5, star);

	GoodsReview l = list.get(0);
	String commentDate = l.getCommentDate();
	assertEquals("2021-04-15 00:00:00", commentDate);

	GoodsReview m = list.get(0);
	String title = m.getTitle();
	assertEquals("安い", title);

	GoodsReview n = list.get(0);
	String content = n.getContent();
	assertEquals("コンパクト", content);

	GoodsReview s = list.get(0);
	String picture = s.getPicture();
	assertEquals("215", picture);

	GoodsReview q = list.get(2);
	String custermerId = q.getCustermerId();
	assertEquals("6", custermerId);

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test4() {
	long o = 10700L;

	List<ReviewUserInfo> list = (List<ReviewUserInfo>) newBeeMallGoodsService.getReviewUserInfoEntityByGoodsId(o);

	ReviewUserInfo e = list.get(0);
	String title = e.getTitle();
	assertEquals("安い", title);

	ReviewUserInfo k = list.get(0);
	Integer star = k.getStar();
	assertEquals(5, star);

	ReviewUserInfo n = list.get(0);
	String content = n.getContent();
	assertEquals("コンパクト", content);

	ReviewUserInfo s = list.get(0);
	String picture = s.getPicture();
	assertEquals("215", picture);

	ReviewUserInfo l = list.get(0);
	String commentDate = l.getCommentDate();
	assertEquals("2021-04-15 00:00:00", commentDate);

	ReviewUserInfo y = list.get(0);
	String nickName = y.getNickName();
	assertEquals("测试用户1", nickName);

	ReviewUserInfo z = list.get(0);
	String goodsName = z.getGoodsName();
	assertEquals("荣耀8X 千元屏霸 91%屏占比 2000万AI双摄", goodsName);

    }

}
