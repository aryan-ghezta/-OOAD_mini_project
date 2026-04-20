package com.example.moviebooking.service;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.repository.BookingRepository;
import com.example.moviebooking.payment.Payment;
import com.example.moviebooking.payment.PaymentFactory;

import com.example.moviebooking.payment.observer.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {


@Autowired
private BookingRepository bookingRepository;

public Booking createBooking(Booking booking, String paymentType) {

    // 💳 Factory Pattern
    Payment payment = PaymentFactory.getPayment(paymentType);
    if (payment != null) {
        payment.pay(200);
    }

    // 💥 Observer Pattern
    BookingNotifier notifier = new BookingNotifier();
    notifier.addObserver(new EmailNotification());
    notifier.addObserver(new SMSNotification());

    notifier.notifyObservers("Booking confirmed for movie ID: " + booking.getMovieId());

    return bookingRepository.save(booking);
}


}
