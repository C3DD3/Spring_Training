package com.example.RestProject.service;

import com.example.RestProject.model.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    public PhoneNumber create(PhoneNumber phoneNumber);

    public PhoneNumber update(PhoneNumber phoneNumber);

    public List<PhoneNumber> getAll();

    public PhoneNumber findByPhoneNumber(String phoneNumber);

    public List<PhoneNumber> getRandomPhoneNumbers(boolean isActive);


}
