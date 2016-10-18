package com.simakad.dao.dto;

/**
 * Created by HighDream on 9/25/2016.
 */
public class StudentRegistrationRequest {
    String name;
    String email;
    String identityCardNumber;
    String identityCardNumberType;
    String gender;
    String address;
    String city;
    String province;

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
}
