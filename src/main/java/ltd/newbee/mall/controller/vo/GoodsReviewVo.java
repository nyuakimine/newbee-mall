/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品详情页VO
 */
public class GoodsReviewVo implements Serializable {
    private int id;
    private int star;
    private String custermerId;
    private String commentDate;
    private Long goodsId;
    private String title;
    private String content;
    private String picture;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }
    public String getCustermerId() {
        return custermerId;
    }
    public void setCustermerId(String custermerId) {
        this.custermerId = custermerId;
    }
    public String getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    @Override
    public String toString() {
	return "GoodsReviewVo [id=" + id + ", star=" + star + ", custermerId=" + custermerId + ", commentDate="
		+ commentDate + ", goodsId=" + goodsId + ", title=" + title + ", content=" + content + ", picture="
		+ picture + "]";
    }
  
}
