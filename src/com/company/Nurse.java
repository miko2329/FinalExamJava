package com.company;

public class Nurse extends Personal {
    public int countInjections;
    public int countDrugs;
    public int countTemperatures;
    public int countPressures;

    public Nurse() {
    }

    public Nurse(Long id) {
        super(id);
    }

    public Nurse(Long id, String password) {
        super(id, password);
    }

    public Nurse(Long id, String password, String name, String surname, String phone, int experience, String address, int salary, int countInjections, int countDrugs, int countTemperatures, int countPressures) {
        super(id, password, name, surname, phone, experience, address, salary);
        this.countInjections = countInjections;
        this.countDrugs = countDrugs;
        this.countTemperatures = countTemperatures;
        this.countPressures = countPressures;
    }

    public int getCountInjections() {
        return countInjections;
    }

    public void setCountInjections(int countInjections) {
        this.countInjections = countInjections;
    }

    public int getCountDrugs() {
        return countDrugs;
    }

    public void setCountDrugs(int countDrugs) {
        this.countDrugs = countDrugs;
    }

    public int getCountTemperatures() {
        return countTemperatures;
    }

    public void setCountTemperatures(int countTemperatures) {
        this.countTemperatures = countTemperatures;
    }

    public int getCountPressures() {
        return countPressures;
    }

    public void setCountPressures(int countPressures) {
        this.countPressures = countPressures;
    }

    @Override
    public String personalInfo() {
        String info=super.personalInfo();
        info+=" "+countInjections+" "+countDrugs+" "+countTemperatures+" "+countPressures;
        return info;
    }
}
