package com.devsam.agency.Config;

import com.devsam.agency.Entity.PropertyManager;
import com.devsam.agency.Repository.PropertyManagerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private PropertyManagerRepository propertyManagerRepository;

    public CustomUserDetailsService(PropertyManagerRepository propertyManagerRepository) {
        this.propertyManagerRepository = propertyManagerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PropertyManager user = propertyManagerRepository.findByEmail(email);


        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getIdNumber(),
                authorities);
    }
}