package com.roshan.EBookingSystem.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.roshan.EBookingSystem.Dto.BookingRequest;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingConfirmation(BookingRequest bookingRequest){
        try {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(bookingRequest.getEmail());
        msg.setSubject("Booking Confirmation");
        msg.setText("Dear User,\n\n" +
                    "Your booking has been confirmed.\n" +
                    "Vehicle ID: " + bookingRequest.getVehicleId() + "\n" +
                    "Vehicle Type: " + bookingRequest.getVehicleType() + "\n" +
                    "Booking Date: " + LocalDate.now() + "\n" +
                    "Date of Journey: " + bookingRequest.getDateOfJourney() + "\n" +
                    "From City: " + bookingRequest.getFromCity() + "\n" +
                    "To City: " + bookingRequest.getToCity() + "\n" +
                    "Total Amount: Rs. " + bookingRequest.getAmount() + "\n" +
                    "Number of Seats Booked: " + bookingRequest.getNoOfSeats() + "\n" +
                    "Payment Method: " + bookingRequest.getPaymentMethod() + "\n\n" +
                    "Thank you for choosing our service!");
        mailSender.send(msg);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
}
}
