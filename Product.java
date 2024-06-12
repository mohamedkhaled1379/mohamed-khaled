
package com.mycompany.inventory;


public class Product  {
    private int Quantity;
    private double price;
    private String name;
    private String supplier;

    public Product(int Quantity, double price, String name, String supplier) {
        this.Quantity = Quantity;
        this.price = price;
        this.name = name;
        this.supplier = supplier;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" + "Quantity=" + Quantity + ", price=" + price + ", name=" + name + ", supplier=" + supplier + '}';
    }
    
}
