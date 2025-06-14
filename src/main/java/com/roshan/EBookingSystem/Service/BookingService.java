package com.roshan.EBookingSystem.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.roshan.EBookingSystem.Dto.BookingRequest;
import com.roshan.EBookingSystem.Entity.Booking;
import com.roshan.EBookingSystem.Entity.Bus;
import com.roshan.EBookingSystem.Entity.Flight;
import com.roshan.EBookingSystem.Entity.Train;
import com.roshan.EBookingSystem.Entity.Vehicle;
import com.roshan.EBookingSystem.Repository.BookingRepo;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    FlightService flightService;
    @Autowired
    TrainService trainService;
    @Autowired
    BusService busService;

    public Booking bookTicket(BookingRequest request) {

        Vehicle vehicle = null;
        
        switch (request.getVehicleType().toUpperCase()) {
            case "FLIGHT":
                vehicle = flightService.getDetails(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Flight not found"));
                break;
            case "TRAIN":
                vehicle = trainService.getDetails(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Train not found"));
                break;
            case "BUS":
                vehicle = busService.getDetails(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Bus not found"));
                break;
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + request.getVehicleType());
        };

        Booking booking = new Booking();

        booking.setUserId(request.getUserId());
        booking.setBookingDate(LocalDate.now().toString());
        booking.setDateOfJourney(request.getDateOfJourney());
        booking.setFromCity(request.getFromCity());
        booking.setToCity(request.getToCity());
        booking.setVehicleId(vehicle.getId());
        booking.setTotalAmount(request.getAmount());
        booking.setStatus("CONFIRMED");
        booking.setNumberOfSeatsBooked(request.getNoOfSeats());
        booking.setPaymentMethod(request.getPaymentMethod());
        booking.setEmail(request.getEmail());
        if(vehicle instanceof Bus){
            booking.setVehicleType("BUS");
        }
        else if(vehicle instanceof Train){
            booking.setVehicleType("TRAIN");
        }
        else if(vehicle instanceof Flight){
            booking.setVehicleType("FLIGHT");
        }

        Booking saved = bookingRepo.save(booking);

        return saved;
    }

    public byte[] generateTicketPdf(Integer bookingId) {
        Booking booking = bookingRepo.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, out);
            doc.open();

            doc.add(new Paragraph("Booking Details"));
            doc.add(new Paragraph("Booking ID: " + booking.getBookingId()));
            doc.add(new Paragraph("User ID: " + booking.getUserId()));
            doc.add(new Paragraph("From City: " + booking.getFromCity()));
            doc.add(new Paragraph("To City: " + booking.getToCity()));
            doc.add(new Paragraph("Date of Journey: " + booking.getDateOfJourney()));
            doc.add(new Paragraph("Price: " + booking.getTotalAmount()));
            doc.add(new Paragraph("Vehicle Type: " + booking.getVehicleType()));

            doc.close();
        }
        catch (Exception e) {
            throw new RuntimeException("Error generating PDF: " + e.getMessage(), e);
        }
        return out.toByteArray();
    }

    public ArrayList<Booking> getBookingByEmail(String email) {
        return bookingRepo.findByEmail(email);
    }
    public ArrayList<Booking> getBookingByEmailAndDateOfJourney(String email, String dateOfJourney) {
        return bookingRepo.findByEmailAndDateOfJourney(email, dateOfJourney);
    }
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }
}
