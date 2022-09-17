package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPatient extends Container {
    private JLabel searchLabel;
    public JLabel resultLabel;

    private JTextField textField;

    private JButton acceptButton;
    private JButton backButton;

    public static Boolean flag;

    public SearchPatient() {
        setSize(800, 800);
        setLayout(null);

        searchLabel = new JLabel("ID:");
        searchLabel.setBounds(200, 300, 100, 25);
        add(searchLabel);

        textField = new JTextField();
        textField.setBounds(325,300,200,25);
        add(textField);

        resultLabel = new JLabel();
        resultLabel.setBounds(325, 350, 200, 25);
        resultLabel.setForeground(Color.red);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        acceptButton = new JButton("SEARCH");
        acceptButton.setBounds(200, 400, 150, 30);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(textField.getText());

                PackageData pd = new PackageData("Search","Patient", new Patient(id));
                Main.connect(pd);

                resultLabel.setText("NOT FOUND");
            }
        });
        add(acceptButton);

        backButton = new JButton("BACK");
        backButton.setBounds(375, 400, 150, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.searchPatient.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
                textField.setText("");
                resultLabel.setText("");
            }
        });
        add(backButton);
    }
}
