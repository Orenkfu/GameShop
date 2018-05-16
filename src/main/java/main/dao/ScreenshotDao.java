package main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.beans.entities.Gallery;
import main.beans.entities.Screenshot;

@Repository
public interface ScreenshotDao extends JpaRepository<Screenshot, Long> {

	List<Screenshot> findScreenShotByGallery(Gallery gallery);

	// Screenshot findScreenshotByImage(String path);

	Screenshot findScreenshotByImage(String path);
}
