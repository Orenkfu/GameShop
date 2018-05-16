package main.facade.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import main.beans.entities.Game;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.exceptions.GameStoreException;

public interface GeneralClientFacade {

	List<Game> getAllGames(Pageable page) throws GameStoreException;

	Game getGameById(Long id) throws GameStoreException;

	RetailImage getImageById(Long id) throws GameStoreException;

	Screenshot getScreenShotById(Long id) throws GameStoreException;

	int getAllGamesPageAmount(int size) throws GameStoreException;

}
