package com.company;

public class Doctor extends Personal {
    public int diagnosesCounter;
    public int drugsCounter;
    public int injectionsCounter;
    public int statusCounter;

    public Doctor() {
    }

    public Doctor(Long id) {
        super(id);
    }

    public Doctor(Long id, String password) {
        super(id, password);
    }

    public Doctor(Long id, String password, String name, String surname, String phone, int experience, String address, int salary, int diagnosesCounter, int drugsCounter, int injectionsCounter, int statusCounter) {
        super(id, password, name, surname, phone, experience, address, salary);
        this.diagnosesCounter = diagnosesCounter;
        this.drugsCounter = drugsCounter;
        this.injectionsCounter = injectionsCounter;
        this.statusCounter = statusCounter;
    }

    public int getDiagnosesCounter() {
        return diagnosesCounter;
    }

    public void setDiagnosesCounter(int diagnosesCounter) {
        this.diagnosesCounter = diagnosesCounter;
    }

    public int getDrugsCounter() {
        return drugsCounter;
    }

    public void setDrugsCounter(int drugsCounter) {
        this.drugsCounter = drugsCounter;
    }

    public int getInjectionsCounter() {
        return injectionsCounter;
    }

    public void setInjectionsCounter(int injectionsCounter) {
        this.injectionsCounter = injectionsCounter;
    }

    public int getStatusCounter() {
        return statusCounter;
    }

    public void setStatusCounter(int statusCounter) {
        this.statusCounter = statusCounter;
    }

    @Override
    public String personalInfo() {
        String info=super.personalInfo();
        info+=" "+diagnosesCounter+" "+drugsCounter+" "+injectionsCounter+" "+statusCounter;
        return info;
    }
}
