package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPersonal {

    public static class ViewAdmin extends Container {
        public static JTextArea list;

        private JButton viewButton;
        private JButton backButton;

        public ViewAdmin(){
            setSize(800, 800);
            setLayout(null);

            list = new JTextArea();
            list.setBounds(50, 75, 650, 525);
            add(list);

            viewButton = new JButton("VIEW");
            viewButton.setBounds(50, 700, 300, 30);
            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PackageData pd = new PackageData("List", "Admin");
                    Main.connect(pd);
                }
            });
            add(viewButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300, 30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.viewAdmin.setVisible(false);
                    Main.frame.adminMenu.setVisible(true);
                }
            });
            add(backButton);
        }
    }

    public static class ViewNurse extends Container {
        public static JTextArea list;

        private JButton viewButton;
        private JButton backButton;

        public ViewNurse(){
            setSize(800, 800);
            setLayout(null);

            list = new JTextArea();
            list.setBounds(50, 75, 650, 525);
            add(list);

            viewButton = new JButton("VIEW");
            viewButton.setBounds(50, 700, 300, 30);
            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PackageData pd = new PackageData("List", "Nurse");
                    Main.connect(pd);
                }
            });
            add(viewButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300, 30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.viewNurse.setVisible(false);
                    Main.frame.adminMenu.setVisible(true);
                }
            });
            add(backButton);
        }
    }

    public static class ViewDoctor extends Container {
        public static JTextArea list;

        private JButton viewButton;
        private JButton backButton;

        public ViewDoctor(){
            setSize(800, 800);
            setLayout(null);

            list = new JTextArea();
            list.setBounds(50, 75, 650, 525);
            add(list);

            viewButton = new JButton("VIEW");
            viewButton.setBounds(50, 700, 300, 30);
            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PackageData pd = new PackageData("List", "Doctor");
                    Main.connect(pd);
                }
            });
            add(viewButton);

            backButton = new JButton("BACK");
            backButton.setBounds(400, 700, 300, 30);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.viewDoctor.setVisible(false);
                    Main.frame.adminMenu.setVisible(true);
                }
            });
            add(backButton);
        }
    }
}
