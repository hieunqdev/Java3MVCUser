package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Videos")
public class Video {
	@Id
	private String id;
	private String title;
	private String poster;
	private String description;
	private boolean active;
	private int views;
	
	// Quan hệ với bảng khác
	// Mỗi Video có thể có nhiều Favorite
	// Thuộc tính mappedBy = "video" cho biết rằng mối quan hệ này được quản lý bởi trường video trong lớp Favorite
	@OneToMany(mappedBy = "video") 
	private List<Favorite> favorites;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	
}
