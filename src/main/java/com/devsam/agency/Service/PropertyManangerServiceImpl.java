package com.devsam.agency.Service;

import com.devsam.agency.Entity.PropertyManager;
import com.devsam.agency.Repository.PropertyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyManangerServiceImpl implements PropertyManagerService{


    @Autowired
    private PropertyManagerRepository propertyManagerRepository;

    public PropertyManangerServiceImpl(PropertyManagerRepository propertyManagerRepository) {
        this.propertyManagerRepository = propertyManagerRepository;
    }

    @Override
    public PropertyManager save(PropertyManager propertyManager) {

        return propertyManagerRepository.save(propertyManager);
    }


    @Override
    public List<PropertyManager> getAll() {
        return propertyManagerRepository.findAll();
    }

    @Override
    public PropertyManager findById(Long id) {
        return propertyManagerRepository.findById(id).get();
    }

    @Override
    public PropertyManager findByfirstname(String firstname) {
        return propertyManagerRepository.findByFirstname(firstname);
    }
}
