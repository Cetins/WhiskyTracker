package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskeys")
    public ResponseEntity<List<Whisky>> getAllWhiskeys() {
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskeys/{id}")
    public ResponseEntity getWhiskey(@PathVariable Long id) {
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskeys/year/{year}")
    public ResponseEntity getWhiskeysByYear(@PathVariable int year) {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskeys/distillery/{distilleryName}/{age}")
    public ResponseEntity getWhiskyByDistilleryAndAge(@PathVariable String distilleryName, @PathVariable Integer age) {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameIgnoreCaseAndAge(distilleryName, age), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskeys/region/{region}")
    public ResponseEntity getWhiskyByRegion(@PathVariable String region) {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegionIgnoreCase(region), HttpStatus.OK);
    }
}

//    @GetMapping(value = "/raids")
//    public ResponseEntity<List<Raid>> getAllRaids(
//            @RequestParam(name = "location", required = false) String location
//    ) {
//        if (location!=null) {
//            return new ResponseEntity<>(raidRepository.findDistinctiveRaidsByLocation(location),HttpStatus.OK);
//        }
//        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
//    }
