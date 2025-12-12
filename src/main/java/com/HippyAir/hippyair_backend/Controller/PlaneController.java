package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.Model.Plane;
import com.HippyAir.hippyair_backend.DTO.PlaneDTO;
import com.HippyAir.hippyair_backend.Service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody PlaneDTO planeDTO) {
        Plane savedPlane = planeService.createPlane(planeDTO);
        return ResponseEntity.ok(savedPlane);
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable Long id) {
        Plane plane = planeService.getPlaneById(id);
        return ResponseEntity.ok(plane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody PlaneDTO planeDTO) {
        Plane updatedPlane = planeService.updatePlane(id, planeDTO);
        return ResponseEntity.ok(updatedPlane);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return ResponseEntity.noContent().build();
    }
}
