package com.example.RestProject.dao;


import com.example.RestProject.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneNumberDao extends JpaRepository<PhoneNumber,Integer>{

    Optional<PhoneNumber> findByPhoneNumber(String phoneNumber);
    Optional<List<PhoneNumber>> findAllByIsActive(boolean isActive);
}
