package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    public Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            while((packageData=(PackageData)inputStream.readObject())!=null){
                if(packageData.operationType.equals("Login")){
                    if(packageData.personType.equals("Admin")){
                        Boolean flag = DBManager.loginAdmin(packageData.admin);
                        outputStream.writeObject(flag);
                    }
                    else if(packageData.personType.equals("Nurse")){
                        Boolean flag = DBManager.loginNurse(packageData.nurse);
                        outputStream.writeObject(flag);
                    }
                    else if(packageData.personType.equals("Doctor")){
                        Boolean flag = DBManager.loginDoctor(packageData.doctor);
                        outputStream.writeObject(flag);
                    }
                }

                else if(packageData.operationType.equals("Add")){
                    if(packageData.personType.equals("Admin")){
                        Admin admin = packageData.admin;
                        DBManager.addAdmin(admin);
                    }
                    else if(packageData.personType.equals("Nurse")){
                        Nurse nurse = packageData.nurse;
                        DBManager.addNurse(nurse);
                    }
                    else if(packageData.personType.equals("Doctor")){
                        Doctor doctor = packageData.doctor;
                        DBManager.addDoctor(doctor);
                    }
                    else if(packageData.personType.equals("Patient")){
                        Patient patient = packageData.patient;
                        DBManager.addPatient(patient);
                    }
                }

                else if(packageData.operationType.equals("Search")){
                    if(packageData.personType.equals("Admin")){
                        Admin admin = DBManager.getAdmin(packageData.admin);
                        outputStream.writeObject(admin);
                    }
                    else if(packageData.personType.equals("Nurse")){
                        Nurse nurse = DBManager.getNurse(packageData.nurse);
                        outputStream.writeObject(nurse);
                    }
                    else if(packageData.personType.equals("Doctor")){
                        Doctor doctor = DBManager.getDoctor(packageData.doctor);
                        outputStream.writeObject(doctor);
                    }
                    else if(packageData.personType.equals("Patient")){
                        Patient patient = DBManager.getPatient(packageData.patient);
                        outputStream.writeObject(patient);
                    }
                }

                else if(packageData.operationType.equals("Update")){
                    if(packageData.personType.equals("Admin")){
                        Admin admin = packageData.admin;
                        DBManager.updateAdmin(admin);
                    }
                    else if(packageData.personType.equals("Nurse")){
                        Nurse nurse = packageData.nurse;
                        DBManager.updateNurse(nurse);
                    }
                    else if(packageData.personType.equals("Doctor")){
                        Doctor doctor = packageData.doctor;
                        DBManager.updateDoctor(doctor);
                    }
                    else if(packageData.personType.equals("Patient")){
                        Patient patient = packageData.patient;
                        DBManager.updatePatient(patient);
                    }
                }

                else if(packageData.operationType.equals("Delete")){
                    if(packageData.personType.equals("Admin")){
                        Boolean flag = DBManager.deleteAdmin(packageData.admin);
                        outputStream.writeObject(flag);
                    }
                    else if(packageData.personType.equals("Nurse")){
                        Boolean flag = DBManager.deleteNurse(packageData.nurse);
                        outputStream.writeObject(flag);
                    }
                    else if(packageData.personType.equals("Doctor")){
                        Boolean flag = DBManager.deleteDoctor(packageData.doctor);
                        outputStream.writeObject(flag);
                    }
                    else if(packageData.personType.equals("Patient")){
                        Boolean flag = DBManager.deletePatient(packageData.patient);
                        outputStream.writeObject(flag);
                    }
                }

                else if(packageData.operationType.equals("List")){
                    if(packageData.personType.equals("Admin")){
                        ArrayList<Admin> forClient = DBManager.getAdmins();
                        PackageData toClient = new PackageData();
                        toClient.setAdmins(forClient);
                        outputStream.writeObject(toClient);
                    }
                    else if(packageData.personType.equals("Nurse")){
                        ArrayList<Nurse> forClient = DBManager.getNurses();
                        PackageData toClient = new PackageData();
                        toClient.setNurses(forClient);
                        outputStream.writeObject(toClient);
                    }
                    else if(packageData.personType.equals("Doctor")){
                        ArrayList<Doctor> forClient = DBManager.getDoctors();
                        PackageData toClient = new PackageData();
                        toClient.setDoctors(forClient);
                        outputStream.writeObject(toClient);
                    }
                    else if(packageData.personType.equals("Patient")){
                        ArrayList<Patient> forClient = DBManager.getPatients();
                        PackageData toClient = new PackageData();
                        toClient.setPatients(forClient);
                        outputStream.writeObject(toClient);
                    }
                }

                else if(packageData.operationType.equals("GTI")){
                    Boolean flag = DBManager.giveTheInjection(packageData.nurse, packageData.patient);
                    if(flag==true) DBManager.incrementInjection(packageData.nurse);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("GTD")){
                    Boolean flag = DBManager.giveTheDrug(packageData.nurse, packageData.patient);
                    if(flag==true) DBManager.incrementDrug(packageData.nurse);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("MTT")){
                    Boolean flag = DBManager.measureTheTemperature(packageData.nurse, packageData.patient);
                    if(flag==true) DBManager.incrementTemperature(packageData.nurse);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("MTP")){
                    Boolean flag = DBManager.measureThePressure(packageData.nurse, packageData.patient);
                    if(flag==true) DBManager.incrementPressure(packageData.nurse);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("MMPN")){
                    Boolean flag = DBManager.makeNursePatient(packageData.nurse, packageData.patient);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("PTI")){
                    Boolean flag = DBManager.prescribeTheInjection(packageData.doctor, packageData.patient);
                    if(flag==true) DBManager.incrementInjectionDoctor(packageData.doctor);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("PTD")){
                    Boolean flag = DBManager.prescribeTheDrug(packageData.doctor, packageData.patient);
                    if(flag==true) DBManager.incrementDrugDoctor(packageData.doctor);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("MTD")){
                    Boolean flag = DBManager.makeTheDiagnosis(packageData.doctor, packageData.patient);
                    if(flag==true) DBManager.incrementDiagnosisDoctor(packageData.doctor);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("ATS")){
                    Boolean flag = DBManager.assignTheStatus(packageData.doctor, packageData.patient);
                    if(flag==true) DBManager.incrementStatusDoctor(packageData.doctor);
                    outputStream.writeObject(flag);
                }

                else if(packageData.operationType.equals("MMPD")){
                    Boolean flag = DBManager.makeDoctorPatient(packageData.doctor, packageData.patient);
                    outputStream.writeObject(flag);
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
