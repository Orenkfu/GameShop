package main.dao;

import main.beans.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.beans.entities.RetailImage;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageDao extends JpaRepository<RetailImage, Long> {

    List<RetailImage> getRetailImagesByGallery(Gallery gallery);

    RetailImage findRetailImageByImage(String path);

    // @Query("SELECT i FROM RetailImage AS i WHERE g.vendorId = vendorId")
	// List<RetailImage> getAllByGameId(Long id);

}
