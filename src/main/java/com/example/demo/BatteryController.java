package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.demo.model.Battery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/batteries")
public class BatteryController {
    @Autowired
    private BatteryService batteryService;

    @PostMapping
    public ResponseEntity<List<Battery>> createBatteries(@RequestBody List<Battery> batteries) {
        System.out.println(batteries);
        List<Battery> savedBatteries = batteryService.saveBatteries(batteries);
        return new ResponseEntity<>(savedBatteries, HttpStatus.CREATED);
    }

    @GetMapping("/postcode")
    public ResponseEntity<List<Battery>> getBatteriesByPostcodeRange(
            @RequestParam String startPostcode,
            @RequestParam String endPostcode
    ) {
        List<Battery> batteries = batteryService.findBatteriesByPostcodeRange(startPostcode, endPostcode);
        return new ResponseEntity<>(batteries, HttpStatus.OK);
    }
}
