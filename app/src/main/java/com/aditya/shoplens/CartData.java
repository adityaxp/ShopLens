package com.aditya.shoplens;

public class CartData {

    String productID, productImage, productName, productPrice;

    public CartData(String productID, String productImage, String productName, String productPrice) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public CartData(){}

    public String getProductID() {
        return productID;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
