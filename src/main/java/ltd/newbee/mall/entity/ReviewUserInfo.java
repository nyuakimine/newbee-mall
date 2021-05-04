/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 *//*
package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ReviewUserInfo {
	private Integer id;
    private String star;
    private String custermerId;
    private String commentDate;
    private String goodsId;
    private String title;
    private String content;
    private String picture;
    private String userId;
    private String nickName;
    private String loginName;
    private String passwordMd5;
    private String introduceSign;
    private String address;
    private String isDeleted;
    private String lockedFlag;
    private String createTime;
    private String goodsName;
    private String goodsIntro;
    private String goodsCategoryId;
    private String goodsCoverImg;
    private String goodsCarousel;
    private String goodsDetailContent;
    private String originalPrice;
    private String sellingPrice;
    private String stockNum;
    private String tag;
    private String goodsSellStatus;
    private String createUser;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getCustermerId() {
		return custermerId;
	}
	public void setCustermerId(String custermerId) {
		this.custermerId = custermerId;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswordMd5() {
		return passwordMd5;
	}
	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}
	public String getIntroduceSign() {
		return introduceSign;
	}
	public void setIntroduceSign(String introduceSign) {
		this.introduceSign = introduceSign;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getLockedFlag() {
		return lockedFlag;
	}
	public void setLockedFlag(String lockedFlag) {
		this.lockedFlag = lockedFlag;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	public String getGoodsCategoryId() {
		return goodsCategoryId;
	}
	public void setGoodsCategoryId(String goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}
	public String getGoodsCoverImg() {
		return goodsCoverImg;
	}
	public void setGoodsCoverImg(String goodsCoverImg) {
		this.goodsCoverImg = goodsCoverImg;
	}
	public String getGoodsCarousel() {
		return goodsCarousel;
	}
	public void setGoodsCarousel(String goodsCarousel) {
		this.goodsCarousel = goodsCarousel;
	}
	public String getGoodsDetailContent() {
		return goodsDetailContent;
	}
	public void setGoodsDetailContent(String goodsDetailContent) {
		this.goodsDetailContent = goodsDetailContent;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getStockNum() {
		return stockNum;
	}
	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getGoodsSellStatus() {
		return goodsSellStatus;
	}
	public void setGoodsSellStatus(String goodsSellStatus) {
		this.goodsSellStatus = goodsSellStatus;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	private String updateUser;
    private String updateTime;


}

*/




package ltd.newbee.mall.entity;

import java.util.Date;

public class ReviewUserInfo {	;
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
    return "ReviewUserInfo [goodsId=" + goodsId + ", star=" + star + ", commentDate=" + commentDate + ", title=" + title
	    + ", content=" + content + ", picture=" + picture + ", nickName=" + nickName + ", goodsName=" + goodsName
	    + ", reviewNum=" + reviewNum + "]";
}
	
}