package main.beans.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import main.beans.GameGenre;
import main.beans.Platform;

@Entity
public class Game extends Product {
	private Gallery gallery;
	private Vendor vendor;
	private User user;

	private GameGenre genre;
	// TODO make genre and platform LISTS instead of single one-to-one
	// relationships, possibly also add TAGS
	private Platform platform;
	private String title;
	private String description;
	private Long cdKeyCode;
	private Date releaseDate;

	public Game() {
		super();
	}

	public Game(Gallery gallery) {
		super();
		this.gallery = gallery;
	}

	public Game(Vendor vendor, String name, String title, String description, GameGenre genre, Platform plat,
			BigDecimal basePrice, BigDecimal currentPrice, int discount, float rating, Date releaseDate) {
		super(name, basePrice, currentPrice, rating, discount);
		this.platform = plat;
		this.vendor = vendor;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Enumerated(EnumType.STRING)
	public GameGenre getGenre() {
		return genre;
	}

	public void setGenre(GameGenre genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Enumerated(EnumType.STRING)
	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	@ManyToOne(optional = false, targetEntity = Vendor.class)
	@JoinColumn(name = "vendor_id", referencedColumnName = "id")
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getCdKeyCode() {
		return cdKeyCode;
	}

	public void setCdKeyCode(Long cdKeyCode) {
		this.cdKeyCode = cdKeyCode;
	}

	@Override
	public String toString() {
		return super.toString() + "Game [gallery=" + gallery + ", vendor=" + vendor + ", genre=" + genre + ", platform="
				+ platform + ", title=" + title + ", description=" + description + ", releaseDate=" + releaseDate + "]";
	}

}
