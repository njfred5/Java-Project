package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.Service.MilesRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
public class MilesRewardController {

    @Autowired
    private MilesRewardService milesRewardService;

    // Check discount eligibility and generate code if eligible
    @GetMapping("/client/{passportNumber}/discount")
    public ResponseEntity<String> checkDiscount(@PathVariable String passportNumber) {
        String result = milesRewardService.checkDiscountEligibility(passportNumber);
        return ResponseEntity.ok(result);
    }
}
