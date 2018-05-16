package main.resources.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.beans.ClientType;
import main.beans.entities.Game;
import main.beans.entities.GeneralClient;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.exceptions.GameStoreException;
import main.facade.interfaces.GeneralClientFacade;
import main.facade.interfaces.GuestFacade;
import main.resources.interfaces.GuestResource;

public class GuestResourceImpl implements GuestResource {

	@Autowired
	GuestFacade guest;

	@Override
	@RequestMapping(path = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getAllGames(@RequestParam(name = "byPage", value = "byPage", defaultValue = "0") int page,
			@RequestParam(name = "size", value = "size", defaultValue = "10") int size) throws GameStoreException {
		return guest.getAllGames(PageRequest.of(page, size));
	}

	@Override
	public Game getGameById(Long id) throws GameStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RetailImage getImageById(Long id) throws GameStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Screenshot getScreenShotById(Long id) throws GameStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralClient vendorSignup(GeneralClient generalClient) throws GameStoreException {
		return guest.signup(generalClient, ClientType.VENDOR);
	}

	@Override
	public GeneralClient userSignup(GeneralClient generalClient) throws GameStoreException {
		return guest.signup(generalClient, ClientType.USER);
	}

	@Override
	@RequestMapping
	public GeneralClientFacade vendorLogin(String name, String password) throws GameStoreException {
		return guest.login(name, password, ClientType.VENDOR);
	}

	@Override
	public GeneralClientFacade userLogin(String name, String password) throws GameStoreException {
		return guest.login(name, password, ClientType.USER);
	}

}
