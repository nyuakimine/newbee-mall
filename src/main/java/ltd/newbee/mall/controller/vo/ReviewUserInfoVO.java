/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品详情页VO
 */
public class ReviewUserInfoVO implements Serializable {
	private Long goodsId;
	private Integer star; 
	private String commentDate; 
	private String title;
	private String content;  
	private String picture; 
	private String nickName;
	private String goodsName;
	private Long reviewNum;
	public Long getReviewNum() {
	    return reviewNum;
	}
	public void setReviewNum(Long reviewNum) {
	    this.reviewNum = reviewNum;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
	    return "ReviewUserInfoVO [goodsId=" + goodsId + ", star=" + star + ", commentDate=" + commentDate
		    + ", title=" + title + ", content=" + content + ", picture=" + picture + ", nickName=" + nickName
		    + ", goodsName=" + goodsName + ", reviewNum=" + reviewNum + "]";
	}

}
