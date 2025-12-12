package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Plane;
import com.HippyAir.hippyair_backend.Repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    // Create a new plane
    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    // Get all planes
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    // Get plane by ID
    public Plane getPlaneById(Long id) {
        return planeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plane not found"));
    }

    // Update plane
    public Plane updatePlane(Long id, Plane updatedPlane) {
        Plane existing = getPlaneById(id);

        existing.setBrand(updatedPlane.getBrand());
        existing.setModel(updatedPlane.getModel());
        existing.setManufacturingYear(updatedPlane.getManufacturingYear());

        return planeRepository.save(existing);
    }

    // Delete plane
    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }
}
