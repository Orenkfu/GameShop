package main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.beans.entities.Vendor;
import main.dao.VendorDao;
import main.facade.interfaces.AdminFacade;
import main.facade.interfaces.GuestFacade;
import main.facade.interfaces.UserFacade;
import main.facade.interfaces.VendorFacade;
import main.messaging.JMSSender;
import main.messaging.mail.beans.Mail;
import main.messaging.mail.beans.MailType;

@SpringBootApplication(scanBasePackages = { "main.beans", "main.facade.interfaces", "main.facade.implementations",
		"main.facade", "main.dao", "main.helpers", "main", "main.io", "main.messaging" })
public class GameStoreApplication {

	@Autowired
	VendorDao vendorDao;

	@Autowired
	VendorFacade vfacade;

	@Autowired
	UserFacade uFacade;

	@Autowired
	AdminFacade aFacade;

	@Autowired
	GuestFacade guestFacade;

	@Autowired
	JMSSender poster;

	@PostConstruct
	public void init() {
		poster.postMail(new Mail("orenkfu@gmail.com", "test", "plz work", 8373186724010800910L, MailType.PURCHASE));

		Vendor vendBean = new Vendor("test", "123");
		// User userBean = new User("test", "123");
		vendBean = aFacade.createVendor(vendBean);
		// userBean = aFacade.createUser(userBean);
		// try {
		// uFacade = (UserFacade) guestFacade.login(userBean.getUsername(),
		// userBean.getPassword(), ClientType.USER);
		// vfacade = (VendorFacade) guestFacade.login(vendBean.getUsername(),
		// vendBean.getPassword(),
		// ClientType.VENDOR);
		//
		// uFacade.purchaseGame(
		// vfacade.createGame(GameBuilder.quickBuildGame(GameBuildType.CHEAP, vendBean),
		// "blablla1"));
		// uFacade.purchaseGame(
		// vfacade.createGame(GameBuilder.quickBuildGame(GameBuildType.STANDARDINDIE,
		// vendBean), "blablla2"));
		// uFacade.purchaseGame(
		// vfacade.createGame(GameBuilder.quickBuildGame(GameBuildType.TRIPLEA,
		// vendBean), "blablla3"));
		// System.err.println(uFacade.getUserGames(PageRequest.of(0, 2)));
		// System.err.println(uFacade.getUserGames(PageRequest.of(1, 2)));
		// } catch (GameStoreException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		//
		// vfacade = (VendorFacade) guestFacade.login("test", "123", ClientType.VENDOR);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// //
		// Gallery gallery = new Gallery();
		// gallery.addScreenshot("screen");
		// gallery.addRetailImage("retailI");
		//
		// Game g1 = GameBuilder.quickBuildGame(GameBuildType.CHEAP, vendBean);
		// Game g2 = GameBuilder.quickBuildGame(GameBuildType.STANDARD, vendBean);
		// try {
		// System.err.println(vfacade.getThisVendor().getUsername() + " $$$$$$4");
		// System.err.println(vfacade.getThisVendor().getUsername() + " $$$$$$4");
		// vfacade.createGame(g1, "game1CDKEY");
		// vfacade.createGame(g2, "game2CDKEY");
		// System.err.println("LeopLeopLeopLeopLeop");
		//
		// Order order = new Order();
		// ArrayList<Game> orderGames = new ArrayList<>();
		// orderGames.add(g1);
		// orderGames.add(g2);
		// order.setGames(orderGames);

		// sender.send(new Mail("orenkfu@gmail.com", "test", "plz work",
		// 1186163015724962876L, MailType.PURCHASE));

	}

	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}
}
