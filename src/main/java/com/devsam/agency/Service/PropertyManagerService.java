package com.devsam.agency.Service;

import com.devsam.agency.Entity.PropertyManager;

import java.util.List;

public interface PropertyManagerService {
    PropertyManager save(PropertyManager propertyManager);

    List<PropertyManager> getAll();

    PropertyManager findById(Long id);

    PropertyManager findByfirstname(String firstname);
    PropertyManager update(PropertyManager propertyManager); // Add this method

}
