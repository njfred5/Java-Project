package com.HippyAir.hippyair_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.Model.MilesReward;

import java.util.List;

@Repository
public interface MilesRewardRepository extends JpaRepository<MilesReward, Long> {
    List<MilesReward> findByClientNumPassport(String numPassport);
}

