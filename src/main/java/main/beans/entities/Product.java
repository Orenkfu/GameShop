package main.beans.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product {
	protected Long id;
	protected String name;
	protected BigDecimal basePrice;
	protected BigDecimal currentPrice;
	// protected Discount discount;
	protected int discount;

	// TODO: work out logic for rating, should probably be an object instead of a
	// float.
	protected float rating;

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Product() {
		super();
	}

	@Column(name = "PRODUCT_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product(String name, BigDecimal basePrice, BigDecimal currentPrice, float rating, int discount) {
		this.name = name;
		this.basePrice = basePrice;
		this.currentPrice = currentPrice;
		this.rating = rating;
		this.discount = discount;
	}

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(updatable = false, name = "BASE_PRICE")
	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	@Column(name = "CURRENT_PRICE")
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	// TODO: fix discount persistence

	// public int getDiscount() {
	// return discount.getDiscountRate();
	// }
	//
	// public void setDiscount(int discount) throws DiscountException {
	// if (this.discount == null) {
	// this.discount = new Discount(discount);
	// }
	// this.discount.setDiscountRate(discount);
	// }

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", basePrice=" + basePrice + ", currentPrice=" + currentPrice + ", discount="
				+ ", rating=" + rating + "]";
	}

}
