package com.devsam.agency.Repository;

import com.devsam.agency.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property,Long> {
}
