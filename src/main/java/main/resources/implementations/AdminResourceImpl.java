package main.resources.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.beans.entities.Game;
import main.beans.entities.User;
import main.beans.entities.Vendor;
import main.facade.interfaces.AdminFacade;
import main.resources.interfaces.AdminResource;

@RestController
public class AdminResourceImpl implements AdminResource {

	@Autowired
	AdminFacade admin;

	@Override
	@RequestMapping(path = "/admin/vendors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return admin.createVendor(vendor);
	}

	@Override
	@RequestMapping(path = "/admin/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		return admin.createUser(user);
	}

	@Override
	@RequestMapping(path = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getAllGames(@RequestParam(name = "byPage", value = "byPage", defaultValue = "0") int page,
			@RequestParam(name = "size", value = "size", defaultValue = "10") int size) {
		return admin.getAllGames(PageRequest.of(page, size));
	}

	@Override
	@RequestMapping(path = "/admin/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(@RequestParam(name = "byPage", value = "byPage", defaultValue = "0") int page,
			@RequestParam(name = "size", value = "size", defaultValue = "10") int size) {
		return admin.getAllUsers(PageRequest.of(page, size));
	}

	// @Override
	// @RequestMapping(path = "/admin/users", method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public List<Vendor> getAllVendors(@RequestParam(name = "byPage", value =
	// "byPage", defaultValue = "0") int page,
	// @RequestParam(name = "size", value = "size", defaultValue = "10") int size) {
	// return admin.getAllVendors(PageRequest.of(page, size));
	// }

}
