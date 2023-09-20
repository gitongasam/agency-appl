package com.devsam.agency.Controller;

import com.devsam.agency.Entity.PropertyManager;
import com.devsam.agency.Entity.Tenants;
import com.devsam.agency.Service.PropertyManagerService;
import com.devsam.agency.Service.PropertyService;
import com.devsam.agency.Service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class PropertyManagerController {
    @Autowired
    private PropertyManagerService propertyManagerService;
    @PostMapping("/save")
    public PropertyManager save(@RequestBody PropertyManager propertyManager){
        return propertyManagerService.save(propertyManager);
    }
    @RequestMapping("/all")
    public List<PropertyManager> getAll(){
        return propertyManagerService.getAll();
    }

    @RequestMapping("{id}")
    public PropertyManager findbyId(@PathVariable Long id){
        return propertyManagerService.findById(id);
    }
    @RequestMapping("{firstname}")
    public PropertyManager findbyfirstname(@PathVariable String firstname){
        return propertyManagerService.findByfirstname(firstname);
    }

}
