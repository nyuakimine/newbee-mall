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

public class TopCourse {

	private Long id;
	private String courseBtn;
	private String courseListDesc;
	private String courseListLabel;
	private String courseListLabel2;
	private String courseMember;
	private String coursePriceNum;
	private String coursePath;
	private String courseTitleText;
	private String imgPath;
	private String priceNumTax;
	private String yoyakuBtn;
	private String headingTitle;
	private String courseMoreLink; 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseBtn() {
		return courseBtn;
	}
	public void setCourseBtn(String courseBtn) {
		this.courseBtn = courseBtn;
	}
	public String getCourseListDesc() {
		return courseListDesc;
	}
	public void setCourseListDesc(String courseListDesc) {
		this.courseListDesc = courseListDesc;
	}
	public String getCourseListLabel() {
		return courseListLabel;
	}
	public void setCourseListLabel(String courseListLabel) {
		this.courseListLabel = courseListLabel;
	}
	public String getCourseListLabel2() {
		return courseListLabel2;
	}
	public void setCourseListLabel2(String courseListLabel2) {
		this.courseListLabel2 = courseListLabel2;
	}
	public String getCourseMember() {
		return courseMember;
	}
	public void setCourseMember(String courseMember) {
		this.courseMember = courseMember;
	}
	public String getCoursePriceNum() {
		return coursePriceNum;
	}
	public void setCoursePriceNum(String coursePriceNum) {
		this.coursePriceNum = coursePriceNum;
	}
	public String getCoursePath() {
		return coursePath;
	}
	public void setCoursePath(String coursePath) {
		this.coursePath = coursePath;
	}
	public String getCourseTitleText() {
		return courseTitleText;
	}
	public void setCourseTitleText(String courseTitleText) {
		this.courseTitleText = courseTitleText;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getPriceNumTax() {
		return priceNumTax;
	}
	public void setPriceNumTax(String priceNumTax) {
		this.priceNumTax = priceNumTax;
	}
	public String getYoyakuBtn() {
		return yoyakuBtn;
	}
	public void setYoyakuBtn(String yoyakuBtn) {
		this.yoyakuBtn = yoyakuBtn;
	}
	public String getHeadingTitle() {
		return headingTitle;
	}
	public void setHeadingTitle(String headingTitle) {
		this.headingTitle = headingTitle;
	}
	
	public String getCourseMoreLink() {
		return courseMoreLink;
	}
	public void setCourseMoreLink(String courseMoreLink) {
		this.courseMoreLink = courseMoreLink;
	}
	@Override
	public String toString() {
		return "TopCourse [id=" + id + ", courseBtn=" + courseBtn + ", courseListDesc=" + courseListDesc
				+ ", courseListLabel=" + courseListLabel + ", courseListLabel2=" + courseListLabel2 + ", courseMember="
				+ courseMember + ", coursePriceNum=" + coursePriceNum + ", coursePath=" + coursePath
				+ ", courseTitleText=" + courseTitleText + ", imgPath=" + imgPath + ", priceNumTax=" + priceNumTax
				+ ", yoyakuBtn=" + yoyakuBtn + ", headingTitle=" + headingTitle + ", courseMoreLink=" + courseMoreLink
				+ "]";
	}
	
	
}