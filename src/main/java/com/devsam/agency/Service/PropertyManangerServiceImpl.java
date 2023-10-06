package com.devsam.agency.Service;

import com.devsam.agency.Entity.PropertyManager;
import com.devsam.agency.Entity.Role;
import com.devsam.agency.Repository.PropertyManagerRepository;
import com.devsam.agency.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyManangerServiceImpl implements PropertyManagerService{


    @Autowired
    private PropertyManagerRepository propertyManagerRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passswordencoder;

    public PropertyManangerServiceImpl(PropertyManagerRepository propertyManagerRepository) {
        this.propertyManagerRepository = propertyManagerRepository;
    }

    public PropertyManager save(PropertyManager propertyManager) {
        Optional<Role> roleOptional = Optional.ofNullable(roleRepository.findByName("ROLE_USER"));

        String encodedIdNumber = passswordencoder.encode(propertyManager.getIdNumber());
        propertyManager.setIdNumber(encodedIdNumber);
        propertyManager.setIdNumber(encodedIdNumber);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            propertyManager.setRoles(Collections.singleton(role));
            return propertyManagerRepository.save(propertyManager);
        } else {

            throw new RuntimeException("Role 'ROLE_USER' not found");
        }
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
    @Override
    public PropertyManager update(PropertyManager propertyManager) {
        // Find the existing property manager by ID
        Optional<PropertyManager> existingPropertyManagerOptional = propertyManagerRepository.findById(propertyManager.getId());

        if (existingPropertyManagerOptional.isPresent()) {
            PropertyManager existingPropertyManager = existingPropertyManagerOptional.get();
            existingPropertyManager.setProperties(propertyManager.getProperties()); // You can update properties if needed
            return propertyManagerRepository.save(existingPropertyManager);
        } else {
            // Handle the case where the property manager with the given ID doesn't exist
            throw new RuntimeException("Property Manager not found with ID: " + propertyManager.getId());
        }
    }
}
