package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Favorite {
	@Id
	// IDENTITY: giá trị tự tăng
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Long -> BIGINT
	private Long id;
	// Quan hệ N-1: nhiều bản ghi trong Favorite có thể tham chiếu đến 1 bản ghi trong Video
	@ManyToOne
	// Khóa ngoại Videold liên kết với bảng Video
	@JoinColumn(name = "VideoId")
	private Video video;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;
	// TemporalType.DATE chỉ lấy phần ngày, bỏ qua phần thời gian (giờ, phút, giây)
	@Temporal(TemporalType.DATE)
	private Date likeDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
}
