/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TopPostphoto {

	private Long id;
	private String headingTitle;
	private Long likeNum;
	private String postDate;
	private String rstLink;
	private String sideComment;
	private String sideRvwTitle;
	private String topBigPostphotocolPath;
	private String topPostphotoMoreLink;
	private String topPostphotocolPath;
	private String userIconLink;
	private String userName;
	private Long userId;
	private Long imgId;
	private String any3;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeadingTitle() {
		return headingTitle;
	}

	public void setHeadingTitle(String headingTitle) {
		this.headingTitle = headingTitle;
	}

	public Long getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Long likeNum) {
		this.likeNum = likeNum;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getRstLink() {
		return rstLink;
	}

	public void setRstLink(String rstLink) {
		this.rstLink = rstLink;
	}

	public String getSideComment() {
		return sideComment;
	}

	public void setSideComment(String sideComment) {
		this.sideComment = sideComment;
	}

	public String getSideRvwTitle() {
		return sideRvwTitle;
	}

	public void setSideRvwTitle(String sideRvwTitle) {
		this.sideRvwTitle = sideRvwTitle;
	}

	public String getTopBigPostphotocolPath() {
		return topBigPostphotocolPath;
	}

	public void setTopBigPostphotocolPath(String topBigPostphotocolPath) {
		this.topBigPostphotocolPath = topBigPostphotocolPath;
	}

	public String getTopPostphotoMoreLink() {
		return topPostphotoMoreLink;
	}

	public void setTopPostphotoMoreLink(String topPostphotoMoreLink) {
		this.topPostphotoMoreLink = topPostphotoMoreLink;
	}

	public String getTopPostphotocolPath() {
		return topPostphotocolPath;
	}

	public void setTopPostphotocolPath(String topPostphotocolPath) {
		this.topPostphotocolPath = topPostphotocolPath;
	}

	public String getUserIconLink() {
		return userIconLink;
	}

	public void setUserIconLink(String userIconLink) {
		this.userIconLink = userIconLink;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public String getAny3() {
		return any3;
	}

	public void setAny3(String any3) {
		this.any3 = any3;
	}

	@Override
	public String toString() {
		return "TopPostphoto [id=" + id + ", headingTitle=" + headingTitle + ", likeNum=" + likeNum + ", postDate="
				+ postDate + ", rstLink=" + rstLink + ", sideComment=" + sideComment + ", sideRvwTitle=" + sideRvwTitle
				+ ", topBigPostphotocolPath=" + topBigPostphotocolPath + ", topPostphotoMoreLink="
				+ topPostphotoMoreLink + ", topPostphotocolPath=" + topPostphotocolPath + ", userIconLink="
				+ userIconLink + ", userName=" + userName + ", userId=" + userId + ", imgId=" + imgId + ", any3=" + any3
				+ "]";
	}


}