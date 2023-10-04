package com.devsam.agency.Entity;

import com.devsam.agency.Entity.Property;
import com.devsam.agency.Entity.Tenants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Room")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL)
    private Tenants tenant;

}
