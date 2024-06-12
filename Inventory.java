package com.mycompany.inventory;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory extends JFrame {
    private InventoryManage inventoryManage;

    public Inventory() {
        inventoryManage = new InventoryManage();

        JButton add = new JButton("Add");
        JButton delete = new JButton("Delete");
        JButton update = new JButton("Update");

        setSize(300, 400);
        setVisible(true);
        JPanel p1 = new JPanel();
        p1.add(add);
        p1.add(delete);
        p1.add(update);
        this.add(p1);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWindow();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteWindow();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWindow();
            }
        });
    }

    public static void main(String[] args) {
        Inventory I = new Inventory();
        I.setVisible(true);
        I.setSize(300, 400);
    }

    private void addWindow() {
        JFrame addframe = new JFrame("ADD");
        addframe.setLayout(new GridLayout(5, 1));
        addframe.setSize(300, 400);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        JTextField Nfield = new JTextField();
        Nfield.setPreferredSize(new Dimension(110, 30));
        JTextField sfield = new JTextField();
        sfield.setPreferredSize(new Dimension(110, 30));
        JTextField pfield = new JTextField();
        pfield.setPreferredSize(new Dimension(110, 30));
        JTextField qfield = new JTextField();
        qfield.setPreferredSize(new Dimension(110, 30));

        JLabel Name = new JLabel("Name");
        JLabel supplier = new JLabel("Supplier");
        JLabel price = new JLabel("Price");
        JLabel quantity = new JLabel("Quantity");

        JButton Cancel = new JButton("Cancel");
        JButton Confirm = new JButton("Confirm");

        p1.add(Name);
        p1.add(Nfield);
        p2.add(price);
        p2.add(pfield);
        p3.add(supplier);
        p3.add(sfield);
        p4.add(quantity);
        p4.add(qfield);
        p5.add(Cancel);
        p5.add(Confirm);

        addframe.add(p1);
        addframe.add(p2);
        addframe.add(p3);
        addframe.add(p4);
        addframe.add(p5);
        addframe.setVisible(true);

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addframe.dispose();
            }
        });

        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Nfield.getText();
                String supplier = sfield.getText();
                double price = Double.parseDouble(pfield.getText());
                int quantity = Integer.parseInt(qfield.getText());

                inventoryManage.addProduct(new Product(quantity, price, name, supplier));
                addframe.dispose();
            }
        });
    }

   private void deleteWindow() {
    JFrame deleteFrame = new JFrame("Delete");
    deleteFrame.setLayout(new GridLayout(3, 1));
    deleteFrame.setSize(300, 200);

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JComboBox<String> productComboBox = new JComboBox<>();
    for (int i = 0; i < inventoryManage.productCount; i++) {
        productComboBox.addItem(inventoryManage.products[i].getName());
    }
    productComboBox.setPreferredSize(new Dimension(150, 30));

    JButton cancelButton = new JButton("Cancel");
    JButton confirmButton = new JButton("Confirm");
    JButton end = new JButton("End");
    p1.add(new JLabel("Select Product"));
    p1.add(productComboBox);
    p2.add(cancelButton);
    p2.add(confirmButton);
    p2.add(end);

    deleteFrame.add(p1);
    deleteFrame.add(p2);
    deleteFrame.setVisible(true);

     end.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
     
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteFrame.dispose();
        }
    });

    confirmButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedProductName = (String) productComboBox.getSelectedItem();
            inventoryManage.deleteProduct(selectedProductName);
            deleteFrame.dispose();
        }
    });
}


  public void updateWindow() {
    JFrame updateFrame = new JFrame("Update");
    updateFrame.setLayout(new GridLayout(6, 1));
    updateFrame.setSize(300, 400);

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();

    JComboBox<String> productComboBox = new JComboBox<>();
    for (int i = 0; i < inventoryManage.productCount; i++) {
        productComboBox.addItem(inventoryManage.products[i].getName());
    }
    productComboBox.setPreferredSize(new Dimension(150, 30));

    JTextField nameField = new JTextField();
    nameField.setPreferredSize(new Dimension(110, 30));
    JTextField supplierField = new JTextField();
    supplierField.setPreferredSize(new Dimension(110, 30));
    JTextField priceField = new JTextField();
    priceField.setPreferredSize(new Dimension(110, 30));
    JTextField quantityField = new JTextField();
    quantityField.setPreferredSize(new Dimension(110, 30));

    JLabel nameLabel = new JLabel("Name");
    JLabel supplierLabel = new JLabel("Supplier");
    JLabel priceLabel = new JLabel("Price");
    JLabel quantityLabel = new JLabel("Quantity");

    JButton cancelButton = new JButton("Cancel");
    JButton confirmButton = new JButton("Confirm");
    JButton end = new JButton("End");
    p1.add(new JLabel("Select Product"));
    p1.add(productComboBox);
    p2.add(nameLabel);
    p2.add(nameField);
    p3.add(priceLabel);
    p3.add(priceField);
    p4.add(supplierLabel);
    p4.add(supplierField);
    p5.add(quantityLabel);
    p5.add(quantityField);
    p6.add(cancelButton);
    p6.add(confirmButton);
    p6.add(end);

    updateFrame.add(p1);
    updateFrame.add(p2);
    updateFrame.add(p3);
    updateFrame.add(p4);
    updateFrame.add(p5);
    updateFrame.add(p6);
    updateFrame.setVisible(true);

    productComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedProductName = (String) productComboBox.getSelectedItem();
            Product selectedProduct = inventoryManage.getProduct(selectedProductName);

            if (selectedProduct != null) {
                nameField.setText(selectedProduct.getName());
                supplierField.setText(selectedProduct.getSupplier());
                priceField.setText(String.valueOf(selectedProduct.getPrice()));
                quantityField.setText(String.valueOf(selectedProduct.getQuantity()));
            }
        }
    });

    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateFrame.dispose();
        }
    });

    confirmButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedProductName = (String) productComboBox.getSelectedItem();
            String name = nameField.getText();
            String supplier = supplierField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            inventoryManage.updateProduct(selectedProductName, quantity, price, supplier);
            updateFrame.dispose();
        }
    });
    
     end.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
}

}
