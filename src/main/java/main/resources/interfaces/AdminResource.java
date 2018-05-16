package main.resources.interfaces;

import java.util.List;

import main.beans.entities.Game;
import main.beans.entities.User;
import main.beans.entities.Vendor;

public interface AdminResource {

	Vendor createVendor(Vendor vendor);

	User createUser(User user);

	// List<Vendor> getAllVendors(int page, int size);

	List<Game> getAllGames(int page, int size);

	List<User> getAllUsers(int page, int size);
}
