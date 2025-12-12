package com.HippyAir.hippyair_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
