package main.beans.entities;

import javax.persistence.*;

@Entity
public class RetailImage {
	private Long imageId;
	private Gallery gallery;
	private String image;

	public RetailImage() {
		super();
	}

	public RetailImage(String image) {
		super();
		this.image = image;
	}

	public RetailImage(Gallery gallery, String image) {
		super();
		this.gallery = gallery;
		this.image = image;
	}

	@Column(name = "RETAIL_IMAGE_ID")
	@Id
	@GeneratedValue
	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	@Column(name = "RETAIL_IMAGE_PATH")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "RetailImage [imageId=" + imageId + ", image=" + image + "]";
	}

}