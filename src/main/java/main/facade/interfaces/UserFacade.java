package main.facade.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import main.beans.entities.Game;
import main.exceptions.GameStoreException;

public interface UserFacade extends GeneralClientFacade {
	void purchaseGame(Game game) throws GameStoreException;

	List<Game> getUserGames(Pageable page) throws GameStoreException;

}
