package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.repository.MilesRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class MilesRewardService {

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    public long countRewardsThisYear(String passport) {
        int currentYear = LocalDate.now().getYear();
        return milesRewardRepository.countByClientAndYear(passport, currentYear);
    }

    public String checkDiscountEligibility(String passport) {
        long rewardsThisYear = countRewardsThisYear(passport);
        if (rewardsThisYear >= 3) {
            String discountCode = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            return "Discount code: " + discountCode;
        } else {
            return "No discount yet. Flights this year: " + rewardsThisYear;
        }
    }
}
