package com.roshan.EBookingSystem.Controller;

import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.EBookingSystem.Dto.BookingRequest;
import com.roshan.EBookingSystem.Entity.Booking;
import com.roshan.EBookingSystem.Service.BookingService;
import com.roshan.EBookingSystem.Service.EmailService;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    EmailService emailService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody BookingRequest bookingRequest) {
        try {
            bookingService.bookTicket(bookingRequest);
            // emailService.sendBookingConfirmation(bookingRequest);
            return "Booking successful!";
        } catch (Exception e) {
            return "Booking failed: " + e.getMessage();
        }
    }

    @GetMapping("/download/{bookingId}")
    public ResponseEntity<byte[]> downloadTicket(@PathVariable Integer bookingId) {
        byte[] pdfBytes = bookingService.generateTicketPdf(bookingId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ticket-" + bookingId + ".pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @PostMapping("/booking/history/{email}")
    public ResponseEntity<ArrayList<Booking>> getBookingByEmail(@PathVariable String email,
            @RequestBody(required = false) String dateOfJourney) {
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ArrayList<Booking> bookings = new ArrayList<>();
        if (dateOfJourney != null && !dateOfJourney.isEmpty()) {
            bookings = bookingService.getBookingByEmailAndDateOfJourney(email, dateOfJourney);
        } else {
            bookings = bookingService.getBookingByEmail(email);
        }
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/booking/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}