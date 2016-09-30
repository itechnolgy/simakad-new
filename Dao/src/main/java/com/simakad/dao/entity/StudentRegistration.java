package com.simakad.dao.entity;

import javax.persistence.*;

/**
 * Created by HighDream on 9/25/2016.
 */
@Entity
@Table(name = "student_registration")
public class StudentRegistration {
    @Id
    @Basic(optional = false)
    @Column(name = "id")

    private String id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @Column(name = "city")
    private String city;

    @Basic(optional = false)
    @Column(name = "province")
    private String province;

    @Basic(optional = false)
    @Column(name = "identitiy_card_number")
    private String identityCardNumber;

    @Basic(optional = false)
    @Column(name = "identitiy_card_number_type")
    private String identityCardNumberType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getIdentityCardNumberType() {
        return identityCardNumberType;
    }

    public void setIdentityCardNumberType(String identityCardNumberType) {
        this.identityCardNumberType = identityCardNumberType;
    }
}
