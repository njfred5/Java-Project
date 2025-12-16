package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.model.Plane;
import com.HippyAir.hippyair_backend.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public Plane getPlaneById(Long id) {
        return planeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plane not found"));
    }

    public Plane updatePlane(Long id, Plane planeDetails) {
        Plane plane = getPlaneById(id);
        plane.setBrand(planeDetails.getBrand());
        plane.setModel(planeDetails.getModel());
        plane.setManufacturingYear(planeDetails.getManufacturingYear());
        return planeRepository.save(plane);
    }

    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }
}
