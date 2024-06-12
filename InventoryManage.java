
package com.mycompany.inventory;


public class InventoryManage extends TrackProduct {

    public InventoryManage() {
        super();
    }

    public Product[] categorizeByType(String productType) {
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(productType)) {
                count++;
            }
        }

        Product[] categorizedProducts = new Product[count];
        int index = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(productType)) {
                categorizedProducts[index++] = products[i];
            }
        }

        return categorizedProducts;
    }

    public Product[] categorizeBySupplier(String supplierName) {
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getSupplier().equalsIgnoreCase(supplierName)) {
                count++;
            }
        }

        Product[] categorizedProducts = new Product[count];
        int index = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getSupplier().equalsIgnoreCase(supplierName)) {
                categorizedProducts[index++] = products[i];
            }
        }

        return categorizedProducts;
    }

    public Product[] searchProduct(String searchTerm) {
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                count++;
            }
        }

        Product[] filteredProducts = new Product[count];
        int index = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                filteredProducts[index++] = products[i];
            }
        }

        return filteredProducts;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder("Inventory Report");
        for (int i = 0; i < productCount; i++) {
            report.append(products[i].toString()).append("");
        }
        return report.toString();
        
    }
}
    

