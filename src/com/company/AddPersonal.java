package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPersonal {

    public static class AddAdmin extends Container {
        private JLabel[] labels = new JLabel[7];

        private TextField[] textFields = new TextField[7];

        private String[] attributes = {"PASSWORD:", "NAME:", "SURNAME:", "PHONE:", "EXPERIENCE:", "ADDRESS:", "SALARY:"};

        private JButton addButton;
        private JButton backButton;

        public AddAdmin(){
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

            addButton = new JButton("ADD");
            addButton.setBounds(50, 700, 300, 30);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String password = textFields[0].getText();
                    String name = textFields[1].getText();
                    String surname = textFields[2].getText();
                    String phone = textFields[3].getText();
                    int experience = Integer.parseInt(textFields[4].getText());
                    String address = textFields[5].getText();
                    int salary = Integer.parseInt(textFields[6].getText());

                    PackageData pd = new PackageData("Add", "Admin", new Admin(null, password, name, surname, phone, experience, address, salary));
                    Main.connect(pd);

                    for(int i=0; i<7; i++){
                        textFields[i].setText("");
                    }
                }
            });
            add(addButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300,30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.addAdmin.setVisible(false);
                    Main.frame.adminMenu.setVisible(true);
                    for(int i=0; i<7; i++){
                        textFields[i].setText("");
                    }
                }
            });
            add(backButton);
        }
    }

    public static class AddNurse extends Container {
        private JLabel[] labels = new JLabel[11];

        private TextField[] textFields = new TextField[11];

        private String[] attributes = {"PASSWORD:", "NAME:", "SURNAME:", "PHONE:", "EXPERIENCE:", "ADDRESS:", "SALARY:", "COUNT OF INJECTIONS:", "COUNT OF DRUGS:", "COUNT OF TEMPERATURES:", "COUNT OF PRESSURES:"};

        private JButton addButton;
        private JButton backButton;

        public AddNurse(){
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

            addButton = new JButton("ADD");
            addButton.setBounds(50, 700, 300, 30);
            addButton.addActionListener(new ActionListener() {
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

                    PackageData pd = new PackageData("Add", "Nurse", new Nurse(null, password, name, surname, phone, experience, address, salary, ints[0], ints[1], ints[2], ints[3]));
                    Main.connect(pd);

                    for(int i=0; i<11; i++){
                        textFields[i].setText("");
                    }
                }
            });
            add(addButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300,30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.addNurse.setVisible(false);
                    Main.frame.adminMenu.setVisible(true);
                    for(int i=0; i<11; i++){
                        textFields[i].setText("");
                    }
                }
            });
            add(backButton);
        }
    }

    public static class AddDoctor extends Container {
        private JLabel[] labels = new JLabel[11];

        private TextField[] textFields = new TextField[11];

        private String[] attributes = {"PASSWORD:", "NAME:", "SURNAME:", "PHONE:", "EXPERIENCE:", "ADDRESS:", "SALARY:", "COUNT OF DIAGNOSES:", "COUNT OF DRUGS:", "COUNT OF INJECTIONS:", "COUNT OF STATUSES:"};

        private JButton addButton;
        private JButton backButton;

        public AddDoctor(){
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

            addButton = new JButton("ADD");
            addButton.setBounds(50, 700, 300, 30);
            addButton.addActionListener(new ActionListener() {
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

                    PackageData pd = new PackageData("Add", "Doctor", new Doctor(null, password, name, surname, phone, experience, address, salary, ints[0], ints[1], ints[2], ints[3]));
                    Main.connect(pd);

                    for(int i=0; i<11; i++){
                        textFields[i].setText("");
                    }
                }
            });
            add(addButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300,30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.addDoctor.setVisible(false);
                    Main.frame.adminMenu.setVisible(true);
                    for(int i=0; i<11; i++){
                        textFields[i].setText("");
                    }
                }
            });
            add(backButton);
        }
    }
}
