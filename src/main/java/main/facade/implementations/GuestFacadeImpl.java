package main.facade.implementations;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.beans.ClientType;
import main.beans.entities.Game;
import main.beans.entities.GeneralClient;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.beans.entities.User;
import main.beans.entities.Vendor;
import main.dao.GameDao;
import main.dao.ImageDao;
import main.dao.ScreenshotDao;
import main.dao.UserDao;
import main.dao.VendorDao;
import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.IllegalRequestGameStoreException;
import main.exceptions.NotFoundException;
import main.facade.interfaces.GeneralClientFacade;
import main.facade.interfaces.GuestFacade;
import main.helpers.validators.signUpValidation.ValidationCheckList;

/**
 * @author Yura Kourlyand
 */

@Service
public class GuestFacadeImpl implements GuestFacade {

	@Autowired
	protected ObjectFactory<UserFacadeImpl> myUserFacadeFactory;

	@Autowired
	protected ObjectFactory<VendorFacadeImpl> myVendorFacadeFactory;

	@Autowired
	protected VendorDao vendorDao;

	@Autowired
	protected UserDao userDao;

	@Autowired
	protected GameDao gameDao;

	@Autowired
	protected ImageDao imageDao;

	@Autowired
	protected ScreenshotDao screenshotDao;

	public GuestFacadeImpl() {

	}

	@Override
	@Transactional(readOnly = true)
	public GeneralClientFacade login(String username, String password, ClientType type) throws GameStoreException {
		if (type == ClientType.USER) {
			User user = userDao.findByUsername(username);
			if ((user == null) || !user.getPassword().equals(password)) {
				throw new IllegalRequestGameStoreException(ExceptionMessage.BADLOGIN);
			}
			System.err.println("logged in as User: " + user.getUsername());
			UserFacadeImpl userFacadeImple = myUserFacadeFactory.getObject();
			userFacadeImple.setId(user.getId());
			return userFacadeImple;
		} else if (type == ClientType.VENDOR) {
			Vendor vendor = vendorDao.findByUsername(username);
			if ((vendor == null) || !vendor.getPassword().equals(password)) {
				throw new IllegalRequestGameStoreException(ExceptionMessage.BADLOGIN);
			}
			System.err.println("logged in as Vendor: " + vendor.getUsername());
			VendorFacadeImpl vendorFacade = myVendorFacadeFactory.getObject();
			vendorFacade.setId(vendor.getId());
			return vendorFacade;
		}
		throw new IllegalRequestGameStoreException(ExceptionMessage.BADLOGIN);
	}

	@Override
	@Transactional
	public GeneralClient signup(GeneralClient generalClient, ClientType type) throws IllegalRequestGameStoreException {
		ValidationCheckList.validateClientFields(generalClient);
		if (type == ClientType.USER) {
			User user = (User) generalClient;
			user.setSignUpDate(new Date());
			userDao.save(user);
			return user;
		} else if (type == ClientType.VENDOR) {
			Vendor vendor = (Vendor) generalClient;
			vendor.setSignUpDate(new Date());
			vendorDao.save(vendor);
			return vendor;
		}
		throw new IllegalRequestGameStoreException(ExceptionMessage.BADLOGINCLIENTTYPE);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> getAllGames(Pageable page) throws GameStoreException {
		List<Game> games = gameDao.findAll(page).getContent();// todo Not working
		games.forEach(game -> {
			Hibernate.initialize(game.getGallery().getImages());
			Hibernate.initialize(game.getGallery().getScreenshots());
		});
		return games;

	}

	@Override
	@Transactional(readOnly = true)
	public Game getGameById(Long id) throws GameStoreException {
		Game game = gameDao.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessage.NOTFOUND, "Game"));
		Hibernate.initialize(game.getGallery().getScreenshots());
		Hibernate.initialize(game.getGallery().getImages());
		return game;
	}

	@Override
	@Transactional(readOnly = true)
	public RetailImage getImageById(Long id) throws GameStoreException {
		return imageDao.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessage.NOTFOUND, "Image"));
	}

	@Override
	@Transactional(readOnly = true)
	public Screenshot getScreenShotById(Long id) throws GameStoreException {
		return screenshotDao.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionMessage.NOTFOUND, "Screenshot"));
	}

	private IllegalRequestGameStoreException generalException() {
		return new IllegalRequestGameStoreException(ExceptionMessage.GENERALERROR);
	}

	@Override
	public int getAllGamesPageAmount(int size) throws GameStoreException {
		return gameDao.findAll(PageRequest.of(0, size)).getTotalPages();
	}

}
