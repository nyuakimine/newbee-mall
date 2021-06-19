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

public class SaleIdAndInfo {
    private Boolean flag;
    private Long id;
    private Long goodsId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
    private Date endDate;
    private String goodsName;
    private Long goodsCategoryId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }
    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }
    
    public Boolean getFlag() {
        return flag;
    }
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    @Override
    public String toString() {
	return "SaleIdAndInfo [flag=" + flag + ", id=" + id + ", goodsId=" + goodsId + ", startDate=" + startDate
		+ ", endDate=" + endDate + ", goodsName=" + goodsName + ", goodsCategoryId=" + goodsCategoryId + "]";
    }
    
}