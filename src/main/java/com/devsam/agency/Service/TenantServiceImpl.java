package com.devsam.agency.Service;

import com.devsam.agency.Entity.Tenants;
import com.devsam.agency.Repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService{
    @Autowired
    private TenantsRepository tenantsRepository;
    public TenantServiceImpl(TenantsRepository tenantsRepository) {
        this.tenantsRepository = tenantsRepository;
    }
    @Override
    public Tenants save(Tenants tenant) {
        return tenantsRepository.save(tenant);
    }
    @Override
    public Tenants findById(Long id) {
        return tenantsRepository.findById(id).get();
    }
    @Override
    public Tenants findByfirstname(String firstname) {
        return tenantsRepository.findByFirstname(firstname);
    }
}
