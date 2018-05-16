package main.facade.implementations;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.beans.ClientType;
import main.beans.entities.Gallery;
import main.beans.entities.Game;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.beans.entities.User;
import main.beans.entities.Vendor;
import main.dao.GalleryDao;
import main.dao.GameDao;
import main.dao.ImageDao;
import main.dao.ScreenshotDao;
import main.dao.UserDao;
import main.dao.VendorDao;
import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.IllegalRequestGameStoreException;
import main.exceptions.NotFoundException;
import main.facade.interfaces.AdminFacade;

@Service
public class AdminFacadeImpl implements AdminFacade {

	@Autowired
	protected VendorDao vendorDao;
	@Autowired
	protected UserDao userDao;
	@Autowired
	protected GalleryDao galleryDao;
	@Autowired
	protected GameDao gameDao;
	@Autowired
	protected ImageDao imageDao;
	@Autowired
	protected ScreenshotDao screenshotDao;

	@Override
	@Transactional
	public Vendor createVendor(Vendor vendor) {
		vendor.setSignUpDate(new Date());
		vendorDao.save(vendor);
		return vendor;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		user.setSignUpDate(new Date());
		userDao.save(user);
		return user;
	}

	@Override
	@Transactional
	public Vendor updateVendor(Vendor vendor) {
		return vendorDao.save(vendor);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	@Transactional
	public Game updateGame(Game game) {
		return gameDao.save(game);
	}

	@Override
	@Transactional
	public Gallery updateGallery(Gallery gallery) {
		return galleryDao.save(gallery);
	}

	@Override
	@Transactional
	public void deleteGame(Long id) throws GameStoreException {
		Game game = gameDao.findGameById(id);
		if (game == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Game");
		gameDao.delete(game);
	}

	@Override
	@Transactional
	public void deleteVendor(Long id) throws GameStoreException {
		Vendor vendor = vendorDao.findVendorById(id);
		if (vendor == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Vendor");
		Hibernate.initialize(vendor);
		vendorDao.delete(vendor);
	}

	@Override
	@Transactional
	public void deleteUser(Long id) throws GameStoreException {
		User user = userDao.findUserById(id);
		if (user == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "User");
		userDao.delete(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendor> getAllVendors(Pageable page) {
		return vendorDao.findAll(page).getContent();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers(Pageable page) {
		return userDao.findAll(page).getContent();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> getAllGames(Pageable page) {
		return gameDao.findAll(page).getContent();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Screenshot> getScreenShotsByGallery(Gallery gallery) {
		return screenshotDao.findScreenShotByGallery(gallery);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RetailImage> getRetailImagesByGallery(Gallery gallery) {
		return imageDao.getRetailImagesByGallery(gallery);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(Long id) throws GameStoreException {
		User user = userDao.findUserById(id);
		if (user == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Vendor");
		Hibernate.initialize(user);
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public Vendor getVendorById(Long id) throws GameStoreException {
		Vendor vendor = vendorDao.findVendorById(id);
		if (vendor == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Vendor");
		Hibernate.initialize(vendor);
		return vendor;
	}

	@Override
	@Transactional(readOnly = true)
	public Game getGameById(Long id) throws GameStoreException {
		Game game = gameDao.findGameById(id);
		if (game == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Game");
		Hibernate.initialize(game);
		return game;
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserByUserName(String username) throws GameStoreException {
		User user = userDao.findByUsername(username);
		if (user == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "User");
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public Vendor getVendorByUserName(String username) throws GameStoreException {
		Vendor vendor = vendorDao.findByUsername(username);
		if (vendor == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Vendor");
		return vendor;
	}

	@Override
	@Transactional(readOnly = true)
	public Game getGameByTitle(String title) throws GameStoreException {
		Game game = gameDao.findGameByTitle(title);
		if (game == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Game");
		return game;
	}

	// @Override
	// @Transactional(readOnly = true)
	// public Screenshot getScreenShotByPath(String path) throws GameStoreException
	// {
	// Screenshot screenshot = screenshotDao.findScreenShotByImage(path);
	// if (screenshot == null)
	// throw new NotFoundException(ExceptionMessage.NOTFOUND, "Screenshot");
	// return screenshot;
	// }

	@Override
	@Transactional(readOnly = true)
	public RetailImage getRetailImageByPath(String path) throws GameStoreException {
		RetailImage retailImage = imageDao.findRetailImageByImage(path);
		if (retailImage == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Retail Image");
		return retailImage;
	}

	@Override
	public Screenshot getScreenShotByPath(String path) throws GameStoreException {
		Screenshot screenshot = screenshotDao.findScreenshotByImage(path);
		if (screenshot == null)
			throw new NotFoundException(ExceptionMessage.NOTFOUND, "Retail Image");
		return screenshot;
	}

	@Transactional(readOnly = true)
	public AdminFacadeImpl login(String name, String password, ClientType type) throws Exception {
		if (!ClientType.ADMIN.equals(type) || !"12345".equals(password) || !"admin".equals(name)) {
			throw customException(ExceptionMessage.BADLOGIN);
		}
		System.err.println("logged in as Admin");
		return this;
	}

	private IllegalRequestGameStoreException customException(ExceptionMessage exceptionMessage) {
		return new IllegalRequestGameStoreException(exceptionMessage);
	}

	@Override
	public String toString() {
		return "AdminFacadeImpl{" + "vendorDao=" + vendorDao + ", userDao=" + userDao + '}';
	}

	@Override
	public int getUserPageAmount(int size) {
		return userDao.findAll(PageRequest.of(0, size)).getTotalPages();

	}

	@Override
	public int getVendorPageAmount(int size) {
		return vendorDao.findAll(PageRequest.of(0, size)).getTotalPages();

	}

	@Override
	public int getGamePageAmount(int size) {
		return gameDao.findAll(PageRequest.of(0, size)).getTotalPages();

	}
}
