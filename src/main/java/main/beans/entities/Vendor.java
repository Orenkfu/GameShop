package main.beans.entities;

import javax.persistence.*;
import java.util.List;

/**
 * ADDED PREMIUM ATTRIB
 * 
 * @author oren
 *
 */
@Entity
public class Vendor extends GeneralClient {
	private List<Game> games;
	private boolean isPremium;

	public Vendor() {
		super();
	}

	@Column(name = "PREMIUM_CLIENT")
	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public Vendor(String userName, String password) {
		super(userName, password);
	}

	@OneToMany(targetEntity = Game.class, fetch = FetchType.EAGER)
	@JoinTable(name = "VENDOR_GAMES", joinColumns = @JoinColumn(name = "VENDOR_ID"), inverseJoinColumns = @JoinColumn(name = "GAME_ID"))
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
