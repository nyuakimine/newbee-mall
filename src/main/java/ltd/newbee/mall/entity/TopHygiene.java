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

public class TopHygiene {
    private Long id;
    private String headingTitle;
    private String hygieneData1;
    private String hygieneData2;
    private String hygieneData3;
    private String hygieneItemName1;
    private String hygieneItemName2;
    private String path1;
    private String path2;
    private String textNotice1;
    private String textNotice2;
    private String textNotice3;
    private String textNotice4;
    private String textNotice5;
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
	public String getHygieneData1() {
		return hygieneData1;
	}
	public void setHygieneData1(String hygieneData1) {
		this.hygieneData1 = hygieneData1;
	}
	public String getHygieneData2() {
		return hygieneData2;
	}
	public void setHygieneData2(String hygieneData2) {
		this.hygieneData2 = hygieneData2;
	}
	public String getHygieneData3() {
		return hygieneData3;
	}
	public void setHygieneData3(String hygieneData3) {
		this.hygieneData3 = hygieneData3;
	}
	public String getHygieneItemName1() {
		return hygieneItemName1;
	}
	public void setHygieneItemName1(String hygieneItemName1) {
		this.hygieneItemName1 = hygieneItemName1;
	}
	public String getHygieneItemName2() {
		return hygieneItemName2;
	}
	public void setHygieneItemName2(String hygieneItemName2) {
		this.hygieneItemName2 = hygieneItemName2;
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
	public String getTextNotice1() {
		return textNotice1;
	}
	public void setTextNotice1(String textNotice1) {
		this.textNotice1 = textNotice1;
	}
	public String getTextNotice2() {
		return textNotice2;
	}
	public void setTextNotice2(String textNotice2) {
		this.textNotice2 = textNotice2;
	}
	public String getTextNotice3() {
		return textNotice3;
	}
	public void setTextNotice3(String textNotice3) {
		this.textNotice3 = textNotice3;
	}
	public String getTextNotice4() {
		return textNotice4;
	}
	public void setTextNotice4(String textNotice4) {
		this.textNotice4 = textNotice4;
	}
	public String getTextNotice5() {
		return textNotice5;
	}
	public void setTextNotice5(String textNotice5) {
		this.textNotice5 = textNotice5;
	}
	@Override
	public String toString() {
		return "TopHygiene [id=" + id + ", headingTitle=" + headingTitle + ", hygieneData1=" + hygieneData1
				+ ", hygieneData2=" + hygieneData2 + ", hygieneData3=" + hygieneData3 + ", hygieneItemName1="
				+ hygieneItemName1 + ", hygieneItemName2=" + hygieneItemName2 + ", path1=" + path1 + ", path2=" + path2
				+ ", textNotice1=" + textNotice1 + ", textNotice2=" + textNotice2 + ", textNotice3=" + textNotice3
				+ ", textNotice4=" + textNotice4 + ", textNotice5=" + textNotice5 + "]";
	}
    

}