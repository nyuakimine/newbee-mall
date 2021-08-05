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

public class TopMatome {
	private Long id;
	private String matomeHeading;
	private String path1;
	private String path2;
	private String path3;
	private String matomeTextTitle;
	private String matomeTextDesc;
	private String path4;
	private String any1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatomeHeading() {
		return matomeHeading;
	}

	public void setMatomeHeading(String matomeHeading) {
		this.matomeHeading = matomeHeading;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	public String getPath3() {
		return path3;
	}

	public void setPath3(String path3) {
		this.path3 = path3;
	}

	public String getMatomeTextTitle() {
		return matomeTextTitle;
	}

	public void setMatomeTextTitle(String matomeTextTitle) {
		this.matomeTextTitle = matomeTextTitle;
	}

	public String getMatomeTextDesc() {
		return matomeTextDesc;
	}

	public void setMatomeTextDesc(String matomeTextDesc) {
		this.matomeTextDesc = matomeTextDesc;
	}

	public String getPath4() {
		return path4;
	}

	public void setPath4(String path4) {
		this.path4 = path4;
	}

	public String getAny1() {
		return any1;
	}

	public void setAny1(String any1) {
		this.any1 = any1;
	}

	@Override
	public String toString() {
		return "TopMatome [id=" + id + ", matomeHeading=" + matomeHeading + ", path1=" + path1 + ", path2=" + path2
				+ ", path3=" + path3 + ", matomeTextTitle=" + matomeTextTitle + ", matomeTextDesc=" + matomeTextDesc
				+ ", path4=" + path4 + ", any1=" + any1 + "]";
	}


}