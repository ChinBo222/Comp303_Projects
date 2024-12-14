package org.spring;

public class PhoneCatalog {
    private Products product;
    public PhoneCatalog(Products product){
        this.product = product;
    }
    public void showProduct(){
        product.printMessage();
    }
}
