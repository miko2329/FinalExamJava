package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    public String operationType;
    public String personType;
    public Admin admin;
    public ArrayList<Admin> admins;
    public Nurse nurse;
    public ArrayList<Nurse> nurses;
    public Doctor doctor;
    public ArrayList<Doctor> doctors;
    public Patient patient;
    public ArrayList<Patient> patients;

    public PackageData() {
    }

    public PackageData(String operationType, String personType, Admin admin) {
        this.operationType = operationType;
        this.personType = personType;
        this.admin = admin;
    }

    public PackageData(String operationType, String personType, Nurse nurse) {
        this.operationType = operationType;
        this.personType = personType;
        this.nurse = nurse;
    }

    public PackageData(String operationType, String personType, Doctor doctor) {
        this.operationType = operationType;
        this.personType = personType;
        this.doctor = doctor;
    }

    public PackageData(String operationType, String personType, Patient patient) {
        this.operationType = operationType;
        this.personType = personType;
        this.patient = patient;
    }

    public PackageData(String operationType, String personType, Nurse nurse, Patient patient) {
        this.operationType = operationType;
        this.personType = personType;
        this.nurse = nurse;
        this.patient = patient;
    }

    public PackageData(String operationType, String personType, Doctor doctor, Patient patient) {
        this.operationType = operationType;
        this.personType = personType;
        this.doctor = doctor;
        this.patient = patient;
    }

    public PackageData(String operationType, String personType) {
        this.operationType = operationType;
        this.personType = personType;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
