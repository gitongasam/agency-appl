package com.devsam.agency.Entity;

import com.devsam.agency.Entity.PropertyManager;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private double rentAmount;
    private Long numberOfRooms;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pr_id",referencedColumnName = "id")
    private List<Room> rooms = new ArrayList<>();


}
