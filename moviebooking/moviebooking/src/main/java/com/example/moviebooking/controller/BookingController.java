package com.example.moviebooking.controller;

import com.example.moviebooking.facade.BookingFacade;
import com.example.moviebooking.payment.observer.EmailNotification;
import com.example.moviebooking.payment.observer.SMSNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {


@Autowired
private BookingFacade bookingFacade;

// 🔥 STEP 1: Handle booking (POST)
@PostMapping("/book")
public String bookMovie(@RequestParam Long movieId,
                        @RequestParam String paymentType) {

    String username = "Aryan"; // temp user

    // Add observers
    bookingFacade.addObserver(new EmailNotification());
    bookingFacade.addObserver(new SMSNotification());

    // Process booking
    bookingFacade.bookMovie(movieId, username, paymentType);

    // 🔥 Redirect (IMPORTANT)
    return "redirect:/booking-success";
}

// 🔥 STEP 2: Show success page (GET)
@GetMapping("/booking-success")
public String showBookingPage(Model model) {

    model.addAttribute("message", "🎉 Booking Successful!");

    return "Booking"; // loads Booking.html
}


}
