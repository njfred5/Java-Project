package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlane;

    private String brand;
    private String model;
    private Integer manufacturingYear;

    @OneToMany(mappedBy = "plane")
    private List<Flight> flights;

    // getters and setters
    public Long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Long idPlane) {
        this.idPlane = idPlane;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Integer manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

}
