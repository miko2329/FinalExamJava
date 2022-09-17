package com.company;

import java.io.Serializable;

public class Patient implements Serializable {
    public Long id;
    public String name;
    public String surname;
    public String phone;
    public String address;
    public int wardNumber;
    public String drug;
    public String injection;
    public String diagnosis;
    public int countOfDrugs;
    public int countOfInjections;
    public String status;
    public double lastTemperature;
    public String lastPressure;
    public Long idOfDoctor;
    public Long idOfNurse;

    public Patient() {
    }

    public Patient(Long id) {
        this.id = id;
    }

    public Patient(Long id, double lastTemperature) {
        this.id = id;
        this.lastTemperature = lastTemperature;
    }

    public Patient(Long id, String lastPressure) {
        this.id = id;
        this.lastPressure = lastPressure;
    }

    public Patient(Long id, String name, String surname, String phone, String address, int wardNumber, String drug, String injection, String diagnosis, int countOfDrugs, int countOfInjections, String status, double lastTemperature, String lastPressure, Long idOfDoctor, Long idOfNurse) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.wardNumber = wardNumber;
        this.drug = drug;
        this.injection = injection;
        this.diagnosis = diagnosis;
        this.countOfDrugs = countOfDrugs;
        this.countOfInjections = countOfInjections;
        this.status = status;
        this.lastTemperature = lastTemperature;
        this.lastPressure = lastPressure;
        this.idOfDoctor = idOfDoctor;
        this.idOfNurse = idOfNurse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(int wardNumber) {
        this.wardNumber = wardNumber;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getInjection() {
        return injection;
    }

    public void setInjection(String injection) {
        this.injection = injection;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getCountOfDrugs() {
        return countOfDrugs;
    }

    public void setCountOfDrugs(int countOfDrugs) {
        this.countOfDrugs = countOfDrugs;
    }

    public int getCountOfInjections() {
        return countOfInjections;
    }

    public void setCountOfInjections(int countOfInjections) {
        this.countOfInjections = countOfInjections;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLastTemperature() {
        return lastTemperature;
    }

    public void setLastTemperature(double lastTemperature) {
        this.lastTemperature = lastTemperature;
    }

    public String getLastPressure() {
        return lastPressure;
    }

    public void setLastPressure(String lastPressure) {
        this.lastPressure = lastPressure;
    }

    public Long getIdOfDoctor() {
        return idOfDoctor;
    }

    public void setIdOfDoctor(Long idOfDoctor) {
        this.idOfDoctor = idOfDoctor;
    }

    public Long getIdOfNurse() {
        return idOfNurse;
    }

    public void setIdOfNurse(Long idOfNurse) {
        this.idOfNurse = idOfNurse;
    }

    public String patientInfo() {
        String info=id+" "+name+" "+surname+" "+phone+" "+address+" "+wardNumber+" "+drug+" "+injection+" "+diagnosis+" "+countOfDrugs+" "+countOfInjections+" "+status+" "+lastTemperature+" "+lastPressure+" "+idOfDoctor+" "+idOfNurse;
        return info;
    }
}
