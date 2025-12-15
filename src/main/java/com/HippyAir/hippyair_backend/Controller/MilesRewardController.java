package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.model.MilesReward;
import com.HippyAir.hippyair_backend.Service.MilesRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rewards")
public class MilesRewardController {

    @Autowired
    private MilesRewardService milesRewardService;

    @GetMapping
    public List<MilesReward> getAllRewards() {
        return milesRewardService.getAllRewards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilesReward> getRewardById(@PathVariable Long id) {
        return ResponseEntity.ok(milesRewardService.getRewardById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReward(@PathVariable Long id) {
        milesRewardService.deleteReward(id);
        return ResponseEntity.noContent().build();
    }

    // Check discount eligibility and generate code if eligible
    @GetMapping("/client/{passportNumber}/discount")
    public ResponseEntity<String> checkDiscount(@PathVariable String passportNumber) {
        List<MilesReward> rewardsThisYear = milesRewardService.getAllRewards()
                .stream()
                .filter(r -> r.getClient().getNumPassport().equals(passportNumber)
                        && r.getDate().getYear() == LocalDate.now().getYear())
                .toList();

        if (rewardsThisYear.size() >= 3) {
            String discountCode = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            return ResponseEntity.ok("Discount code: " + discountCode);
        } else {
            return ResponseEntity.ok("No discount yet. Flights this year: " + rewardsThisYear.size());
        }
    }
}
