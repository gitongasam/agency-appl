package com.devsam.agency.Controller;
import com.devsam.agency.Config.JWTGenerator;
import com.devsam.agency.DTO.LoginDto;
import com.devsam.agency.Entity.AuthResponseDTO;
import com.devsam.agency.Entity.PropertyManager;
import com.devsam.agency.Service.PropertyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/manager")
public class PropertyManagerController {
    @Autowired
    private JWTGenerator jwtGenerator;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private PropertyManagerService propertyManagerService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/save")
    public PropertyManager save(@RequestBody PropertyManager propertyManager) {
        return propertyManagerService.save(propertyManager);
    }

    @GetMapping("/all")
    public List<PropertyManager> getAll(){
        return propertyManagerService.getAll();
    }

    @GetMapping("/id/{id}")
    public PropertyManager findbyId(@PathVariable Long id){
        return propertyManagerService.findById(id);
    }

    @GetMapping("/firstname/{firstname}")
    public PropertyManager findbyfirstname(@PathVariable("firstname") String firstname) {
        return propertyManagerService.findByfirstname(firstname);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getIdNumber()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token).toString(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePropertyManager(@PathVariable Long id, @RequestBody PropertyManager updatedPropertyManager) {
        PropertyManager existingPropertyManager = propertyManagerService.findById(id);
        if (existingPropertyManager == null) {
            return new ResponseEntity<>("Property Manager not found", HttpStatus.NOT_FOUND);
        }

        // You can update the properties of the existing property manager with the data from updatedPropertyManager here.

        PropertyManager updatedManager = propertyManagerService.save(updatedPropertyManager);
        return new ResponseEntity<>("Property Manager updated successfully", HttpStatus.OK);
    }

}
