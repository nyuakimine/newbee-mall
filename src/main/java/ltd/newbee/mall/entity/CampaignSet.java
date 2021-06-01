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

public class CampaignSet {
    private Long id;

    private Long campaginId;

    private Long primaryGoodsId;

    private Long categoryId;

    private Long subGoodsId;

    private Date startDate;
    
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampaginId() {
        return campaginId;
    }

    public void setCampaginId(Long campaginId) {
        this.campaginId = campaginId;
    }

    public Long getPrimaryGoodsId() {
        return primaryGoodsId;
    }

    public void setPrimaryGoodsId(Long primaryGoodsId) {
        this.primaryGoodsId = primaryGoodsId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubGoodsId() {
        return subGoodsId;
    }

    public void setSubGoodsId(Long subGoodsId) {
        this.subGoodsId = subGoodsId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
	return "CampaignSet [id=" + id + ", campaginId=" + campaginId + ", primaryGoodsId=" + primaryGoodsId
		+ ", categoryId=" + categoryId + ", subGoodsId=" + subGoodsId + ", startDate=" + startDate
		+ ", endDate=" + endDate + "]";
    }
    
    
}