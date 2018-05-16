package main.beans;

import main.exceptions.DiscountException;
import main.exceptions.ExceptionMessage;

public class Discount {
	private int discountRate;
	private final static int MAX = 100;
	private final static int MIN = 0;

	public Discount(int discountRate) {
		super();
		this.discountRate = discountRate;
	}

	public Discount() {
		super();
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) throws DiscountException {
		if (discountRate > MAX) {
			throw new DiscountException(ExceptionMessage.HIGHDISCOUNT);
		} else if (discountRate < MIN) {
			throw new DiscountException(ExceptionMessage.LOWDISCOUNT);
		}

		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "Discount [discountRate=" + discountRate + "]";
	}

}
