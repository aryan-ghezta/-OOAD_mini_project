package com.example.moviebooking.facade;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.payment.Payment;
import com.example.moviebooking.payment.PaymentFactory;
import com.example.moviebooking.repository.BookingRepository;
import com.example.moviebooking.payment.observer.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingFacade {

    @Autowired
    private BookingRepository bookingRepository;

    // Observers (Email/SMS simulation)
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void bookMovie(Long movieId, String username, String paymentType) {

        // 1️⃣ Create booking
        Booking booking = new Booking();
        booking.setMovieId(movieId);
        booking.setUsername(username);

        bookingRepository.save(booking);

        // 2️⃣ Payment using Factory Pattern
        Payment payment = PaymentFactory.getPayment(paymentType);
        payment.pay(200); // fixed amount for demo

        // 3️⃣ Notify user (Observer Pattern)
        notifyObservers("Booking confirmed for user: " + username);
    }
}