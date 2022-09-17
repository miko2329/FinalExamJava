package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatient extends Container {
    private JLabel[] labels = new JLabel[15];

    public static TextField[] textFields = new TextField[15];

    private String[] attributes = {"NAME:", "SURNAME:", "PHONE:", "ADDRESS:", "NUMBER OF WARD:", "DRUG NAME:", "INJECTION NAME:", "DIAGNOSIS:", "COUNT OF DRUG:", "COUNT OF INJECTION:", "STATUS:", "TEMPERATURE:", "PRESSURE:", "ID OF DOCTOR:", "ID OF NURSE:"};

    private JButton updateButton;
    private JButton backButton;

    public static Long id;

    public UpdatePatient() {
        setSize(800, 800);
        setLayout(null);

        int px = 50;
        for (int i = 0; i < 15; i++) {
            labels[i] = new JLabel(attributes[i]);
            labels[i].setBounds(50, px, 300, 25);
            add(labels[i]);

            textFields[i] = new TextField();
            textFields[i].setBounds(400, px, 300, 25);
            add(textFields[i]);

            px += 40;
        }

            /*textFields[0].setText(admin.getPassword());
            textFields[1].setText(admin.getName());
            textFields[2].setText(admin.getSurname());
            textFields[3].setText(admin.getPhone());
            textFields[4].setText(String.valueOf(admin.getExperience()));
            textFields[5].setText(admin.getAddress());
            textFields[6].setText(String.valueOf(admin.getSalary()));*/

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(50, 700, 300, 30);
        updateButton.addActionListener(new ActionListener() {
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

                PackageData pd = new PackageData("Update", "Patient", new Patient(id, name, surname, phone, address, wardNum, drug, injection, diagnosis, counterDrug, counterInjection, status, temperature, pressure, doctor, nurse));
                Main.connect(pd);
            }
        });
        add(updateButton);

        backButton = new JButton("BACK");
        backButton.setBounds(400, 700, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.updatePatient.setVisible(false);
                Main.frame.searchPatient.setVisible(true);
                for (int i = 0; i < 15; i++) {
                    textFields[i].setText("");
                }
                SearchPatient.flag = false;
                Main.frame.searchPatient.resultLabel.setText("");
            }
        });
        add(backButton);
    }
}

