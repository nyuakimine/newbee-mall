package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DetailTitle {
	private Long id;
	private String name;
	private String star;
	private Double score;
	private int commentNum;
	private String saveNum;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getSaveNum() {
		return saveNum;
	}
	public void setSaveNum(String saveNum) {
		this.saveNum = saveNum;
	}
	@Override
	public String toString() {
		return "DetailTitle [id=" + id + ", name=" + name + ", star=" + star + ", score=" + score + ", commentNum="
				+ commentNum + ", saveNum=" + saveNum + "]";
	}
	
}