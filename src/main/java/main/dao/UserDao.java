package main.dao;


import main.beans.entities.Game;
import main.beans.entities.User;
import main.beans.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByName(String name);

    User findByUsername(String userName);

    User findUserById(Long id);

//	@Query("SELECT u FROM User AS u WHERE u.password = password AND u.name = name")
//	User login(String name, String password);

}
