package main.facade.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import main.beans.entities.Game;
import main.beans.entities.Vendor;
import main.exceptions.GameStoreException;

public interface VendorFacade extends GeneralClientFacade {

	Game createGame(Game game, String cdkey) throws GameStoreException;

	List<Game> getAllVendorGames(Pageable page) throws GameStoreException;

	Vendor getThisVendor() throws GameStoreException;

}
