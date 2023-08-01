package com.example.RestProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.security.PrivateKey;
import java.util.Date;

@Entity //varlık classı olduğunu belirtir
@Table(name = "phone_numbers") //db de varsa aç yoksa ekle
@Data //getter setter
@AllArgsConstructor //bütün argümanları alıp constructera koyuyor
@NoArgsConstructor //boş bir contracter oluşturuyor gerekli olur diye

public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    private boolean isActive;

    @Column(name = "status")
    private String status; //available and locked

    @Column(name = "create_date")
    @CreationTimestamp    //@CreatedDate JPA repository de düzgün çalışmadı bunu kullandım
    private Date createDate;

    @Column(name = "update_date")
    @UpdateTimestamp

    private Date updateDate;

    //LocalDateTime Bilgisayarın zaman dilimini baz alır buralarda çalışan doğru annotation //@LastModifiedDate
    //Eğer Get isteğinde response epoch Time olarak dönerse bu anatayon kullanılır @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

}

//create
