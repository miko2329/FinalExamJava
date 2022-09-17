package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static MainFrame frame;

    public static void main(String[] args) {
        frame = new MainFrame();
        frame.setVisible(true);
    }

    public static void connect(PackageData pd){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.operationType.equals("Login")){
                if(pd.personType.equals("Admin")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    Login.flag = flag;
                }
                else if(pd.personType.equals("Nurse")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    Login.flag = flag;
                }
                else if(pd.personType.equals("Doctor")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    Login.flag = flag;
                }
            }

            else if(pd.operationType.equals("Add")){
                outputStream.writeObject(pd);
            }

            else if(pd.operationType.equals("Search")){
                if(pd.personType.equals("Admin")){
                    outputStream.writeObject(pd);
                    Admin admin = (Admin) inputStream.readObject();
                    UpdatePersonal.UpdateAdmin.id = admin.getId();
                    UpdatePersonal.UpdateAdmin.textFields[0].setText(admin.getPassword());
                    UpdatePersonal.UpdateAdmin.textFields[1].setText(admin.getName());
                    UpdatePersonal.UpdateAdmin.textFields[2].setText(admin.getSurname());
                    UpdatePersonal.UpdateAdmin.textFields[3].setText(admin.getPhone());
                    UpdatePersonal.UpdateAdmin.textFields[4].setText(String.valueOf(admin.getExperience()));
                    UpdatePersonal.UpdateAdmin.textFields[5].setText(admin.getAddress());
                    UpdatePersonal.UpdateAdmin.textFields[6].setText(String.valueOf(admin.getSalary()));
                    if(admin!=null){
                        Main.frame.searchAdmin.setVisible(false);
                        Main.frame.updateAdmin.setVisible(true);
                    }
                }
                else if(pd.personType.equals("Nurse")){
                    outputStream.writeObject(pd);
                    Nurse nurse = (Nurse) inputStream.readObject();
                    UpdatePersonal.UpdateNurse.id = nurse.getId();
                    UpdatePersonal.UpdateNurse.textFields[0].setText(nurse.getPassword());
                    UpdatePersonal.UpdateNurse.textFields[1].setText(nurse.getName());
                    UpdatePersonal.UpdateNurse.textFields[2].setText(nurse.getSurname());
                    UpdatePersonal.UpdateNurse.textFields[3].setText(nurse.getPhone());
                    UpdatePersonal.UpdateNurse.textFields[4].setText(String.valueOf(nurse.getExperience()));
                    UpdatePersonal.UpdateNurse.textFields[5].setText(nurse.getAddress());
                    UpdatePersonal.UpdateNurse.textFields[6].setText(String.valueOf(nurse.getSalary()));
                    UpdatePersonal.UpdateNurse.textFields[7].setText(String.valueOf(nurse.getCountInjections()));
                    UpdatePersonal.UpdateNurse.textFields[8].setText(String.valueOf(nurse.getCountDrugs()));
                    UpdatePersonal.UpdateNurse.textFields[9].setText(String.valueOf(nurse.getCountTemperatures()));
                    UpdatePersonal.UpdateNurse.textFields[10].setText(String.valueOf(nurse.getCountPressures()));
                    if(nurse!=null){
                        Main.frame.searchNurse.setVisible(false);
                        Main.frame.updateNurse.setVisible(true);
                    }
                }
                else if(pd.personType.equals("Doctor")){
                    outputStream.writeObject(pd);
                    Doctor doctor = (Doctor) inputStream.readObject();
                    UpdatePersonal.UpdateDoctor.id = doctor.getId();
                    UpdatePersonal.UpdateDoctor.textFields[0].setText(doctor.getPassword());
                    UpdatePersonal.UpdateDoctor.textFields[1].setText(doctor.getName());
                    UpdatePersonal.UpdateDoctor.textFields[2].setText(doctor.getSurname());
                    UpdatePersonal.UpdateDoctor.textFields[3].setText(doctor.getPhone());
                    UpdatePersonal.UpdateDoctor.textFields[4].setText(String.valueOf(doctor.getExperience()));
                    UpdatePersonal.UpdateDoctor.textFields[5].setText(doctor.getAddress());
                    UpdatePersonal.UpdateDoctor.textFields[6].setText(String.valueOf(doctor.getSalary()));
                    UpdatePersonal.UpdateDoctor.textFields[7].setText(String.valueOf(doctor.getDiagnosesCounter()));
                    UpdatePersonal.UpdateDoctor.textFields[8].setText(String.valueOf(doctor.getDrugsCounter()));
                    UpdatePersonal.UpdateDoctor.textFields[9].setText(String.valueOf(doctor.getInjectionsCounter()));
                    UpdatePersonal.UpdateDoctor.textFields[10].setText(String.valueOf(doctor.getStatusCounter()));
                    if(doctor!=null){
                        Main.frame.searchDoctor.setVisible(false);
                        Main.frame.updateDoctor.setVisible(true);
                    }
                }
                else if(pd.personType.equals("Patient")){
                    outputStream.writeObject(pd);
                    Patient patient = (Patient) inputStream.readObject();
                    UpdatePatient.id = patient.getId();
                    UpdatePatient.textFields[0].setText(patient.getName());
                    UpdatePatient.textFields[1].setText(patient.getSurname());
                    UpdatePatient.textFields[2].setText(patient.getPhone());
                    UpdatePatient.textFields[3].setText(patient.getAddress());
                    UpdatePatient.textFields[4].setText(String.valueOf(patient.getWardNumber()));
                    UpdatePatient.textFields[5].setText(patient.getDrug());
                    UpdatePatient.textFields[6].setText(patient.getInjection());
                    UpdatePatient.textFields[7].setText(patient.getDiagnosis());
                    UpdatePatient.textFields[8].setText(String.valueOf(patient.getCountOfDrugs()));
                    UpdatePatient.textFields[9].setText(String.valueOf(patient.getCountOfInjections()));
                    UpdatePatient.textFields[10].setText(patient.getStatus());
                    UpdatePatient.textFields[11].setText(String.valueOf(patient.getLastTemperature()));
                    UpdatePatient.textFields[12].setText(patient.getLastPressure());
                    UpdatePatient.textFields[13].setText(String.valueOf(patient.getIdOfDoctor()));
                    UpdatePatient.textFields[14].setText(String.valueOf(patient.getIdOfNurse()));
                    if(patient!=null){
                        Main.frame.searchPatient.setVisible(false);
                        Main.frame.updatePatient.setVisible(true);
                    }
                }
            }

            else if(pd.operationType.equals("Update")){
                outputStream.writeObject(pd);
            }

            else if(pd.operationType.equals("Delete")){
                if(pd.personType.equals("Admin")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    DeletePersonal.DeleteAdmin.flag = flag;
                }
                else if(pd.personType.equals("Nurse")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    DeletePersonal.DeleteNurse.flag = flag;
                }
                else if(pd.personType.equals("Doctor")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    DeletePersonal.DeleteDoctor.flag = flag;
                }
                else if(pd.personType.equals("Patient")){
                    outputStream.writeObject(pd);
                    Boolean flag = (Boolean) inputStream.readObject();
                    DeletePatient.flag = flag;
                }
            }

            else if(pd.operationType.equals("List")){
                if(pd.personType.equals("Admin")){
                    outputStream.writeObject(pd);
                    PackageData fromServer = (PackageData) inputStream.readObject();
                    ArrayList<Admin> admins = fromServer.getAdmins();
                    String s = "";

                    for(int i=0; i < admins.size(); i++){
                        s+=admins.get(i).personalInfo()+"\n";
                    }

                    ViewPersonal.ViewAdmin.list.append(s);
                }
                else if(pd.personType.equals("Nurse")){
                    outputStream.writeObject(pd);
                    PackageData fromServer = (PackageData) inputStream.readObject();
                    ArrayList<Nurse> nurses = fromServer.getNurses();
                    String s = "";

                    for(int i=0; i < nurses.size(); i++){
                        s+=nurses.get(i).personalInfo()+"\n";
                    }

                    ViewPersonal.ViewNurse.list.append(s);
                }
                else if(pd.personType.equals("Doctor")){
                    outputStream.writeObject(pd);
                    PackageData fromServer = (PackageData) inputStream.readObject();
                    ArrayList<Doctor> doctors = fromServer.getDoctors();
                    String s = "";

                    for(int i=0; i < doctors.size(); i++){
                        s+=doctors.get(i).personalInfo()+"\n";
                    }

                    ViewPersonal.ViewDoctor.list.append(s);
                }
                else if(pd.personType.equals("Patient")){
                    outputStream.writeObject(pd);
                    PackageData fromServer = (PackageData) inputStream.readObject();
                    ArrayList<Patient> patients = fromServer.getPatients();
                    String s = "";

                    for(int i=0; i < patients.size(); i++){
                        s+=patients.get(i).patientInfo()+"\n";
                    }

                    ViewPatient.list.append(s);
                }
            }
            else if(pd.operationType.equals("GTI")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                NurseMenu.flag = flag;
            }
            else if(pd.operationType.equals("GTD")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                NurseMenu.flag = flag;
            }
            else if(pd.operationType.equals("MTT")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                NurseMenu.flag = flag;
            }
            else if(pd.operationType.equals("MTP")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                NurseMenu.flag = flag;
            }
            else if(pd.operationType.equals("MMPN")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                NurseMenu.flag = flag;
            }
            else if(pd.operationType.equals("PTI")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                DoctorMenu.flag = flag;
            }
            else if(pd.operationType.equals("PTD")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                DoctorMenu.flag = flag;
            }
            else if(pd.operationType.equals("MTD")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                DoctorMenu.flag = flag;
            }
            else if(pd.operationType.equals("ATS")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                DoctorMenu.flag = flag;
            }
            else if(pd.operationType.equals("MMPD")){
                outputStream.writeObject(pd);
                Boolean flag = (Boolean) inputStream.readObject();
                DoctorMenu.flag = flag;
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
