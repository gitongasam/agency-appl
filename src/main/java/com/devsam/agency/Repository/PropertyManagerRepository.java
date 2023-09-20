package com.devsam.agency.Repository;

import com.devsam.agency.Entity.PropertyManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyManagerRepository extends JpaRepository<PropertyManager,Long> {
    PropertyManager findByFirstname(String firstname);
}
