package main.facade.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import main.beans.entities.Gallery;
import main.beans.entities.Game;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.beans.entities.User;
import main.beans.entities.Vendor;
import main.exceptions.GameStoreException;

public interface AdminFacade {
	Vendor createVendor(Vendor vendor);

	User createUser(User user);

	Vendor updateVendor(Vendor vendor);

	User updateUser(User user);

	Game updateGame(Game game);

	Gallery updateGallery(Gallery gallery);

	void deleteGame(Long id) throws GameStoreException;

	void deleteVendor(Long id) throws GameStoreException;

	void deleteUser(Long id) throws GameStoreException;

	List<Vendor> getAllVendors(Pageable page);

	List<User> getAllUsers(Pageable page);

	List<Game> getAllGames(Pageable page);

	int getUserPageAmount(int size);

	int getVendorPageAmount(int size);

	int getGamePageAmount(int size);

	List<Screenshot> getScreenShotsByGallery(Gallery gallery);

	List<RetailImage> getRetailImagesByGallery(Gallery gallery);

	User getUserById(Long id) throws GameStoreException;

	Vendor getVendorById(Long id) throws GameStoreException;

	Game getGameById(Long id) throws GameStoreException;

	User getUserByUserName(String username) throws GameStoreException;

	Vendor getVendorByUserName(String username) throws GameStoreException;

	Game getGameByTitle(String title) throws GameStoreException;

	Screenshot getScreenShotByPath(String path) throws GameStoreException;

	RetailImage getRetailImageByPath(String path) throws GameStoreException;

	// void sendEmail();

}
