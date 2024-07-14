package com.example.demo;

import com.example.demo.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
    List<Battery> findByPostcode(String postcode);
    List<Battery> findByPostcodeBetween(String startPostcode, String endPostcode);
}
