package com.example.RestProject.service;

import com.example.RestProject.dao.PhoneNumberDao;
import com.example.RestProject.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class PhoneNumberManager implements PhoneNumberService {
    private PhoneNumberDao phoneNumberDao;
    @Autowired
    public PhoneNumberManager(PhoneNumberDao phoneNumberDao) {
        this.phoneNumberDao = phoneNumberDao;
    }

    @Override
    public PhoneNumber create(PhoneNumber phoneNumber) {
        if (phoneNumber.getPhoneNumber() == null ){
            System.out.println("Phone Number Can Not Be Null");
            return phoneNumber ;
        }
        return this.phoneNumberDao.save(phoneNumber);
    }

    @Override
    public PhoneNumber update(PhoneNumber phoneNumber) {
        if (phoneNumber == null ){
            System.out.println("Phone Number Can Not Be Null");
            return phoneNumber ;
        }
        return this.phoneNumberDao.save(phoneNumber);
    }

    @Override
    public List<PhoneNumber> getAll() {
        return this.phoneNumberDao.findAll();
    }

    @Override
    public PhoneNumber findByPhoneNumber(String phoneNumber) {
        return this.phoneNumberDao.findByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public List<PhoneNumber> getRandomPhoneNumbers(boolean isActive) {
        List<PhoneNumber> phoneNumbers = this.phoneNumberDao.findAllByIsActive(isActive).orElse(null);
        if (phoneNumbers == null)
            return null;
        Collections.shuffle(phoneNumbers);
        int subListLength = phoneNumbers.size() < 8 ? phoneNumbers.size():8;
        return phoneNumbers.subList(0,subListLength);
    }
}
