package com.company;

public class Admin extends Personal {
    public Admin() {
    }

    public Admin(Long id) {
        super(id);
    }

    public Admin(Long id, String password) {
        super(id, password);
    }

    public Admin(Long id, String password, String name, String surname, String phone, int experience, String address, int salary) {
        super(id, password, name, surname, phone, experience, address, salary);
    }
}
