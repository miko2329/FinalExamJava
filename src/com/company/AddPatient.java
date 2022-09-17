package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatient extends Container {
    private JLabel[] labels = new JLabel[15];

    private TextField[] textFields = new TextField[15];

    private String[] attributes = {"NAME:", "SURNAME:", "PHONE:", "ADDRESS:", "NUMBER OF WARD:", "DRUG NAME:", "INJECTION NAME:", "DIAGNOSIS:", "COUNT OF DRUG:", "COUNT OF INJECTION:", "STATUS:", "TEMPERATURE:", "PRESSURE:", "ID OF DOCTOR:", "ID OF NURSE:"};

    private JButton addButton;
    private JButton backButton;

    public AddPatient() {
        setSize(800, 800);
        setLayout(null);

        int px=50;
        for(int i=0; i<15; i++){
            labels[i] = new JLabel(attributes[i]);
            labels[i].setBounds(50, px, 300,25);
            add(labels[i]);

            textFields[i] = new TextField();
            textFields[i].setBounds(400, px, 300, 25);
            add(textFields[i]);

            px+=40;
        }

        addButton = new JButton("ADD");
        addButton.setBounds(50, 650, 300, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFields[0].getText();
                String surname = textFields[1].getText();
                String phone = textFields[2].getText();
                String address = textFields[3].getText();
                int wardNum = Integer.parseInt(textFields[4].getText());
                String drug = textFields[5].getText();
                String injection = textFields[6].getText();
                String diagnosis = textFields[7].getText();
                int counterDrug = Integer.parseInt(textFields[8].getText());
                int counterInjection = Integer.parseInt(textFields[9].getText());
                String status = textFields[10].getText();
                double temperature = Double.parseDouble(textFields[11].getText());
                String pressure = textFields[12].getText();
                Long doctor = Long.parseLong(textFields[13].getText());
                Long nurse = Long.parseLong(textFields[14].getText());

                PackageData pd = new PackageData("Add", "Patient", new Patient(null,name, surname, phone, address, wardNum, drug, injection, diagnosis, counterDrug, counterInjection, status, temperature, pressure, doctor, nurse));
                Main.connect(pd);

                for(int i=0; i<15; i++){
                    textFields[i].setText("");
                }
            }
        });
        add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(400, 650, 300,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addPatient.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
                for(int i=0; i<15; i++){
                    textFields[i].setText("");
                }
            }
        });
        add(backButton);
    }
}
