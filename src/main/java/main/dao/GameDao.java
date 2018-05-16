package main.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.beans.entities.Game;
import main.beans.entities.User;
import main.beans.entities.Vendor;

@Repository
public interface GameDao extends JpaRepository<Game, Long> {
	List<Game> findGamesByVendor(Vendor vendor);

	Game findGameById(Long id);

	List<Game> findGamesByUser(User user);

	Game findGameByTitle(String title);

	List<Game> findGamesByUserId(Long id, Pageable page);

	List<Game> findGamesByVendorId(Long id);
}
