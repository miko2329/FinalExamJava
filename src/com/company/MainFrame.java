package com.company;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static Login login;

    public static AdminMenu adminMenu;
    public static NurseMenu nurseMenu;
    public static DoctorMenu doctorMenu;

    public static AddPersonal.AddAdmin addAdmin;
    public static AddPersonal.AddNurse addNurse;
    public static AddPersonal.AddDoctor addDoctor;
    public static AddPatient addPatient;

    public static UpdatePersonal.UpdateAdmin updateAdmin;
    public static UpdatePersonal.UpdateNurse updateNurse;
    public static UpdatePersonal.UpdateDoctor updateDoctor;
    public static UpdatePatient updatePatient;

    public static SearchPersonal.SearchAdmin searchAdmin;
    public static SearchPersonal.SearchNurse searchNurse;
    public static SearchPersonal.SearchDoctor searchDoctor;
    public static SearchPatient searchPatient;

    public static DeletePersonal.DeleteAdmin deleteAdmin;
    public static DeletePersonal.DeleteNurse deleteNurse;
    public static DeletePersonal.DeleteDoctor deleteDoctor;
    public static DeletePatient deletePatient;

    public static ViewPersonal.ViewAdmin viewAdmin;
    public static ViewPersonal.ViewNurse viewNurse;
    public static ViewPersonal.ViewDoctor viewDoctor;
    public static ViewPatient viewPatient;

    public MainFrame() {
        setSize(800, 800);
        setTitle("Hospital Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        login = new Login();
        login.setLocation(0, 0);
        add(login);

        adminMenu = new AdminMenu();
        adminMenu.setLocation(0,0);
        adminMenu.setVisible(false);
        add(adminMenu);

        nurseMenu = new NurseMenu();
        nurseMenu.setLocation(0,0);
        nurseMenu.setVisible(false);
        add(nurseMenu);

        doctorMenu = new DoctorMenu();
        doctorMenu.setLocation(0,0);
        doctorMenu.setVisible(false);
        add(doctorMenu);

        addAdmin = new AddPersonal.AddAdmin();
        addAdmin.setLocation(0,0);
        addAdmin.setVisible(false);
        add(addAdmin);

        addNurse = new AddPersonal.AddNurse();
        addNurse.setLocation(0,0);
        addNurse.setVisible(false);
        add(addNurse);

        addDoctor = new AddPersonal.AddDoctor();
        addDoctor.setLocation(0,0);
        addDoctor.setVisible(false);
        add(addDoctor);

        addPatient = new AddPatient();
        addPatient.setLocation(0,0);
        addPatient.setVisible(false);
        add(addPatient);

        updateAdmin = new UpdatePersonal.UpdateAdmin();
        updateAdmin.setLocation(0,0);
        updateAdmin.setVisible(false);
        add(updateAdmin);

        updateNurse = new UpdatePersonal.UpdateNurse();
        updateNurse.setLocation(0,0);
        updateNurse.setVisible(false);
        add(updateNurse);

        updateDoctor = new UpdatePersonal.UpdateDoctor();
        updateDoctor.setLocation(0,0);
        updateDoctor.setVisible(false);
        add(updateDoctor);

        updatePatient = new UpdatePatient();
        updatePatient.setLocation(0,0);
        updatePatient.setVisible(false);
        add(updatePatient);

        searchAdmin = new SearchPersonal.SearchAdmin();
        searchAdmin.setLocation(0,0);
        searchAdmin.setVisible(false);
        add(searchAdmin);

        searchNurse = new SearchPersonal.SearchNurse();
        searchNurse.setLocation(0,0);
        searchNurse.setVisible(false);
        add(searchNurse);

        searchDoctor = new SearchPersonal.SearchDoctor();
        searchDoctor.setLocation(0,0);
        searchDoctor.setVisible(false);
        add(searchDoctor);

        searchPatient = new SearchPatient();
        searchPatient.setLocation(0,0);
        searchPatient.setVisible(false);
        add(searchPatient);

        deleteAdmin = new DeletePersonal.DeleteAdmin();
        deleteAdmin.setLocation(0,0);
        deleteAdmin.setVisible(false);
        add(deleteAdmin);

        deleteNurse = new DeletePersonal.DeleteNurse();
        deleteNurse.setLocation(0,0);
        deleteNurse.setVisible(false);
        add(deleteNurse);

        deleteDoctor = new DeletePersonal.DeleteDoctor();
        deleteDoctor.setLocation(0,0);
        deleteDoctor.setVisible(false);
        add(deleteDoctor);

        deletePatient = new DeletePatient();
        deletePatient.setLocation(0,0);
        deletePatient.setVisible(false);
        add(deletePatient);

        viewAdmin = new ViewPersonal.ViewAdmin();
        viewAdmin.setLocation(0,0);
        viewAdmin.setVisible(false);
        add(viewAdmin);

        viewNurse = new ViewPersonal.ViewNurse();
        viewNurse.setLocation(0,0);
        viewNurse.setVisible(false);
        add(viewNurse);

        viewDoctor = new ViewPersonal.ViewDoctor();
        viewDoctor.setLocation(0,0);
        viewDoctor.setVisible(false);
        add(viewDoctor);

        viewPatient = new ViewPatient();
        viewPatient.setLocation(0,0);
        viewPatient.setVisible(false);
        add(viewPatient);
    }
}
