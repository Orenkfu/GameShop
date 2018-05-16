package main.resources.implementations;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.beans.ClientType;
import main.beans.Message;
import main.beans.entities.Game;
import main.beans.entities.Vendor;
import main.exceptions.GameStoreException;
import main.facade.interfaces.GuestFacade;
import main.facade.interfaces.VendorFacade;
import main.helpers.GameBuildType;
import main.helpers.GameBuilder;
import main.resources.interfaces.VendorResource;

@RestController
public class VendorResourceImpl implements VendorResource {

	// @Autowired
	// VendorFacade vendor;
	@Autowired
	GuestFacade guest;

	private VendorFacade getFacadeFromSession(HttpSession session) {
		return (VendorFacade) session.getAttribute("vendor");

	}

	@RequestMapping(path = "/hello/{message}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message helloWorld(@PathVariable("message") String msg) {
		return new Message(msg);

	}

	@Override
	@RequestMapping(path = "/login/{username}/{password}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message login(@PathVariable("username") String username, @PathVariable("password") String password,
			HttpSession session) throws GameStoreException {
		System.out.println("VendorResourceImpl.login()");
		session.setAttribute("vendor", (VendorFacade) guest.login(username, password, ClientType.VENDOR));
		System.out.println(session.getAttribute("vendor"));
		System.out.println(getFacadeFromSession(session));
		return new Message("Successfully logged in.");
	}

	@Override
	@RequestMapping(path = "/games", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Game createGame(Game game, HttpSession session) throws GameStoreException {
		// PLACEHOLDER
		return getFacadeFromSession(session).createGame(game, "1000");
	}

	@Override
	@RequestMapping(path = "/games/test/{type}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Game createGameByEnum(@PathVariable("type") GameBuildType type, HttpSession session)
			throws GameStoreException {
		System.out.println(type);
		Vendor vendor = getFacadeFromSession(session).getThisVendor();
		Game game = GameBuilder.quickBuildGame(type, vendor);
		return game;
	}

}
