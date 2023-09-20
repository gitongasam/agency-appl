package com.devsam.agency.Controller;

import com.devsam.agency.Entity.PropertyManager;
import com.devsam.agency.Entity.Tenants;
import com.devsam.agency.Service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant")
public class TenantsController {
    @Autowired
    private TenantService tenantService;

    public TenantsController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/save")
    public Tenants save(@RequestBody Tenants tenant){
        return tenantService.save(tenant);
    }
    @RequestMapping("{id}")
    public Tenants findbyId(@PathVariable Long id){
        return tenantService.findById(id);
    }
    @RequestMapping("{firstname}")
    public Tenants findbyfirstname(@PathVariable String firstname){
        return tenantService.findByfirstname(firstname);
    }

}
