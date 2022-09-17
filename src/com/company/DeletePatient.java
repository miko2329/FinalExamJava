package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePatient extends Container {
    public JLabel resultLabel;
    private JLabel deleteLabel;

    private JTextField textField;

    private JButton deleteButton;
    private JButton backButton;

    public static Boolean flag;

    public DeletePatient() {
        setSize(800, 800);
        setLayout(null);

        deleteLabel = new JLabel("ID:");
        deleteLabel.setBounds(200, 300, 100, 25);
        add(deleteLabel);

        textField = new JTextField();
        textField.setBounds(325,300,200,25);
        add(textField);

        resultLabel = new JLabel();
        resultLabel.setBounds(325, 350, 200, 25);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        deleteButton = new JButton("REMOVE");
        deleteButton.setBounds(200, 400, 150, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(textField.getText());

                PackageData pd = new PackageData("Delete", "Patient", new Patient(id));
                Main.connect(pd);
                if(flag==true){
                    resultLabel.setForeground(Color.green);
                    resultLabel.setText("SUCCESSFULLY REMOVED");
                }
                else{
                    resultLabel.setForeground(Color.red);
                    resultLabel.setText("NOT FOUND");
                }
            }
        });
        add(deleteButton);

        backButton = new JButton("BACK");
        backButton.setBounds(375, 400, 150, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.deletePatient.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
                textField.setText("");
                resultLabel.setText("");
            }
        });
        add(backButton);
    }
}
