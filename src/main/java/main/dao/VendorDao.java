package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.beans.entities.Vendor;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Long> {
	 Vendor findByUsername(String name);

    Vendor findVendorById(Long id);
}
