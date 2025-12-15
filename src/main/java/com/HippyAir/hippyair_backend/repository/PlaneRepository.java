package com.HippyAir.hippyair_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
