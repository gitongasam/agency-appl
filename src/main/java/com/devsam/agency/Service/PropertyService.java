package com.devsam.agency.Service;

import com.devsam.agency.Entity.Property;
import com.devsam.agency.Entity.PropertyManager;

public interface PropertyService {
    Property save(Property property);

    Property findById(Long id);
}
