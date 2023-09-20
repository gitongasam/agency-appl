package com.devsam.agency.Service;

import com.devsam.agency.Entity.Property;
import com.devsam.agency.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property findById(Long id) {
        return propertyRepository.findById(id).get();
    }




}
