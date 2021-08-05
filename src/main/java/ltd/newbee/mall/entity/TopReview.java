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

public class TopReview {
	private Long id;
	private String topPhotoPath;
	private String topImgPath1;
	private String rstdtlRvwTitle;
	private String clearfixComment;
	private String rvwMorePath;
	private String rvwDtlDate;
	private String dinnerStar;
	private String visitCount;
	private String lunchStar;
	private String likeCount;
	private String any1;
	private String any3;
	private String any2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopPhotoPath() {
		return topPhotoPath;
	}

	public void setTopPhotoPath(String topPhotoPath) {
		this.topPhotoPath = topPhotoPath;
	}

	public String getTopImgPath1() {
		return topImgPath1;
	}

	public void setTopImgPath1(String topImgPath1) {
		this.topImgPath1 = topImgPath1;
	}

	public String getRstdtlRvwTitle() {
		return rstdtlRvwTitle;
	}

	public void setRstdtlRvwTitle(String rstdtlRvwTitle) {
		this.rstdtlRvwTitle = rstdtlRvwTitle;
	}

	public String getClearfixComment() {
		return clearfixComment;
	}

	public void setClearfixComment(String clearfixComment) {
		this.clearfixComment = clearfixComment;
	}

	public String getRvwMorePath() {
		return rvwMorePath;
	}

	public void setRvwMorePath(String rvwMorePath) {
		this.rvwMorePath = rvwMorePath;
	}

	public String getRvwDtlDate() {
		return rvwDtlDate;
	}

	public void setRvwDtlDate(String rvwDtlDate) {
		this.rvwDtlDate = rvwDtlDate;
	}

	public String getDinnerStar() {
		return dinnerStar;
	}

	public void setDinnerStar(String dinnerStar) {
		this.dinnerStar = dinnerStar;
	}

	public String getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(String visitCount) {
		this.visitCount = visitCount;
	}

	public String getLunchStar() {
		return lunchStar;
	}

	public void setLunchStar(String lunchStar) {
		this.lunchStar = lunchStar;
	}

	public String getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}

	public String getAny1() {
		return any1;
	}

	public void setAny1(String any1) {
		this.any1 = any1;
	}

	public String getAny3() {
		return any3;
	}

	public void setAny3(String any3) {
		this.any3 = any3;
	}

	public String getAny2() {
		return any2;
	}

	public void setAny2(String any2) {
		this.any2 = any2;
	}

	@Override
	public String toString() {
		return "TopReview [id=" + id + ", topPhotoPath=" + topPhotoPath + ", topImgPath1=" + topImgPath1
				+ ", rstdtlRvwTitle=" + rstdtlRvwTitle + ", clearfixComment=" + clearfixComment + ", rvwMorePath="
				+ rvwMorePath + ", rvwDtlDate=" + rvwDtlDate + ", dinnerStar=" + dinnerStar + ", visitCount="
				+ visitCount + ", lunchStar=" + lunchStar + ", likeCount=" + likeCount + ", any1=" + any1 + ", any3="
				+ any3 + ", any2=" + any2 + "]";
	}

}