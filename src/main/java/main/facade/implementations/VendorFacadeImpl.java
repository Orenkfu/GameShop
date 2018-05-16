package main.facade.implementations;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.beans.entities.Game;
import main.beans.entities.RetailImage;
import main.beans.entities.Screenshot;
import main.beans.entities.Vendor;
import main.dao.GalleryDao;
import main.dao.GameDao;
import main.dao.ImageDao;
import main.dao.ScreenshotDao;
import main.dao.VendorDao;
import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.GameStoreIOException;
import main.exceptions.IllegalRequestGameStoreException;
import main.exceptions.NotFoundException;
import main.exceptions.NotLoggedInException;
import main.facade.interfaces.VendorFacade;
import main.io.CDKeyWriter;

@Service
public class VendorFacadeImpl implements VendorFacade {

	@Autowired
	protected GameDao gameDao;

	@Autowired
	protected GalleryDao galleryDao;

	@Autowired
	protected ImageDao imgDao;

	@Autowired
	protected ScreenshotDao screenshotDao;

	@Autowired
	protected VendorDao vendorDao;

	@Autowired
	protected CDKeyWriter cdKeyWriter;

	private Long id;
	// private Vendor thisVendor;

	@Override
	@Transactional
	public Game createGame(Game game, String cdkey) throws GameStoreIOException {
		game.getGallery().setGame(game);
		game.setVendor(vendorDao.findVendorById(id));
		Long keyCode = cdKeyWriter.WriteCDKey(cdkey, game.getName());
		game.setCdKeyCode(keyCode);
		if (game.getId() != null || game.getGallery().getGalleryId() != null) {
			throw new RuntimeException("test successful");
		}
		return gameDao.save(game);
	}

	@Override
	@Transactional
	// finish this method!!
	public List<Game> getAllVendorGames(Pageable page) {
		List<Game> games = gameDao.findGamesByVendorId(id);
		games.forEach(game -> {
			Hibernate.initialize(game.getGallery().getImages());
			Hibernate.initialize(game.getGallery().getScreenshots());
		});
		return games;
	}

	@Override
	@Transactional(readOnly = true)
	public Game getGameById(Long id) throws IllegalRequestGameStoreException {
		Game game = gameDao.findGameById(id);
		if (game == null)
			throw new IllegalRequestGameStoreException(ExceptionMessage.GENERALERROR);
		Hibernate.initialize(game.getGallery().getImages());
		Hibernate.initialize(game.getGallery().getScreenshots());
		return game;
	}

	@Override
	@Transactional(readOnly = true)
	public RetailImage getImageById(Long id) throws NotFoundException {
		return imgDao.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessage.NOTFOUND, "Image"));
	}

	@Override
	@Transactional(readOnly = true)
	public Screenshot getScreenShotById(Long id) throws NotFoundException {
		return screenshotDao.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionMessage.NOTFOUND, "Screenshot"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> getAllGames(Pageable page) {
		List<Game> games = gameDao.findAll(page).getContent();
		games.forEach(game -> {
			Hibernate.initialize(game.getGallery().getImages());
			Hibernate.initialize(game.getGallery().getScreenshots());
		});
		return games;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int getAllGamesPageAmount(int size) throws GameStoreException {
		return gameDao.findAll(PageRequest.of(0, size)).getTotalPages();
	}

	@Override
	public Vendor getThisVendor() throws GameStoreException {
		return vendorDao.findById(this.id).orElseThrow(() -> new NotLoggedInException(ExceptionMessage.NOTLOGGEDIN));
	}

}
