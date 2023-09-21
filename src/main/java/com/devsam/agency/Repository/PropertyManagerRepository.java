package com.devsam.agency.Repository;

import com.devsam.agency.Entity.PropertyManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyManagerRepository extends JpaRepository<PropertyManager,Long> {
    PropertyManager findByFirstname(String firstname);

    PropertyManager findByEmail(String email);
}
