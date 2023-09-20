package com.devsam.agency.Repository;

import com.devsam.agency.Entity.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantsRepository extends JpaRepository<Tenants,Long> {
    Tenants findByFirstname(String firstname);
}
