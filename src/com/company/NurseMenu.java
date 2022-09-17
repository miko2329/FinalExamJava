package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NurseMenu extends Container {
    private JLabel actionLabel;
    private JLabel idLabel;
    private JLabel textLabel;
    private JLabel resultLabel;

    private String[] actionType = {"GIVE THE INJECTION", "GIVE THE DRUG", "MEASURE THE TEMPERATURE", "MEASURE THE PRESSURE", "MAKE MY PATIENT"};

    private JComboBox actionBox;

    private JTextField idText;
    private JTextField textField;

    private JButton actionButton;
    private JButton exitButton;

    public static Long id;

    public static Boolean flag;

    public NurseMenu() {
        setSize(800, 800);
        setLayout(null);

        actionLabel = new JLabel("ACTION:");
        actionLabel.setBounds(200, 250, 100, 25);
        add(actionLabel);

        actionBox = new JComboBox(actionType);
        actionBox.setBounds(325, 250, 200, 25);
        add(actionBox);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(200, 300, 100, 25);
        add(idLabel);

        idText = new JTextField();
        idText.setBounds(325, 300, 200, 25);
        add(idText);

        textLabel = new JLabel("TEMPERATURE/PRESSURE:");
        textLabel.setBounds(200, 350, 100, 25);
        add(textLabel);

        textField = new JTextField();
        textField.setBounds(325, 350, 200, 25);
        add(textField);

        resultLabel = new JLabel();
        resultLabel.setBounds(325, 400, 200, 25);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        actionButton = new JButton("ACCEPT");
        actionButton.setBounds(200, 450, 150, 30);
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = actionBox.getSelectedIndex();
                Long idOfPatient = Long.parseLong(idText.getText());

                if(action==0) {
                    PackageData pd = new PackageData("GTI","Nurse", new Nurse(id), new Patient(idOfPatient));
                    Main.connect(pd);
                }
                else if(action==1) {
                    PackageData pd = new PackageData("GTD","Nurse", new Nurse(id), new Patient(idOfPatient));
                    Main.connect(pd);
                }
                else if(action==2) {
                    double temperature = Double.parseDouble(textField.getText());
                    PackageData pd = new PackageData("MTT","Nurse", new Nurse(id), new Patient(idOfPatient, temperature));
                    Main.connect(pd);
                }
                else if(action==3) {
                    String pressure = textField.getText();
                    PackageData pd = new PackageData("MTP","Nurse", new Nurse(id), new Patient(idOfPatient, pressure));
                    Main.connect(pd);
                }
                else if(action==4) {
                    PackageData pd = new PackageData("MMPN","Nurse", new Nurse(id), new Patient(idOfPatient));
                    Main.connect(pd);
                }

                if(flag==true){
                    resultLabel.setForeground(Color.green);
                    resultLabel.setText("SUCCESSFUL ACTION");
                }
                else{
                    resultLabel.setForeground(Color.red);
                    resultLabel.setText("NOT FOUND");
                }
            }
        });
        add(actionButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(375, 450, 150, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}
