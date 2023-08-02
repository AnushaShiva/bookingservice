package com.example.bookingservice.service;

import com.example.bookingservice.entity.BookingDetails;
import com.example.bookingservice.exception.ResourceNotFoundException;
import com.example.bookingservice.repository.BookingRepo;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class BookingService {

    @Autowired
    BookingRepo repo;
    @Autowired
    Producer producer;

    public String bookTicket(BookingDetails details) {
        repo.save(details);

        return "BookingDetails added successfully";
    }

    public BookingDetails getById(long id) {
        Optional<BookingDetails> book = repo.findById(id);
        if (book.isEmpty()) {
            throw new NullPointerException("here id is null");
        } else {

            BookingDetails details = book.get();
            return details;
        }
    }

    public List<BookingDetails> getAllBookings() {
        return repo.findAll();

    }

    public String deleteById(long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return "deleted successfullly";
        } else {
            throw new ResourceNotFoundException("id not found");
        }

    }

    public String update(BookingDetails details, long id) {
        if (repo.findById(id).isPresent()) {
            repo.save(details);

        } else {
            throw new ResourceNotFoundException("Id not found ");
        }
        return "updated the booking details successfully";
    }

    /**
     * Get Booking Details by USERID
     *
     */
    public List<BookingDetails> getAllBookbyUser(String userid) {
        List<BookingDetails> bookings = new ArrayList<>();
        List<BookingDetails> Match = new ArrayList<>();

        repo.findAll().forEach(bookings::add);

        for (BookingDetails b : bookings) {
            if (b.getBooked_by().equals(userid)) {
                Match.add(b);

            }

        }
        return Match;
    }

    public void cancelBooking(String bookid) {
        log.info(String.format("#### -> Cancel Booking ,with Booking id:  -> %s", bookid));
        BookingDetails bookDetails = repo.findByid(bookid);
        bookDetails.setCancel_status(true);
        this.repo.save(bookDetails);
    }

    /**
     * Create Booking Details
     *
     */
    public BookingDetails addBookingDetails(BookingDetails bookingmodel) {
        BookingDetails book = this.repo.save(bookingmodel);
        this.producer.sendMessage(bookingmodel.toString());
        return book;
    }

    /**
     * Update Booking Details when user sent amount to razorpay ,it will return with
     * orderId then,
     *
     * "PayOrderId : ORDERID(String)"
     *
     */
    public void updateOrderId(String bookid, String orderid) {
        BookingDetails bookDetails = repo.findByid(bookid);
        bookDetails.setPayOrderId(orderid);
        this.repo.save(bookDetails);

    }

    /**
     * Update Booking Details when user make payment successfully through Payment
     * Gateway
     *
     * "payment_status : true"
     *
     * @throws RazorpayException t
     *
     */
    public void updatePaymentStatus(String id) throws RazorpayException {
        log.info(String.format("#### -> update Payment Status in Booking, with Booking id:  -> %s", id));
        BookingDetails bookDetails = repo.findByid(id);
        log.info("BookingId " + id);
        RazorpayClient razorpay = new RazorpayClient("rzp_test_qSq0gWHEAQOThF", "LE3jay3yFZ9WgMuy5W4AzNK7");
        try {
            com.razorpay.Order order = razorpay.Orders.fetch(bookDetails.getPayOrderId());
            log.info("getPayOrderId " + bookDetails.getPayOrderId());
            log.info(order.toString());
            log.info(order.get("status").toString());
            if (order.get("status").toString().equals("paid")) {
                bookDetails.setPayment_status(true);
                this.repo.save(bookDetails);
            }
        } catch (RazorpayException e) {
            log.info(e.getMessage());
        }

    }

}
