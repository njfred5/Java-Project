package com.HippyAir.hippyair_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HippyAir.hippyair_backend.model.MilesReward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface MilesRewardRepository extends JpaRepository<MilesReward, Long> {

    @Query("SELECT COUNT(m) FROM MilesReward m " +
           "WHERE m.client.numPassport = :passport " +
           "AND YEAR(m.date) = :year")
    long countByClientAndYear(@Param("passport") String passport, @Param("year") int year);
}
