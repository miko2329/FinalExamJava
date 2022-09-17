package com.company;

import java.io.Serializable;

public abstract class Personal implements Serializable {
    public Long id;
    public String password;
    public String name;
    public String surname;
    public String phone;
    public int experience;
    public String address;
    public int salary;

    public Personal() {
    }

    public Personal(Long id) {
        this.id = id;
    }

    public Personal(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Personal(Long id, String password, String name, String surname, String phone, int experience, String address, int salary) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.experience = experience;
        this.address = address;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String personalInfo(){
        String info=id+" "+password+" "+name+" "+surname+" "+phone+" "+experience+" "+address;
        return info;
    }
}
