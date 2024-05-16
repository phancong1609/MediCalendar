package com.example.medicalendar.request;

import java.util.Date;

public class CreateProfileRequest {
    String name;
    Date birthdate;
    Date registerDate;
    String gender;
    String idNumber;
    String idHealthInsurance;
    String job;
    String phone;
    String nation;
    String ethnicGroup;
    String province;
    String district;
    String ward;
    String addressNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdHealthInsurance() {
        return idHealthInsurance;
    }

    public void setIdHealthInsurance(String idHealthInsurance) {
        this.idHealthInsurance = idHealthInsurance;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
    public CreateProfileRequest() {
    }
    public CreateProfileRequest(String name, Date birthdate, Date registerDate, String gender, String idNumber, String idHealthInsurance, String job, String phone, String nation, String ethnicGroup, String province, String district, String ward, String addressNumber) {
        this.name = name;
        this.birthdate = birthdate;
        this.registerDate = registerDate;
        this.gender = gender;
        this.idNumber = idNumber;
        this.idHealthInsurance = idHealthInsurance;
        this.job = job;
        this.phone = phone;
        this.nation = nation;
        this.ethnicGroup = ethnicGroup;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.addressNumber = addressNumber;
    }
}
