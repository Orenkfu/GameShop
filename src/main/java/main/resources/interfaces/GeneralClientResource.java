package main.resources.interfaces;

import java.util.List;

import main.beans.entities.Game;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.exceptions.GameStoreException;

public interface GeneralClientResource {
	List<Game> getAllGames(int page, int size) throws GameStoreException;

	Game getGameById(Long id) throws GameStoreException;

	RetailImage getImageById(Long id) throws GameStoreException;

	Screenshot getScreenShotById(Long id) throws GameStoreException;
}
