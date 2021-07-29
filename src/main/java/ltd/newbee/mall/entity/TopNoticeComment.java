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

public class TopNoticeComment {
    private Long id;
    private String topNoticeTitle;
    private String topNoticecol1;
    private String topNoticecol2;
    private String topNoticecol3;
    private String topNoticecol4;
    private String topNoticecol5;
    private String topNoticecol6;
    private String topComment1;
    private String topComment2;
    private String topComment3;
    private String topComment4;
    private String topComment5;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTopNoticeTitle() {
		return topNoticeTitle;
	}
	public void setTopNoticeTitle(String topNoticeTitle) {
		this.topNoticeTitle = topNoticeTitle;
	}
	public String getTopNoticecol1() {
		return topNoticecol1;
	}
	public void setTopNoticecol1(String topNoticecol1) {
		this.topNoticecol1 = topNoticecol1;
	}
	public String getTopNoticecol2() {
		return topNoticecol2;
	}
	public void setTopNoticecol2(String topNoticecol2) {
		this.topNoticecol2 = topNoticecol2;
	}
	public String getTopNoticecol3() {
		return topNoticecol3;
	}
	public void setTopNoticecol3(String topNoticecol3) {
		this.topNoticecol3 = topNoticecol3;
	}
	public String getTopNoticecol4() {
		return topNoticecol4;
	}
	public void setTopNoticecol4(String topNoticecol4) {
		this.topNoticecol4 = topNoticecol4;
	}
	public String getTopNoticecol5() {
		return topNoticecol5;
	}
	public void setTopNoticecol5(String topNoticecol5) {
		this.topNoticecol5 = topNoticecol5;
	}
	public String getTopNoticecol6() {
		return topNoticecol6;
	}
	public void setTopNoticecol6(String topNoticecol6) {
		this.topNoticecol6 = topNoticecol6;
	}
	public String getTopComment1() {
		return topComment1;
	}
	public void setTopComment1(String topComment1) {
		this.topComment1 = topComment1;
	}
	public String getTopComment2() {
		return topComment2;
	}
	public void setTopComment2(String topComment2) {
		this.topComment2 = topComment2;
	}
	public String getTopComment3() {
		return topComment3;
	}
	public void setTopComment3(String topComment3) {
		this.topComment3 = topComment3;
	}
	public String getTopComment4() {
		return topComment4;
	}
	public void setTopComment4(String topComment4) {
		this.topComment4 = topComment4;
	}
	public String getTopComment5() {
		return topComment5;
	}
	public void setTopComment5(String topComment5) {
		this.topComment5 = topComment5;
	}
	@Override
	public String toString() {
		return "TopNoticeComment [id=" + id + ", topNoticeTitle=" + topNoticeTitle + ", topNoticecol1=" + topNoticecol1
				+ ", topNoticecol2=" + topNoticecol2 + ", topNoticecol3=" + topNoticecol3 + ", topNoticecol4="
				+ topNoticecol4 + ", topNoticecol5=" + topNoticecol5 + ", topNoticecol6=" + topNoticecol6
				+ ", topComment1=" + topComment1 + ", topComment2=" + topComment2 + ", topComment3=" + topComment3
				+ ", topComment4=" + topComment4 + ", topComment5=" + topComment5 + "]";
	}
    
    
}