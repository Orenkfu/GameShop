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
import main.beans.entities.User;
import main.dao.GameDao;
import main.dao.ImageDao;
import main.dao.ScreenshotDao;
import main.dao.UserDao;
import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.IllegalRequestGameStoreException;
import main.facade.interfaces.UserFacade;
import main.messaging.mail.beans.MailBuilder;
import main.messaging.mail.mailSenders.MailSender;

/**
 * @author oren
 */
@Service
public class UserFacadeImpl implements UserFacade {

	@Autowired
	protected UserDao userDao;
	@Autowired
	protected GameDao gameDao;

	@Autowired
	protected ImageDao imageDao;

	@Autowired
	MailSender mSender;

	@Autowired
	protected ScreenshotDao screenshotDao;

	private Long id;

	public UserFacadeImpl() {

	}

	public UserFacadeImpl(Long id) {
		this.id = id;
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
	public Game getGameById(Long id) throws IllegalRequestGameStoreException {
		Game game = gameDao.findById(id).orElseThrow(this::generalException);
		Hibernate.initialize(game.getGallery().getScreenshots());
		Hibernate.initialize(game.getGallery().getImages());
		return game;
	}

	@Override
	@Transactional(readOnly = true)
	public RetailImage getImageById(Long id) throws IllegalRequestGameStoreException {
		return imageDao.findById(id).orElseThrow(this::generalException);
	}

	@Override
	@Transactional(readOnly = true)
	public Screenshot getScreenShotById(Long id) throws IllegalRequestGameStoreException {
		return screenshotDao.findById(id).orElseThrow(this::generalException);
	}

	@Override
	@Transactional
	public void purchaseGame(Game game) throws GameStoreException {
		User user = userDao.findUserById(id);
		List<Game> games = user.getGames();
		game.setUser(user);
		games.add(game);
		user.setGames(games);
		userDao.save(user);
		mSender.send(MailBuilder.buildPurchaseMail(user, game.getCdKeyCode()));
	}

	public Long getId() {
		return id;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> getUserGames(Pageable page) {
		List<Game> games = gameDao.findGamesByUserId(id, page);
		games.forEach((game) -> {
			Hibernate.initialize(game.getGallery().getScreenshots());
			Hibernate.initialize(game.getGallery().getImages());
		});
		return games;
	}

	private IllegalRequestGameStoreException generalException() {
		return new IllegalRequestGameStoreException(ExceptionMessage.GENERALERROR);
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserFacadeImpl{" + "userDao=" + userDao + ", gameDao=" + gameDao + ", id=" + id + ", thisUser=" + '}';
	}

	@Override
	public int getAllGamesPageAmount(int size) throws GameStoreException {
		return gameDao.findAll(PageRequest.of(0, size)).getTotalPages();
	}
}
