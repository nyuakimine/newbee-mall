package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GenreAndStation {

	private Long id;
	private String nearStationId;
	private String genreCollectionId;
	private Long stationId;
	private String stationName;
	private Long genreId;
	private String genreName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNearStationId() {
		return nearStationId;
	}
	public void setNearStationId(String nearStationId) {
		this.nearStationId = nearStationId;
	}
	public String getGenreCollectionId() {
		return genreCollectionId;
	}
	public void setGenreCollectionId(String genreCollectionId) {
		this.genreCollectionId = genreCollectionId;
	}
	public Long getStationId() {
		return stationId;
	}
	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Long getGenreId() {
		return genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "GenreAndStation [id=" + id + ", nearStationId=" + nearStationId + ", genreCollectionId="
				+ genreCollectionId + ", stationId=" + stationId + ", stationName=" + stationName + ", genreId="
				+ genreId + ", genreName=" + genreName + "]";
	}
	
}