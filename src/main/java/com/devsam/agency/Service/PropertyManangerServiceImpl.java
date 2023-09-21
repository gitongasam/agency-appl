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
        Optional<Role> roleOptional = Optional.ofNullable(roleRepository.findByName("USER"));

        String encodedIdNumber = passswordencoder.encode(propertyManager.getIdNumber());
        propertyManager.setIdNumber(encodedIdNumber);


        // Set the encoded IdNumber in the PropertyManager object
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
}
