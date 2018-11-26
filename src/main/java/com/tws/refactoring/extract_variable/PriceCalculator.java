package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    public double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        return (getBasicPrice(quantity, itemPrice) - getDiscount(quantity, itemPrice) + getShippingCost(quantity, itemPrice));
    }

    double getBasicPrice(int quantity, int itemPrice){
        return quantity * itemPrice;
    }

    double getDiscount(int quantity, int itemPrice){
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }

    double getShippingCost(int quantity, int itemPrice){
        return Math.min(quantity * itemPrice * 0.1, 100.0);
    }
}
