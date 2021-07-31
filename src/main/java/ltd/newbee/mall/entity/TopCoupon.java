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

public class TopCoupon {
	private Long id;
	private String couponBtn;
	private String couponDescription;
	private String couponMoreText1;
	private String couponMoreText2;
	private String couponMoreText3;
	private String couponNotice;
	private String couponSubject;
	private String couponTarget;
	private String headingTitle;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCouponBtn() {
		return couponBtn;
	}
	public void setCouponBtn(String couponBtn) {
		this.couponBtn = couponBtn;
	}
	public String getCouponDescription() {
		return couponDescription;
	}
	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}
	public String getCouponMoreText1() {
		return couponMoreText1;
	}
	public void setCouponMoreText1(String couponMoreText1) {
		this.couponMoreText1 = couponMoreText1;
	}
	public String getCouponMoreText2() {
		return couponMoreText2;
	}
	public void setCouponMoreText2(String couponMoreText2) {
		this.couponMoreText2 = couponMoreText2;
	}
	public String getCouponMoreText3() {
		return couponMoreText3;
	}
	public void setCouponMoreText3(String couponMoreText3) {
		this.couponMoreText3 = couponMoreText3;
	}
	public String getCouponNotice() {
		return couponNotice;
	}
	public void setCouponNotice(String couponNotice) {
		this.couponNotice = couponNotice;
	}
	public String getCouponSubject() {
		return couponSubject;
	}
	public void setCouponSubject(String couponSubject) {
		this.couponSubject = couponSubject;
	}
	public String getCouponTarget() {
		return couponTarget;
	}
	public void setCouponTarget(String couponTarget) {
		this.couponTarget = couponTarget;
	}
	public String getHeadingTitle() {
		return headingTitle;
	}
	public void setHeadingTitle(String headingTitle) {
		this.headingTitle = headingTitle;
	}
	@Override
	public String toString() {
		return "TopCoupon [id=" + id + ", couponBtn=" + couponBtn + ", couponDescription=" + couponDescription
				+ ", couponMoreText1=" + couponMoreText1 + ", couponMoreText2=" + couponMoreText2 + ", couponMoreText3="
				+ couponMoreText3 + ", couponNotice=" + couponNotice + ", couponSubject=" + couponSubject
				+ ", couponTarget=" + couponTarget + ", headingTitle=" + headingTitle + "]";
	}

}