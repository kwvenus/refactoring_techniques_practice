package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {

    void printBanner(){
        System.out.println ("*****************************\r\n"+
                "****** Customer totals ******\r\n"+
                "*****************************");
    }

    double printOwings(Iterator<Order> elements, double outstanding){
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    void printDetails(String name, double outstanding){
        System.out.println("name: " + name + "\r\namount: " + outstanding);
    }
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();
        double outstanding = 0.0;

        printBanner();
        outstanding = printOwings(elements, outstanding);
        printDetails(name,outstanding);

    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
