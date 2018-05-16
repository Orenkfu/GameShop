package main.resources.interfaces;

import javax.servlet.http.HttpSession;

import main.beans.Message;
import main.beans.entities.Game;
import main.exceptions.GameStoreException;
import main.helpers.GameBuildType;

public interface VendorResource {
	Game createGame(Game game, HttpSession session) throws GameStoreException;

	Game createGameByEnum(GameBuildType type, HttpSession session) throws GameStoreException;

	Message login(String username, String password, HttpSession session) throws GameStoreException;
}
