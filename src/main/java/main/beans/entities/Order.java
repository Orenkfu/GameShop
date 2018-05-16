package main.beans.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {
	private List<Game> games;
	private BigDecimal preCommAmount;
	private BigDecimal finalAmount;
	private Long paidToId;
	private Long paidFromId;
	private Date date;

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public BigDecimal getPreCommAmount() {
		return preCommAmount;
	}

	public void setPreCommAmount(BigDecimal preCommAmount) {
		this.preCommAmount = preCommAmount;
	}

	public BigDecimal getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Long getPaidToId() {
		return paidToId;
	}

	public void setPaidToId(Long paidToId) {
		this.paidToId = paidToId;
	}

	public Long getPaidFromId() {
		return paidFromId;
	}

	public void setPaidFromId(Long paidFromId) {
		this.paidFromId = paidFromId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
