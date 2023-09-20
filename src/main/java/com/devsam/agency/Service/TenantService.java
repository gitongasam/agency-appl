package com.devsam.agency.Service;

import com.devsam.agency.Entity.Tenants;

public interface TenantService {
    Tenants save(Tenants tenant);

    Tenants findById(Long id);

    Tenants findByfirstname(String firstname);
}
