package com.example.moviebooking.payment.observer;

public class EmailNotification implements Observer {


@Override
public void update(String message) {
    System.out.println("📧 Email sent: " + message);
}


}
