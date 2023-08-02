package com.example.bookingservice.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class BookingServiceAop {
    private static final Logger lOG = LoggerFactory.getLogger(BookingServiceAop.class);

    @Pointcut("execution(public void com.train.booking.service.BookingService.cancelBooking()))")
    public void p1() {

    }

    //	ADVICES
    @Before("p1()")
    public void beginBookCancel() {
        log.info("Booking Cancellation Begins !!!");
        log.info("Booking Cancellation Begins !!!.......................");
    }


    @After("p1()")
    public void completeBookCancel() {
        log.info("Booking Cancellation Completed !!!");
        log.info("Booking Cancellation Completed !!!.......................");
    }



}
