package com.example.bookingservice.controller;

import com.example.bookingservice.entity.BookingDetails;
import com.example.bookingservice.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("bookingdetails")
@Slf4j
public class BookController {
    @Autowired
    BookingService service;

    @PostMapping("/")
    public String bookTicket(@RequestBody BookingDetails details) {
        log.info("addong bookingDetails");
        return service.bookTicket(details);

    }

    @GetMapping("/get/{id}")
    public BookingDetails getByID(@PathVariable long id) {
        log.info("getting BookingDetails by id");
        return service.getById(id);
    }



    @GetMapping("/getAll")
    public List<BookingDetails> getAll() {
        log.info("getting all Booking details from db");
        return service.getAllBookings();

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public String updateBookingInfo(@RequestBody BookingDetails details, @PathVariable long id) {
        log.info("updating bookingdetails based upon id ");
        return service.update(details, id);
    }

    /**
     * Update Booking Details when user sent amount to razorpay ,it will return with
     * orderId then,
     *
     * "PayOrderId : ORDERID(String)"
     *
     */
    @PutMapping("/updateorderid/{bookingId}/{orderId}")
    public void UpdateOrderID(@PathVariable("bookingId") String bookid, @PathVariable("orderId") String orderid) {
        service.updateOrderId(bookid, orderid);

    }

    /**
     * Get Booking Details by USERID
     *
     */
    @GetMapping("/getbookbyuser/{userId}")
    public List<BookingDetails> getAllBookDetailsbyUser(@PathVariable("userId") String userid) {

        return service.getAllBookbyUser(userid);

    }

    /**
     * Cancel Booking Details cancel_status : true
     *
     */
    @PutMapping("/cancelbooking/{bookingId}")
    public void CancelBooking(@PathVariable("bookingId") String bookid) {

        service.cancelBooking(bookid);
    }

}
