package main.beans.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * ADDED PREMIUM ATTRIB
 * 
 * @author oren
 *
 */
@Entity
@Table(name = "USERS")
public class User extends GeneralClient {
	private List<Game> games;

	public User() {
		super();
	}

	public User(String username, String password) {
		super(username, password);
	}

	@Column(name = "OWNED_GAMES")
	@ManyToMany(targetEntity = Game.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_GAMES", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	private Date birthdate;

}
