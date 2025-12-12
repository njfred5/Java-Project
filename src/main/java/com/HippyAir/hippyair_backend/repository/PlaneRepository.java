package com.HippyAir.hippyair_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.Model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
