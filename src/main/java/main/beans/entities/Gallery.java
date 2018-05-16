package main.beans.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Gallery {
	private Long galleryId;
	private Game game;
	private String coverImgPath;

	@Column(name = "COVER_IMAGE")
	public String getCoverImgPath() {
		return coverImgPath;
	}

	public void setCoverImgPath(String coverImgPath) {
		this.coverImgPath = coverImgPath;
	}

	private List<RetailImage> images;
	private List<Screenshot> screenshots;

	public Gallery() {
		super();
		images = new ArrayList<>();
		screenshots = new ArrayList<>();
	}

	@Id
	@GeneratedValue
	@Column(name = "GAL_ID")
	public Long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(Long galleryId) {
		this.galleryId = galleryId;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	// "galleryId")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gallery")
	public List<RetailImage> getImages() {
		return images;
	}

	@Override
	public String toString() {
		return "Gallery [galleryId=" + galleryId + "game ID: " + game.getId() + "Cover Image: " + coverImgPath + "]";
	}

	public void setImages(List<RetailImage> images) {
		this.images = images;
	}

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	// "gallery")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gallery")
	public List<Screenshot> getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(List<Screenshot> screenshots) {
		this.screenshots = screenshots;
	}

	public void addScreenshot(String image) {
		Screenshot screenshot = new Screenshot(image);
		screenshot.setGallery(this);
		screenshots.add(screenshot);
	}

	public void addRetailImage(String image) {
		RetailImage ri = new RetailImage(image);
		ri.setGallery(this);
		images.add(ri);
	}
}
