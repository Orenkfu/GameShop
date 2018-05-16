package main.helpers;

import java.math.BigDecimal;
import java.util.Date;

import main.beans.GameGenre;
import main.beans.Platform;
import main.beans.entities.Gallery;
import main.beans.entities.Game;
import main.beans.entities.Vendor;

/**
 * WORKS!
 * 
 * @author oren
 *
 */
public class GameBuilder {

	public static Game quickBuildGame(GameBuildType type, Vendor vendorId) {
		Game game;
		switch (type) {
		case STANDARD:
			game = new Game(vendorId, "Standard Game", "A most standard game",
					"A game about doing standard things, no coop, no multiplayer, just standard gameplay no fuss",
					GameGenre.ADVENTURE, Platform.PC, new BigDecimal(250), new BigDecimal(250), 0, 0f, new Date());
			break;
		case CHEAP:
			game = new Game(vendorId, "A Cheap Game", "A Very Cheap Game",
					"A cheap game with very low budget, made with much heart and love and no money at all.",
					GameGenre.PLATFORMER, Platform.PC, new BigDecimal(50), new BigDecimal(50), 0, 0f, new Date());
			break;
		case TRIPLEAADVENTURE:
			game = new Game(vendorId, "A Robust Adventure", "The Best Adventure Of Your Life",
					"A Magnificent adventure of which you have never dreamed, filled with wonders and magic, equipped with multiplayer and coop.",
					GameGenre.ADVENTURE, Platform.PC, new BigDecimal(350), new BigDecimal(350), 0, 0f, new Date());
			break;
		case TRIPLEAACTION:
			game = new Game(vendorId, "A Most Action Filled Game", "Intense Action Until You Die",
					"An intense rollercoaster ride, thrilling and exciting until the very last moments, equipped with multiplayer and coop.",
					GameGenre.ACTION, Platform.PC, new BigDecimal(350), new BigDecimal(350), 0, 0f, new Date());
			break;
		case TRIPLEA:
			game = new Game(vendorId, "Made By Rich Folk", "This Game Has Every Feature Money Can Buy",
					"Our team of 3000 programmers, 300 UI/UX, designers and the like have created a game with every possible feature imaginable.",
					GameGenre.SANDBOX, Platform.PC, new BigDecimal(350), new BigDecimal(350), 0, 0f, new Date());
			break;
		case TRIPLEARPG:
			game = new Game(vendorId, "Real Life Simulator With Magic", "A Game About Eating Carrots And Leveling Up",
					"In our amazing adventure, you can explore galaxies, defeat monsters, earn new gear, levels and spells, all the while eating carrots and onions.",
					GameGenre.RPG, Platform.PC, new BigDecimal(350), new BigDecimal(350), 0, 0f, new Date());
			break;
		case STANDARDINDIE:
			game = new Game(vendorId, "Game For Hipsters", "If You Don't Like It You're Stupid",
					"This game might look very simple, but it's actually very sophisticated. If you don't like it, you're probably not smart enough.",
					GameGenre.PLATFORMER, Platform.PC, new BigDecimal(50), new BigDecimal(50), 0, 0f, new Date());
			break;
		default:
			game = new Game(vendorId, "Default Game", "A most standard game",
					"A game about doing standard things, no coop, no multiplayer, just standard gameplay no fuss",
					GameGenre.ACTION, Platform.PC, new BigDecimal(150), new BigDecimal(150), 0, 0f, new Date());
			break;
		}
		// syncing 1 to 1 relationship
		game.setGallery(new Gallery());
		game.getGallery().setGame(game);
		System.out.println(game);
		return game;
	}
}
