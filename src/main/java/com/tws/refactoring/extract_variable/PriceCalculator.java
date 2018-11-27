package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    public double getPrice_BasePriceMinusDiscountAddShippingCost(int quantity, int itemPrice) {
        double price = (getBasicPrice(quantity, itemPrice) - getDiscount(quantity, itemPrice) + getShippingCost(quantity, itemPrice));
        return price;
    }

    double getBasicPrice(int quantity, int itemPrice){
        double basicPrice = quantity * itemPrice;
        return basicPrice;
    }

    double getDiscount(int quantity, int itemPrice){
        double discount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        return discount;
    }

    double getShippingCost(int quantity, int itemPrice){
        double shippingCost = Math.min(quantity * itemPrice * 0.1, 100.0);
        return shippingCost;
    }
}
