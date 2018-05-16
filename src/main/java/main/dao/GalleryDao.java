package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.beans.entities.Gallery;

@Repository
public interface GalleryDao extends JpaRepository<Gallery, Long> {

}
