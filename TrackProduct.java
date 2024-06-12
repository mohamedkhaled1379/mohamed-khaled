
package com.mycompany.inventory;


public class TrackProduct {

    public Product[] products;
    public int productCount;

    public TrackProduct() {
        products = new Product[100];
        productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount >= products.length) {
           
            resizeProductArray();
        }
        products[productCount++] = product;
    }

    public Product updateProduct(String name, Integer quantity, Double price, String supplier) {
        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            if (product.getName().equalsIgnoreCase(name)) {
                if (quantity != null) {
                    product.setQuantity(quantity);
                }
                if (price != null) {
                    product.setPrice(price);
                }
                if (supplier != null) {
                    product.setSupplier(supplier);
                }
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                products[i] = products[productCount - 1];
                products[productCount - 1] = null; 
                productCount--;
                return;
            }
        }
    }

    public Product getProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return products[i];
            }
        }
        return null;
    }

    private void resizeProductArray() {
        Product[] newProducts = new Product[products.length * 2]; // double the size
        System.arraycopy(products, 0, newProducts, 0, products.length);
        products = newProducts;
        
        
    }

    @Override
    public String toString() {
        return "TrackProduct{" + "products=" + products + ", productCount=" + productCount + '}';
    }
}
    

