package com.example.moviebooking.payment;

public class PaymentFactory {


public static Payment getPayment(String type) {

    if (type.equalsIgnoreCase("card")) {
        return new CardPayment();
    } 
    else if (type.equalsIgnoreCase("upi")) {
        return new UPIPayment();
    }

    return null;
}


}
