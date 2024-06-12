package com.mycompany.dentalclinic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DentalClinic extends JFrame {
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public DentalClinic() {
        // Sample doctors
        doctors.add(new Doctor("Dr. Mohamed", "Dentist"));
        doctors.add(new Doctor("Dr. Awny", "Orthodontist"));
        doctors.add(new Doctor("Dr. Ahmed", "Periodontist"));
        doctors.add(new Doctor("Dr. Seif", "Endodontist"));

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        p1.add(registerButton);
        p1.add(loginButton);
        this.add(p1);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerWindow();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginWindow();
            }
        });
    }

    public static void main(String[] args) {
        DentalClinic d = new DentalClinic();
        d.setVisible(true);
    }

    private void registerWindow() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setLayout(new GridLayout(5, 1));
        registerFrame.setSize(300, 400);
        registerFrame.setLocationRelativeTo(null);

        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(110, 30));
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(110, 30));
        JTextField mobileField = new JTextField();
        mobileField.setPreferredSize(new Dimension(110, 30));

        JLabel nameLabel = new JLabel("Name");
        JLabel emailLabel = new JLabel("Email");
        JLabel mobileLabel = new JLabel("Mobile");

        JButton cancelButton = new JButton("Cancel");
        JButton confirmButton = new JButton("Confirm");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        p1.add(nameLabel);
        p1.add(nameField);
        p2.add(emailLabel);
        p2.add(emailField);
        p3.add(mobileLabel);
        p3.add(mobileField);
        p4.add(cancelButton);
        p4.add(confirmButton);

        registerFrame.add(p1);
        registerFrame.add(p2);
        registerFrame.add(p3);
        registerFrame.add(p4);
        registerFrame.setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.dispose();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String mobile = mobileField.getText();
                patients.add(new Patient(name, email, mobile));
                JOptionPane.showMessageDialog(registerFrame, "Patient registered successfully!");
                registerFrame.dispose();
            }
        });
    }

    private void loginWindow() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setLayout(new GridLayout(3, 1));
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(110, 30));

        JLabel emailLabel = new JLabel("Email");

        JButton cancelButton = new JButton("Cancel");
        JButton loginButton = new JButton("Login");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.add(emailLabel);
        p1.add(emailField);
        p2.add(cancelButton);
        p2.add(loginButton);

        loginFrame.add(p1);
        loginFrame.add(p2);
        loginFrame.setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                boolean found = false;
                for (Patient patient : patients) {
                    if (patient.getEmail().equals(email)) {
                        found = true;
                        loginFrame.dispose();
                        showPatientDetails(patient);
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(loginFrame, "Patient not found.");
                }
            }
        });
    }

    private void showPatientDetails(Patient patient) {
        JFrame detailsFrame = new JFrame("Patient Details");
        detailsFrame.setLayout(new GridLayout(7, 1));
        detailsFrame.setSize(300, 400);
        detailsFrame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name: " + patient.getName());
        JLabel emailLabel = new JLabel("Email: " + patient.getEmail());
        JLabel mobileLabel = new JLabel("Mobile: " + patient.getMobile());

        JButton chooseDoctorButton = new JButton("Choose Doctor");
        JButton chooseDateTimeButton = new JButton("Choose Date and Time");
        JButton checkoutButton = new JButton("Checkout");
        JButton logoutButton = new JButton("Logout");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p1.add(nameLabel);
        p2.add(emailLabel);
        p3.add(mobileLabel);
        p4.add(chooseDoctorButton);
        p4.add(chooseDateTimeButton);
        p5.add(logoutButton);
        p6.add(checkoutButton);

        detailsFrame.add(p1);
        detailsFrame.add(p2);
        detailsFrame.add(p3);
        detailsFrame.add(p4);
        detailsFrame.add(p5);
        detailsFrame.add(p6);
        detailsFrame.setVisible(true);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsFrame.dispose();
            }
        });

        chooseDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseDoctor(patient, detailsFrame);
            }
        });

        chooseDateTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseDateTime(patient, detailsFrame);
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Cash", "Visa"};
                int choice = JOptionPane.showOptionDialog(detailsFrame,
                        "Choose payment method:", "Checkout",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (choice == JOptionPane.CLOSED_OPTION) {
                    // Do nothing if the user closes the dialog
                } else if (options[choice].equals("Cash")) {
                    performCashCheckout(detailsFrame);
                } else if (options[choice].equals("Visa")) {
                    showCreditCardFrame(detailsFrame);
                }
            }
        });
    }

    private void chooseDoctor(Patient patient, JFrame detailsFrame) {
        JFrame doctorFrame = new JFrame("Choose Doctor");
        doctorFrame.setLayout(new GridLayout(doctors.size() + 2, 1));
        doctorFrame.setSize(300, 200);
        doctorFrame.setLocationRelativeTo(null);

        ButtonGroup doctorGroup = new ButtonGroup();
        JRadioButton[] doctorButtons = new JRadioButton[doctors.size()];
        JPanel p = new JPanel();

        for (int i = 0; i < doctors.size(); i++) {
            doctorButtons[i] = new JRadioButton(doctors.get(i).getName());
            doctorGroup.add(doctorButtons[i]);
            p.add(doctorButtons[i]);
        }

        JButton cancelButton = new JButton("Cancel");
        JButton confirmButton = new JButton("Confirm");

        p.add(cancelButton);
        p.add(confirmButton);

        doctorFrame.add(p);
        doctorFrame.setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorFrame.dispose();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JRadioButton button : doctorButtons) {
                    if (button.isSelected()) {
                        JOptionPane.showMessageDialog(doctorFrame, "Doctor " + button.getText() + " chosen!");
                        doctorFrame.dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(doctorFrame, "Please select a doctor.");
            }
        });
    }

    private void chooseDateTime(Patient patient, JFrame detailsFrame) {
        JFrame dateTimeFrame = new JFrame("Choose Date and Time");
        dateTimeFrame.setLayout(new GridLayout(4, 1));
        dateTimeFrame.setSize(300, 200);
        dateTimeFrame.setLocationRelativeTo(null);

        JTextField dateField = new JTextField("YYYY-MM-DD");
        JTextField timeField = new JTextField("HH:MM");

        JButton cancelButton = new JButton("Cancel");
        JButton confirmButton = new JButton("Confirm");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.add(new JLabel("Date:"));
        p1.add(dateField);
        p2.add(new JLabel("Time:"));
        p2.add(timeField);

        dateTimeFrame.add(p1);
        dateTimeFrame.add(p2);
        dateTimeFrame.add(cancelButton);
        dateTimeFrame.add(confirmButton);
        dateTimeFrame.setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateTimeFrame.dispose();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String time = timeField.getText();
                JOptionPane.showMessageDialog(dateTimeFrame, "Appointment set for " + date + " at " + time);
                dateTimeFrame.dispose();
            }
        });
    }

    private void performCashCheckout(JFrame detailsFrame) {
        int confirm = JOptionPane.showConfirmDialog(detailsFrame, "Are you sure you want to checkout?");
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(detailsFrame, "Patient checked out successfully!");
            detailsFrame.dispose();
        }
    }

    private void showCreditCardFrame(JFrame detailsFrame) {
        JFrame creditCardFrame = new JFrame("Enter Credit Card Information");
        creditCardFrame.setLayout(new GridLayout(4, 2));
        creditCardFrame.setSize(300, 200);
        creditCardFrame.setLocationRelativeTo(detailsFrame);

        JTextField cardNumberField = new JTextField();
        
        JTextField cvvField = new JTextField();

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberField.setPreferredSize(new Dimension(200, 30));
        JLabel cvvLabel = new JLabel("CVV:");
         cvvField.setPreferredSize(new Dimension(200, 30));

        JButton cancelButton = new JButton("Cancel");
        JButton confirmButton = new JButton("Confirm");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.add(cardNumberLabel);
        p1.add(cardNumberField);
        p2.add(cvvLabel);
        p2.add(cvvField);

        creditCardFrame.add(p1);
        creditCardFrame.add(p2);
        creditCardFrame.add(cancelButton);
        creditCardFrame.add(confirmButton);
        creditCardFrame.setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditCardFrame.dispose();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                String cvv = cvvField.getText();
                // Validate credit card information here (e.g., check for valid card number and CVV)
                JOptionPane.showMessageDialog(creditCardFrame, "Payment confirmed! Patient checked out successfully!");
                creditCardFrame.dispose();
                detailsFrame.dispose();
            }
        });
    }
}
