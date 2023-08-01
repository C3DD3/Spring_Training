package com.example.RestProject.rest.external.controller;

import com.example.RestProject.model.ApiResultModel;
import com.example.RestProject.model.PhoneNumber;
import com.example.RestProject.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //RESTCONTROLLER URL ERİŞİMİ
@RequestMapping("api/phoneNumber") //DIŞ DÜNYAYA HANGİ URL İLE ERİŞECEKSİN

public class PhoneNumberController {
    private PhoneNumberService phoneNumberService;

    @Autowired //new leyebileceği bir classı bulur ve newler
    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;

    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PhoneNumber phoneNumber) {
        return ResponseEntity.ok(phoneNumberService.create(phoneNumber));
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PhoneNumber phoneNumber) {
        return ResponseEntity.ok(phoneNumberService.update(phoneNumber));
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(phoneNumberService.getAll());
    }

    @GetMapping("/getAll/v2")
    public ApiResultModel getAllV2() {
        return null;
    }
    @GetMapping("/getByPhoneNumber")
    public ResponseEntity<?> getByPhoneNumber(@RequestParam("phoneNumber")String phoneNumber) {

        return ResponseEntity.ok(phoneNumberService.findByPhoneNumber(phoneNumber));

    }
    @GetMapping("/getRandomNumbers")
    public ResponseEntity<?> getRandomNumbers() {
        return ResponseEntity.ok(phoneNumberService.getRandomPhoneNumbers(true));
    }
}
