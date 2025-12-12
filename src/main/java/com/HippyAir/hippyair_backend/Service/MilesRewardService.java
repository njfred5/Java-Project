package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.MilesReward;
import com.HippyAir.hippyair_backend.Repository.MilesRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilesRewardService {

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    public MilesReward saveReward(MilesReward reward) {
        return milesRewardRepository.save(reward);
    }

    public List<MilesReward> getAllRewards() {
        return milesRewardRepository.findAll();
    }

    public MilesReward getRewardById(Long id) {
        return milesRewardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reward not found"));
    }

    public void deleteReward(Long id) {
        milesRewardRepository.deleteById(id);
    }
}
