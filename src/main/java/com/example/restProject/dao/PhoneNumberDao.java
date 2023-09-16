package com.example.restProject.dao;


import com.example.restProject.model.PhoneNumber;
import com.example.restProject.model.PhoneNumberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneNumberDao extends JpaRepository<PhoneNumber,Integer>{

    Optional<PhoneNumber> findByPhoneNumber(String phoneNumber);
    Optional<List<PhoneNumber>> findAllByStatus(PhoneNumberStatus status);
}
