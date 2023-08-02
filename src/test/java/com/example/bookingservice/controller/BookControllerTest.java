package com.example.bookingservice.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.bookingservice.entity.BookingDetails;
import com.example.bookingservice.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookingService bookingService;

    /**
     * Method under test: {@link BookController#bookTicket(BookingDetails)}
     */
    @Test
    void testBookTicket() throws Exception {
        when(bookingService.bookTicket(Mockito.<BookingDetails>any())).thenReturn("Book Ticket");

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setArrival("Arrival");
        bookingDetails.setArrival_time("Arrival time");
        bookingDetails.setBooked_by("Booked by");
        bookingDetails.setCancel_status(true);
        bookingDetails.setDepart("Depart");
        bookingDetails.setDepart_time("Depart time");
        bookingDetails.setId(1L);
        bookingDetails.setPayOrderId("42");
        bookingDetails.setPayment_status(true);
        bookingDetails.setQuantity(1);
        bookingDetails.setQuota("Quota");
        bookingDetails.setTotalfare(10.0d);
        bookingDetails.setTrain_id("Train id");
        String content = (new ObjectMapper()).writeValueAsString(bookingDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bookingdetails/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Book Ticket"));
    }

    /**
     * Method under test: {@link BookController#delete(long)}
     */
    @Test
    void testDelete() throws Exception {
        when(bookingService.deleteById(anyLong())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bookingdetails/delete/{id}", 1L);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link BookController#CancelBooking(String)}
     */
    @Test
    void testCancelBooking() throws Exception {
        doNothing().when(bookingService).cancelBooking(Mockito.<String>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/bookingdetails/cancelbooking/{bookingId}", "42");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#CancelBooking(String)}
     */
    @Test
    void testCancelBooking2() throws Exception {
        doNothing().when(bookingService).cancelBooking(Mockito.<String>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/bookingdetails/cancelbooking/{bookingId}", "42");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#getAll()}
     */
    @Test
    void testGetAll() throws Exception {
        when(bookingService.getAllBookings()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bookingdetails/getAll");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#getAll()}
     */
    @Test
    void testGetAll2() throws Exception {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setArrival("?");
        bookingDetails.setArrival_time("?");
        bookingDetails.setBooked_by("?");
        bookingDetails.setCancel_status(true);
        bookingDetails.setDepart("?");
        bookingDetails.setDepart_time("?");
        bookingDetails.setId(1L);
        bookingDetails.setPayOrderId("42");
        bookingDetails.setPayment_status(true);
        bookingDetails.setQuantity(1);
        bookingDetails.setQuota("?");
        bookingDetails.setTotalfare(10.0d);
        bookingDetails.setTrain_id("?");

        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(bookingDetails);
        when(bookingService.getAllBookings()).thenReturn(bookingDetailsList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bookingdetails/getAll");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"train_id\":\"?\",\"quantity\":1,\"totalfare\":10.0,\"quota\":\"?\",\"booked_by\":\"?\",\"payment_status\""
                                        + ":true,\"cancel_status\":true,\"payOrderId\":\"42\",\"depart\":\"?\",\"arrival\":\"?\",\"depart_time\":\"?\",\"arrival"
                                        + "_time\":\"?\"}]"));
    }

    /**
     * Method under test: {@link BookController#getAllBookDetailsbyUser(String)}
     */
    @Test
    void testGetAllBookDetailsbyUser() throws Exception {
        when(bookingService.getAllBookbyUser(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bookingdetails/getbookbyuser/{userId}", "42");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#getAllBookDetailsbyUser(String)}
     */
    @Test
    void testGetAllBookDetailsbyUser2() throws Exception {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setArrival("?");
        bookingDetails.setArrival_time("?");
        bookingDetails.setBooked_by("?");
        bookingDetails.setCancel_status(true);
        bookingDetails.setDepart("?");
        bookingDetails.setDepart_time("?");
        bookingDetails.setId(1L);
        bookingDetails.setPayOrderId("42");
        bookingDetails.setPayment_status(true);
        bookingDetails.setQuantity(1);
        bookingDetails.setQuota("?");
        bookingDetails.setTotalfare(10.0d);
        bookingDetails.setTrain_id("?");

        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(bookingDetails);
        when(bookingService.getAllBookbyUser(Mockito.<String>any())).thenReturn(bookingDetailsList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bookingdetails/getbookbyuser/{userId}", "42");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"train_id\":\"?\",\"quantity\":1,\"totalfare\":10.0,\"quota\":\"?\",\"booked_by\":\"?\",\"payment_status\""
                                        + ":true,\"cancel_status\":true,\"payOrderId\":\"42\",\"depart\":\"?\",\"arrival\":\"?\",\"depart_time\":\"?\",\"arrival"
                                        + "_time\":\"?\"}]"));
    }

    /**
     * Method under test: {@link BookController#getByID(long)}
     */
    @Test
    void testGetByID() throws Exception {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setArrival("Arrival");
        bookingDetails.setArrival_time("Arrival time");
        bookingDetails.setBooked_by("Booked by");
        bookingDetails.setCancel_status(true);
        bookingDetails.setDepart("Depart");
        bookingDetails.setDepart_time("Depart time");
        bookingDetails.setId(1L);
        bookingDetails.setPayOrderId("42");
        bookingDetails.setPayment_status(true);
        bookingDetails.setQuantity(1);
        bookingDetails.setQuota("Quota");
        bookingDetails.setTotalfare(10.0d);
        bookingDetails.setTrain_id("Train id");
        when(bookingService.getById(anyLong())).thenReturn(bookingDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bookingdetails/get/{id}", 1L);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"train_id\":\"Train id\",\"quantity\":1,\"totalfare\":10.0,\"quota\":\"Quota\",\"booked_by\":\"Booked"
                                        + " by\",\"payment_status\":true,\"cancel_status\":true,\"payOrderId\":\"42\",\"depart\":\"Depart\",\"arrival\":\"Arrival"
                                        + "\",\"depart_time\":\"Depart time\",\"arrival_time\":\"Arrival time\"}"));
    }

    /**
     * Method under test: {@link BookController#updateBookingInfo(BookingDetails, long)}
     */
    @Test
    void testUpdateBookingInfo() throws Exception {
        when(bookingService.update(Mockito.<BookingDetails>any(), anyLong())).thenReturn("2020-03-01");

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setArrival("Arrival");
        bookingDetails.setArrival_time("Arrival time");
        bookingDetails.setBooked_by("Booked by");
        bookingDetails.setCancel_status(true);
        bookingDetails.setDepart("Depart");
        bookingDetails.setDepart_time("Depart time");
        bookingDetails.setId(1L);
        bookingDetails.setPayOrderId("42");
        bookingDetails.setPayment_status(true);
        bookingDetails.setQuantity(1);
        bookingDetails.setQuota("Quota");
        bookingDetails.setTotalfare(10.0d);
        bookingDetails.setTrain_id("Train id");
        String content = (new ObjectMapper()).writeValueAsString(bookingDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/bookingdetails/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

    /**
     * Method under test: {@link BookController#UpdateOrderID(String, String)}
     */
    @Test
    void testUpdateOrderID() throws Exception {
        doNothing().when(bookingService).updateOrderId(Mockito.<String>any(), Mockito.<String>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/bookingdetails/updateorderid/{bookingId}/{orderId}", "42", "42");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#UpdateOrderID(String, String)}
     */
    @Test
    void testUpdateOrderID2() throws Exception {
        doNothing().when(bookingService).updateOrderId(Mockito.<String>any(), Mockito.<String>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/bookingdetails/updateorderid/{bookingId}/{orderId}", "42", "42");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

