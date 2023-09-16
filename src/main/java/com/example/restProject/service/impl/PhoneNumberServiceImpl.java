package com.example.restProject.service.impl;

import com.example.restProject.dao.PhoneNumberDao;
import com.example.restProject.model.PhoneNumber;
import com.example.restProject.model.PhoneNumberStatus;
import com.example.restProject.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class PhoneNumberServiceImpl implements PhoneNumberService {
    private PhoneNumberDao phoneNumberDao;
    @Autowired
    public PhoneNumberServiceImpl(PhoneNumberDao phoneNumberDao) {
        this.phoneNumberDao = phoneNumberDao;
    }

    @Override
    public PhoneNumber create(PhoneNumber phoneNumber) {
        if (phoneNumber.getPhoneNumber() == null ){
            System.out.println("Phone Number Can Not Be Null");
            return phoneNumber ;
        }
        phoneNumber.setStatus(PhoneNumberStatus.Available);
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
    public List<PhoneNumber> getRandomPhoneNumbers(PhoneNumberStatus status) {
        List<PhoneNumber> phoneNumbers = this.phoneNumberDao.findAllByStatus(status).orElse(null);
        if (phoneNumbers == null)
            return null;
        Collections.shuffle(phoneNumbers);
        int subListLength = phoneNumbers.size() < 8 ? phoneNumbers.size():8;
        return phoneNumbers.subList(0,subListLength);
    }

    public PhoneNumber phoneNumberReservation(String phoneNumber){
        PhoneNumber phoneNum = this.phoneNumberDao.findByPhoneNumber(phoneNumber).orElse(null);
        if (phoneNum == null)
            return null;

        phoneNum.setStatus(PhoneNumberStatus.Hold);
        return phoneNum;
    }

    @Override
    public PhoneNumber changeStatus(int id, PhoneNumberStatus status) {
        PhoneNumber phoneNumber = phoneNumberDao.findById(id).orElse(null);
        if (phoneNumber == null) {
            System.out.println("Phone number couldn't be fount");
            return null;
        }
        phoneNumber.setStatus(status);
        return this.phoneNumberDao.save(phoneNumber);
    }
}
