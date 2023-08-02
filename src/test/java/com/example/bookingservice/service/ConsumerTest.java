package com.example.bookingservice.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Consumer.class})
@ExtendWith(SpringExtension.class)
class ConsumerTest {
    @Autowired
    private Consumer consumer;

    /**
     * Method under test: {@link Consumer#consume(String)}
     */
    @Test
    void testConsume() throws IOException {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Consumer.logger

        consumer.consume("Not all who wander are lost");
    }
}

