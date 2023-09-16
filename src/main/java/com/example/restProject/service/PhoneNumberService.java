package com.example.restProject.service;

import com.example.restProject.model.PhoneNumber;
import com.example.restProject.model.PhoneNumberStatus;

import java.util.List;

public interface PhoneNumberService {

    public PhoneNumber create(PhoneNumber phoneNumber);

    public PhoneNumber update(PhoneNumber phoneNumber);

    public List<PhoneNumber> getAll();

    public PhoneNumber findByPhoneNumber(String phoneNumber);

    public List<PhoneNumber> getRandomPhoneNumbers(PhoneNumberStatus status);

    public PhoneNumber phoneNumberReservation(String phoneNumber);

    public PhoneNumber changeStatus(int id, PhoneNumberStatus status);
}
