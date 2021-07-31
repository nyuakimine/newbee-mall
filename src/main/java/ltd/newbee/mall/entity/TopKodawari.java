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

public class TopKodawari {
	private Long id;
	private String kodawariPhoto;
	private String kodawariHeadingTitle;
	private String kodawariTitle;
	private String kodawaricolLabel;
	private String kodawariModalComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKodawariPhoto() {
		return kodawariPhoto;
	}

	public void setKodawariPhoto(String kodawariPhoto) {
		this.kodawariPhoto = kodawariPhoto;
	}

	public String getKodawariHeadingTitle() {
		return kodawariHeadingTitle;
	}

	public void setKodawariHeadingTitle(String kodawariHeadingTitle) {
		this.kodawariHeadingTitle = kodawariHeadingTitle;
	}

	public String getKodawariTitle() {
		return kodawariTitle;
	}

	public void setKodawariTitle(String kodawariTitle) {
		this.kodawariTitle = kodawariTitle;
	}

	public String getKodawaricolLabel() {
		return kodawaricolLabel;
	}

	public void setKodawaricolLabel(String kodawaricolLabel) {
		this.kodawaricolLabel = kodawaricolLabel;
	}

	public String getKodawariModalComment() {
		return kodawariModalComment;
	}

	public void setKodawariModalComment(String kodawariModalComment) {
		this.kodawariModalComment = kodawariModalComment;
	}

	@Override
	public String toString() {
		return "TopKodawari [id=" + id + ", kodawariPhoto=" + kodawariPhoto + ", kodawariHeadingTitle="
				+ kodawariHeadingTitle + ", kodawariTitle=" + kodawariTitle + ", kodawaricolLabel=" + kodawaricolLabel
				+ ", kodawariModalComment=" + kodawariModalComment + "]";
	}


}