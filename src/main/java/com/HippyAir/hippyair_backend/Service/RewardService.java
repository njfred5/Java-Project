package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.MilesReward;
import com.HippyAir.hippyair_backend.Model.DiscountCode;
import com.HippyAir.hippyair_backend.Repository.MilesRewardRepository;
import com.HippyAir.hippyair_backend.Repository.DiscountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.UUID;

@Service
public class RewardService {

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    // Record a flight booking into MilesReward
    public void recordFlight(Long clientId, Long flightId) {
        MilesReward reward = new MilesReward();
        reward.setClientId(clientId);
        reward.setFlightId(flightId);
        reward.setDate(LocalDate.now());
        milesRewardRepository.save(reward);

        // Check if client qualifies for discount
        long flightsThisYear = milesRewardRepository.countByClientIdAndYear(clientId, Year.now().getValue());
        if (flightsThisYear >= 3) {
            DiscountCode code = new DiscountCode();
            code.setClientId(clientId);
            code.setCode(generateRandomCode());
            discountCodeRepository.save(code);
        }
    }

    // Get all rewards for a client
    public List<MilesReward> getRewardsByClient(Long clientId) {
        return milesRewardRepository.findByClientId(clientId);
    }

    // Get discount codes for a client
    public List<DiscountCode> getDiscountCodesByClient(Long clientId) {
        return discountCodeRepository.findByClientId(clientId);
    }

    // Generate random discount code
    private String generateRandomCode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
