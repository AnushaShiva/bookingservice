package com.example.bookingservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingServiceAop.class})
@ExtendWith(SpringExtension.class)
class BookingServiceAopTest {
    @Autowired
    private BookingServiceAop bookingServiceAop;

    /**
     * Method under test: {@link BookingServiceAop#beginBookCancel()}
     */
    @Test
    void testBeginBookCancel() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        bookingServiceAop.beginBookCancel();
    }

    /**
     * Method under test: {@link BookingServiceAop#completeBookCancel()}
     */
    @Test
    void testCompleteBookCancel() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        bookingServiceAop.completeBookCancel();
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link BookingServiceAop}
     *   <li>{@link BookingServiceAop#p1()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        (new BookingServiceAop()).p1();
    }
}

