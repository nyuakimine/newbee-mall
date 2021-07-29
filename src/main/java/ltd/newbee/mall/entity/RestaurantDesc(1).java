package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestaurantDesc {

	private Long id;
	private String nearbyStation;
	private Long genreId;
	private String nightBudget;
	private String dayBudget;
	private String restDay;
	private String genreName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNearbyStation() {
		return nearbyStation;
	}
	public void setNearbyStation(String nearbyStation) {
		this.nearbyStation = nearbyStation;
	}
	public Long getGenreId() {
		return genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public String getNightBudget() {
		return nightBudget;
	}
	public void setNightBudget(String nightBudget) {
		this.nightBudget = nightBudget;
	}
	public String getDayBudget() {
		return dayBudget;
	}
	public void setDayBudget(String dayBudget) {
		this.dayBudget = dayBudget;
	}
	public String getRestDay() {
		return restDay;
	}
	public void setRestDay(String restDay) {
		this.restDay = restDay;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "RestaurantDesc [id=" + id + ", nearbyStation=" + nearbyStation + ", genreId=" + genreId
				+ ", nightBudget=" + nightBudget + ", dayBudget=" + dayBudget + ", restDay=" + restDay + ", genreName="
				+ genreName + "]";
	}
	
}