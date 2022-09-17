package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Container {
    private JLabel personLabel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    public JLabel resultLabel;

    private JTextField idText;
    private JTextField passwordText;

    private JComboBox personBox;

    private String[] personType = {"ADMIN", "NURSE", "DOCTOR"};

    private JButton loginButton;
    private JButton exitButton;

    public static Boolean flag;

    public Login(){
        setSize(800, 800);
        setLayout(null);

        personLabel = new JLabel("PERSON:");
        personLabel.setBounds(100, 200, 200, 25);
        add(personLabel);

        personBox = new JComboBox(personType);
        personBox.setBounds(350, 200, 300, 25);
        add(personBox);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(100, 250, 200, 25);
        add(idLabel);

        idText = new JTextField();
        idText.setBounds(350, 250, 300, 25);
        add(idText);

        passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(100, 300, 200, 25);
        add(passwordLabel);

        passwordText = new JTextField();
        passwordText.setBounds(350, 300, 300, 25);
        add(passwordText);

        resultLabel = new JLabel();
        resultLabel.setBounds(350, 350, 300, 25);
        resultLabel.setForeground(Color.red);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(100, 400, 250, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int person = personBox.getSelectedIndex();
                Long id = Long.parseLong(idText.getText());
                String password = passwordText.getText();

                if(person==0){
                    PackageData pd = new PackageData("Login","Admin", new Admin(id, password));
                    Main.connect(pd);
                    if(flag==true){
                        Main.frame.login.setVisible(false);
                        Main.frame.adminMenu.setVisible(true);
                    }
                }

                else if(person==1){
                    PackageData pd = new PackageData("Login","Nurse", new Nurse(id, password));
                    Main.connect(pd);
                    if(flag==true){
                        NurseMenu.id=id;
                        Main.frame.login.setVisible(false);
                        Main.frame.nurseMenu.setVisible(true);
                    }
                }

                else if(person==2){
                    PackageData pd = new PackageData("Login","Doctor", new Doctor(id, password));
                    Main.connect(pd);
                    if(flag==true){
                        DoctorMenu.id=id;
                        Main.frame.login.setVisible(false);
                        Main.frame.doctorMenu.setVisible(true);
                    }
                }

                passwordText.setText("");
                resultLabel.setText("WRONG ID OR PASSWORD");
            }
        });
        add(loginButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(400, 400, 250, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}
