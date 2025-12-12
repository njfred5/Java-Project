package com.HippyAir.hippyair_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HippyAir.hippyair_backend.Model.MilesReward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface MilesRewardRepository extends JpaRepository<MilesReward, Long> {
    List<MilesReward> findByClientNumPassport(String numPassport);
    @Query("SELECT COUNT(m) FROM MilesReward m WHERE m.client.numPassport = :passport AND FUNCTION('YEAR', m.date) = :year")
    long countByClientAndYear(@Param("passport") String passport, @Param("year") int year);
}

