package com.example.moviebooking.payment.observer;

public class SMSNotification implements Observer {


@Override
public void update(String message) {
    System.out.println("📱 SMS sent: " + message);
}


}
