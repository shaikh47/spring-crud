package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Battery;

@Service
public class BatteryService {
    @Autowired
    private BatteryRepository batteryRepository;

     public List<Battery> saveBatteries(List<Battery> batteries) {
        return batteryRepository.saveAll(batteries);
    }

    public List<Battery> findBatteriesByPostcodeRange(String startPostcode, String endPostcode) {
        return batteryRepository.findByPostcodeBetween(startPostcode, endPostcode);
    }
}
