package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends Container {
    private JLabel actionLabel;
    private JLabel personLabel;

    private String[] actionType = {"ADD", "UPDATE", "REMOVE", "VIEW"};
    private String[] personType = {"ADMIN","NURSE", "DOCTOR", "PATIENT"};

    private JComboBox actionBox;
    private JComboBox personBox;

    private JButton acceptButton;
    private JButton exitButton;

    public AdminMenu(){
        setSize(800, 800);
        setLayout(null);

        actionLabel = new JLabel("ACTION:");
        actionLabel.setBounds(200, 250, 100, 25);
        add(actionLabel);

        actionBox = new JComboBox(actionType);
        actionBox.setBounds(325, 250, 200, 25);
        add(actionBox);

        personLabel = new JLabel("PERSON:");
        personLabel.setBounds(200, 300, 100, 25);
        add(personLabel);

        personBox = new JComboBox(personType);
        personBox.setBounds(325, 300, 200, 25);
        add(personBox);

        acceptButton = new JButton("ACCEPT");
        acceptButton.setBounds(200, 400, 150, 30);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = actionBox.getSelectedIndex();
                int person = personBox.getSelectedIndex();

                if(action==0) {
                    if (person==0){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.addAdmin.setVisible(true);
                    }
                    else if (person==1){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.addNurse.setVisible(true);
                    }
                    else if (person==2){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.addDoctor.setVisible(true);
                    }
                    else if (person==3){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.addPatient.setVisible(true);
                    }
                }
                else if(action==1) {
                    if (person==0){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.searchAdmin.setVisible(true);
                    }
                    else if (person==1){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.searchNurse.setVisible(true);
                    }
                    else if (person==2){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.searchDoctor.setVisible(true);
                    }
                    else if (person==3){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.searchPatient.setVisible(true);
                    }
                }

                else if(action==2){
                    if (person==0){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.deleteAdmin.setVisible(true);
                    }
                    else if (person==1){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.deleteNurse.setVisible(true);
                    }
                    else if (person==2){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.deleteDoctor.setVisible(true);
                    }
                    else if (person==3){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.deletePatient.setVisible(true);
                    }
                }

                else if(action==3){
                    if (person==0){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.viewAdmin.setVisible(true);
                    }
                    else if (person==1){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.viewNurse.setVisible(true);
                    }
                    else if (person==2){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.viewDoctor.setVisible(true);
                    }
                    else if (person==3){
                        Main.frame.adminMenu.setVisible(false);
                        Main.frame.viewPatient.setVisible(true);
                    }
                }
            }
        });
        add(acceptButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(375, 400, 150, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}
