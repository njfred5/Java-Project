package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.Model.Plane;
import com.HippyAir.hippyair_backend.Service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.createPlane(plane));
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlane(@PathVariable Long id) {
        return ResponseEntity.ok(planeService.getPlaneById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.updatePlane(id, plane));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return ResponseEntity.noContent().build();
    }
}
