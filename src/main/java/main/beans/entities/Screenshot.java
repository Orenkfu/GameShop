package main.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCREENSHOT_IMAGES")
public class Screenshot {

	private Long screenshotId;
	private Gallery gallery;
	private String image;

	public Screenshot() {
	}

	public Screenshot(String image) {
		super();
		this.image = image;
	}

	public Screenshot(Gallery gallery, String image) {
		super();
		this.gallery = gallery;
		this.image = image;
	}

	@Id
	@GeneratedValue
	public Long getScreenshotId() {
		return screenshotId;
	}

	@Column(name = "SCREENSHOT_ID")
	public void setScreenshotId(Long screenshotId) {
		this.screenshotId = screenshotId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String imagePath) {
		this.image = imagePath;
	}

}
