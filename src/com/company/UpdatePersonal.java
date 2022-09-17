package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePersonal {

    public static class UpdateAdmin extends Container {
        private JLabel[] labels = new JLabel[7];

        public static TextField[] textFields = new TextField[7];

        private String[] attributes = {"PASSWORD:", "NAME:", "SURNAME:", "PHONE:", "EXPERIENCE:", "ADDRESS:", "SALARY:"};

        private JButton updateButton;
        private JButton backButton;

        public static Long id;

        public UpdateAdmin(){
            setSize(800, 800);
            setLayout(null);

            int px=110;
            for(int i=0; i<7; i++){
                labels[i] = new JLabel(attributes[i]);
                labels[i].setBounds(50, px,300,25);
                add(labels[i]);

                textFields[i] = new TextField();
                textFields[i].setBounds(400, px, 300, 25);
                add(textFields[i]);

                px+=50;
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
                    String password = textFields[0].getText();
                    String name = textFields[1].getText();
                    String surname = textFields[2].getText();
                    String phone = textFields[3].getText();
                    int experience = Integer.parseInt(textFields[4].getText());
                    String address = textFields[5].getText();
                    int salary = Integer.parseInt(textFields[6].getText());

                    PackageData pd = new PackageData("Update", "Admin", new Admin(id, password, name, surname, phone, experience, address, salary));
                    Main.connect(pd);
                }
            });
            add(updateButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300,30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.updateAdmin.setVisible(false);
                    Main.frame.searchAdmin.setVisible(true);
                    for(int i=0; i<7; i++){
                        textFields[i].setText("");
                    }
                    SearchPersonal.SearchAdmin.flag=false;
                    Main.frame.searchAdmin.resultLabel.setText("");
                }
            });
            add(backButton);
        }
    }

    public static class UpdateNurse extends Container {
        private JLabel[] labels = new JLabel[11];

        public static TextField[] textFields = new TextField[11];

        private String[] attributes = {"PASSWORD:", "NAME:", "SURNAME:", "PHONE:", "EXPERIENCE:", "ADDRESS:", "SALARY:", "COUNT OF INJECTIONS:", "COUNT OF DRUGS:", "COUNT OF TEMPERATURES:", "COUNT OF PRESSURES:"};

        private JButton updateButton;
        private JButton backButton;

        public static Long id;

        public UpdateNurse(){
            setSize(800, 800);
            setLayout(null);

            int px=110;
            for(int i=0; i<11; i++){
                labels[i] = new JLabel(attributes[i]);
                labels[i].setBounds(50, px,300,25);
                add(labels[i]);

                textFields[i] = new TextField();
                textFields[i].setBounds(400, px, 300, 25);
                add(textFields[i]);

                px+=50;
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
                    String password = textFields[0].getText();
                    String name = textFields[1].getText();
                    String surname = textFields[2].getText();
                    String phone = textFields[3].getText();
                    int experience = Integer.parseInt(textFields[4].getText());
                    String address = textFields[5].getText();
                    int salary = Integer.parseInt(textFields[6].getText());

                    int[] ints = new int[4];
                    for(int i=0; i<4; i++){
                        ints[i]=Integer.parseInt(textFields[7+i].getText());
                    }

                    PackageData pd = new PackageData("Update", "Nurse", new Nurse(id, password, name, surname, phone, experience, address, salary, ints[0], ints[1], ints[2], ints[3]));
                    Main.connect(pd);
                }
            });
            add(updateButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300,30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.updateNurse.setVisible(false);
                    Main.frame.searchAdmin.setVisible(true);
                    for(int i=0; i<11; i++){
                        textFields[i].setText("");
                    }
                    SearchPersonal.SearchNurse.flag=false;
                    Main.frame.searchNurse.resultLabel.setText("");
                }
            });
            add(backButton);
        }
    }

    public static class UpdateDoctor extends Container {
        private JLabel[] labels = new JLabel[11];

        public static TextField[] textFields = new TextField[11];

        private String[] attributes = {"PASSWORD:", "NAME:", "SURNAME:", "PHONE:", "EXPERIENCE:", "ADDRESS:", "SALARY:", "COUNT OF DIAGNOSES:", "COUNT OF DRUGS:", "COUNT OF INJECTIONS:", "COUNT OF STATUSES:"};

        private JButton updateButton;
        private JButton backButton;

        public static Long id;

        public UpdateDoctor(){
            setSize(800, 800);
            setLayout(null);

            int px=110;
            for(int i=0; i<11; i++){
                labels[i] = new JLabel(attributes[i]);
                labels[i].setBounds(50, px,300,25);
                add(labels[i]);

                textFields[i] = new TextField();
                textFields[i].setBounds(400, px, 300, 25);
                add(textFields[i]);

                px+=50;
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
                    String password = textFields[0].getText();
                    String name = textFields[1].getText();
                    String surname = textFields[2].getText();
                    String phone = textFields[3].getText();
                    int experience = Integer.parseInt(textFields[4].getText());
                    String address = textFields[5].getText();
                    int salary = Integer.parseInt(textFields[6].getText());

                    int[] ints = new int[4];
                    for(int i=0; i<4; i++){
                        ints[i]=Integer.parseInt(textFields[7+i].getText());
                    }

                    PackageData pd = new PackageData("Update", "Doctor", new Doctor(id, password, name, surname, phone, experience, address, salary, ints[0], ints[1], ints[2], ints[3]));
                    Main.connect(pd);
                }
            });
            add(updateButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300,30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.updateDoctor.setVisible(false);
                    Main.frame.searchAdmin.setVisible(true);
                    for(int i=0; i<11; i++){
                        textFields[i].setText("");
                    }
                    SearchPersonal.SearchDoctor.flag=false;
                    Main.frame.searchDoctor.resultLabel.setText("");
                }
            });
            add(backButton);
        }
    }
}
