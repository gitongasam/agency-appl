package com.devsam.agency.Controller;
import com.devsam.agency.Entity.Property;
import com.devsam.agency.Service.PropertyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
public class PropertyController {
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/add")
    public Property save(@RequestBody Property property){
        return propertyService.save(property);
    }
    @GetMapping("/{id}")
    public Property findbyId(@PathVariable Long id){
        return propertyService.findById(id);
    }
}
