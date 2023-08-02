package com.example.bookingservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.bookingservice.entity.BookingDetails;
import com.example.bookingservice.exception.ResourceNotFoundException;
import com.example.bookingservice.repository.BookingRepo;
import com.razorpay.RazorpayException;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingService.class})
@ExtendWith(SpringExtension.class)
class BookingServiceTest {
    @MockBean
    private BookingRepo bookingRepo;

    @Autowired
    private BookingService bookingService;

    @MockBean
    private Producer producer;

    /**
     * Method under test: {@link BookingService#bookTicket(BookingDetails)}
     */
    @Test
    void testBookTicket() {
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
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails);

        BookingDetails details = new BookingDetails();
        details.setArrival("Arrival");
        details.setArrival_time("Arrival time");
        details.setBooked_by("Booked by");
        details.setCancel_status(true);
        details.setDepart("Depart");
        details.setDepart_time("Depart time");
        details.setId(1L);
        details.setPayOrderId("42");
        details.setPayment_status(true);
        details.setQuantity(1);
        details.setQuota("Quota");
        details.setTotalfare(10.0d);
        details.setTrain_id("Train id");
        assertEquals("BookingDetails added successfully", bookingService.bookTicket(details));
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
    }

    /**
     * Method under test: {@link BookingService#bookTicket(BookingDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBookTicket2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: BookingDetails added successfully
        //       at com.example.bookingservice.service.BookingService.bookTicket(BookingService.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bookingRepo.save(Mockito.<BookingDetails>any()))
                .thenThrow(new NullPointerException("BookingDetails added successfully"));

        BookingDetails details = new BookingDetails();
        details.setArrival("Arrival");
        details.setArrival_time("Arrival time");
        details.setBooked_by("Booked by");
        details.setCancel_status(true);
        details.setDepart("Depart");
        details.setDepart_time("Depart time");
        details.setId(1L);
        details.setPayOrderId("42");
        details.setPayment_status(true);
        details.setQuantity(1);
        details.setQuota("Quota");
        details.setTotalfare(10.0d);
        details.setTrain_id("Train id");
        bookingService.bookTicket(details);
    }

    /**
     * Method under test: {@link BookingService#getById(long)}
     */
    @Test
    void testGetById() {
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
        Optional<BookingDetails> ofResult = Optional.of(bookingDetails);
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(bookingDetails, bookingService.getById(1L));
        verify(bookingRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingService#getById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: here id is null
        //       at com.example.bookingservice.service.BookingService.getById(BookingService.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        bookingService.getById(1L);
    }

    /**
     * Method under test: {@link BookingService#getById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: here id is null
        //       at com.example.bookingservice.service.BookingService.getById(BookingService.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bookingRepo.findById(Mockito.<Long>any())).thenThrow(new NullPointerException("here id is null"));
        bookingService.getById(1L);
    }

    /**
     * Method under test: {@link BookingService#getAllBookings()}
     */
    @Test
    void testGetAllBookings() {
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        when(bookingRepo.findAll()).thenReturn(bookingDetailsList);
        List<BookingDetails> actualAllBookings = bookingService.getAllBookings();
        assertSame(bookingDetailsList, actualAllBookings);
        assertTrue(actualAllBookings.isEmpty());
        verify(bookingRepo).findAll();
    }

    /**
     * Method under test: {@link BookingService#getAllBookings()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllBookings2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.example.bookingservice.service.BookingService.getAllBookings(BookingService.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bookingRepo.findAll()).thenThrow(new NullPointerException("foo"));
        bookingService.getAllBookings();
    }

    /**
     * Method under test: {@link BookingService#deleteById(long)}
     */
    @Test
    void testDeleteById() {
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
        Optional<BookingDetails> ofResult = Optional.of(bookingDetails);
        doNothing().when(bookingRepo).deleteById(Mockito.<Long>any());
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertEquals("deleted successfullly", bookingService.deleteById(1L));
        verify(bookingRepo).findById(Mockito.<Long>any());
        verify(bookingRepo).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingService#deleteById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: deleted successfullly
        //       at com.example.bookingservice.service.BookingService.deleteById(BookingService.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<BookingDetails> ofResult = Optional.of(bookingDetails);
        doThrow(new NullPointerException("deleted successfullly")).when(bookingRepo).deleteById(Mockito.<Long>any());
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        bookingService.deleteById(1L);
    }

    /**
     * Method under test: {@link BookingService#deleteById(long)}
     */
    @Test
    void testDeleteById3() {
        doNothing().when(bookingRepo).deleteById(Mockito.<Long>any());
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> bookingService.deleteById(1L));
        verify(bookingRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingService#update(BookingDetails, long)}
     */
    @Test
    void testUpdate() {
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
        Optional<BookingDetails> ofResult = Optional.of(bookingDetails);

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setArrival("Arrival");
        bookingDetails2.setArrival_time("Arrival time");
        bookingDetails2.setBooked_by("Booked by");
        bookingDetails2.setCancel_status(true);
        bookingDetails2.setDepart("Depart");
        bookingDetails2.setDepart_time("Depart time");
        bookingDetails2.setId(1L);
        bookingDetails2.setPayOrderId("42");
        bookingDetails2.setPayment_status(true);
        bookingDetails2.setQuantity(1);
        bookingDetails2.setQuota("Quota");
        bookingDetails2.setTotalfare(10.0d);
        bookingDetails2.setTrain_id("Train id");
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails2);
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);

        BookingDetails details = new BookingDetails();
        details.setArrival("Arrival");
        details.setArrival_time("Arrival time");
        details.setBooked_by("Booked by");
        details.setCancel_status(true);
        details.setDepart("Depart");
        details.setDepart_time("Depart time");
        details.setId(1L);
        details.setPayOrderId("42");
        details.setPayment_status(true);
        details.setQuantity(1);
        details.setQuota("Quota");
        details.setTotalfare(10.0d);
        details.setTrain_id("Train id");
        assertEquals("updated the booking details successfully", bookingService.update(details, 1L));
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
        verify(bookingRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingService#update(BookingDetails, long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: updated the booking details successfully
        //       at com.example.bookingservice.service.BookingService.update(BookingService.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<BookingDetails> ofResult = Optional.of(bookingDetails);
        when(bookingRepo.save(Mockito.<BookingDetails>any()))
                .thenThrow(new NullPointerException("updated the booking details successfully"));
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);

        BookingDetails details = new BookingDetails();
        details.setArrival("Arrival");
        details.setArrival_time("Arrival time");
        details.setBooked_by("Booked by");
        details.setCancel_status(true);
        details.setDepart("Depart");
        details.setDepart_time("Depart time");
        details.setId(1L);
        details.setPayOrderId("42");
        details.setPayment_status(true);
        details.setQuantity(1);
        details.setQuota("Quota");
        details.setTotalfare(10.0d);
        details.setTrain_id("Train id");
        bookingService.update(details, 1L);
    }

    /**
     * Method under test: {@link BookingService#update(BookingDetails, long)}
     */
    @Test
    void testUpdate3() {
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
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails);
        when(bookingRepo.findById(Mockito.<Long>any())).thenReturn(Optional.empty());

        BookingDetails details = new BookingDetails();
        details.setArrival("Arrival");
        details.setArrival_time("Arrival time");
        details.setBooked_by("Booked by");
        details.setCancel_status(true);
        details.setDepart("Depart");
        details.setDepart_time("Depart time");
        details.setId(1L);
        details.setPayOrderId("42");
        details.setPayment_status(true);
        details.setQuantity(1);
        details.setQuota("Quota");
        details.setTotalfare(10.0d);
        details.setTrain_id("Train id");
        assertThrows(ResourceNotFoundException.class, () -> bookingService.update(details, 1L));
        verify(bookingRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingService#getAllBookbyUser(String)}
     */
    @Test
    void testGetAllBookbyUser() {
        when(bookingRepo.findAll()).thenReturn(new ArrayList<>());
        assertTrue(bookingService.getAllBookbyUser("Userid").isEmpty());
        verify(bookingRepo).findAll();
    }

    /**
     * Method under test: {@link BookingService#getAllBookbyUser(String)}
     */
    @Test
    void testGetAllBookbyUser2() {
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

        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(bookingDetails);
        when(bookingRepo.findAll()).thenReturn(bookingDetailsList);
        assertTrue(bookingService.getAllBookbyUser("Userid").isEmpty());
        verify(bookingRepo).findAll();
    }

    /**
     * Method under test: {@link BookingService#getAllBookbyUser(String)}
     */
    @Test
    void testGetAllBookbyUser3() {
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

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setArrival("Userid");
        bookingDetails2.setArrival_time("Userid");
        bookingDetails2.setBooked_by("Userid");
        bookingDetails2.setCancel_status(false);
        bookingDetails2.setDepart("Userid");
        bookingDetails2.setDepart_time("Userid");
        bookingDetails2.setId(2L);
        bookingDetails2.setPayOrderId("Booked by");
        bookingDetails2.setPayment_status(false);
        bookingDetails2.setQuantity(0);
        bookingDetails2.setQuota("Userid");
        bookingDetails2.setTotalfare(0.5d);
        bookingDetails2.setTrain_id("Userid");

        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(bookingDetails2);
        bookingDetailsList.add(bookingDetails);
        when(bookingRepo.findAll()).thenReturn(bookingDetailsList);
        assertEquals(1, bookingService.getAllBookbyUser("Userid").size());
        verify(bookingRepo).findAll();
    }

    /**
     * Method under test: {@link BookingService#getAllBookbyUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllBookbyUser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.example.bookingservice.service.BookingService.getAllBookbyUser(BookingService.java:76)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bookingRepo.findAll()).thenThrow(new NullPointerException("foo"));
        bookingService.getAllBookbyUser("Userid");
    }

    /**
     * Method under test: {@link BookingService#getAllBookbyUser(String)}
     */
    @Test
    void testGetAllBookbyUser5() {
        BookingDetails bookingDetails = mock(BookingDetails.class);
        when(bookingDetails.getBooked_by()).thenReturn("Booked by");
        doNothing().when(bookingDetails).setArrival(Mockito.<String>any());
        doNothing().when(bookingDetails).setArrival_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setBooked_by(Mockito.<String>any());
        doNothing().when(bookingDetails).setCancel_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setDepart(Mockito.<String>any());
        doNothing().when(bookingDetails).setDepart_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setId(Mockito.<Long>any());
        doNothing().when(bookingDetails).setPayOrderId(Mockito.<String>any());
        doNothing().when(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setQuantity(Mockito.<Integer>any());
        doNothing().when(bookingDetails).setQuota(Mockito.<String>any());
        doNothing().when(bookingDetails).setTotalfare(Mockito.<Double>any());
        doNothing().when(bookingDetails).setTrain_id(Mockito.<String>any());
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

        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(bookingDetails);
        when(bookingRepo.findAll()).thenReturn(bookingDetailsList);
        assertTrue(bookingService.getAllBookbyUser("Userid").isEmpty());
        verify(bookingRepo).findAll();
        verify(bookingDetails).getBooked_by();
        verify(bookingDetails).setArrival(Mockito.<String>any());
        verify(bookingDetails).setArrival_time(Mockito.<String>any());
        verify(bookingDetails).setBooked_by(Mockito.<String>any());
        verify(bookingDetails).setCancel_status(Mockito.<Boolean>any());
        verify(bookingDetails).setDepart(Mockito.<String>any());
        verify(bookingDetails).setDepart_time(Mockito.<String>any());
        verify(bookingDetails).setId(Mockito.<Long>any());
        verify(bookingDetails).setPayOrderId(Mockito.<String>any());
        verify(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        verify(bookingDetails).setQuantity(Mockito.<Integer>any());
        verify(bookingDetails).setQuota(Mockito.<String>any());
        verify(bookingDetails).setTotalfare(Mockito.<Double>any());
        verify(bookingDetails).setTrain_id(Mockito.<String>any());
    }

    /**
     * Method under test: {@link BookingService#cancelBooking(String)}
     */
    @Test
    void testCancelBooking() {
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

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setArrival("Arrival");
        bookingDetails2.setArrival_time("Arrival time");
        bookingDetails2.setBooked_by("Booked by");
        bookingDetails2.setCancel_status(true);
        bookingDetails2.setDepart("Depart");
        bookingDetails2.setDepart_time("Depart time");
        bookingDetails2.setId(1L);
        bookingDetails2.setPayOrderId("42");
        bookingDetails2.setPayment_status(true);
        bookingDetails2.setQuantity(1);
        bookingDetails2.setQuota("Quota");
        bookingDetails2.setTotalfare(10.0d);
        bookingDetails2.setTrain_id("Train id");
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails2);
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.cancelBooking("Bookid");
        verify(bookingRepo).findByid(Mockito.<String>any());
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
    }

    /**
     * Method under test: {@link BookingService#cancelBooking(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCancelBooking2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: #### -> Cancel Booking ,with Booking id:  -> %s
        //       at com.example.bookingservice.service.BookingService.cancelBooking(BookingService.java:92)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(bookingRepo.save(Mockito.<BookingDetails>any()))
                .thenThrow(new NullPointerException("#### -> Cancel Booking ,with Booking id:  -> %s"));
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.cancelBooking("Bookid");
    }

    /**
     * Method under test: {@link BookingService#cancelBooking(String)}
     */
    @Test
    void testCancelBooking3() {
        BookingDetails bookingDetails = mock(BookingDetails.class);
        doNothing().when(bookingDetails).setArrival(Mockito.<String>any());
        doNothing().when(bookingDetails).setArrival_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setBooked_by(Mockito.<String>any());
        doNothing().when(bookingDetails).setCancel_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setDepart(Mockito.<String>any());
        doNothing().when(bookingDetails).setDepart_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setId(Mockito.<Long>any());
        doNothing().when(bookingDetails).setPayOrderId(Mockito.<String>any());
        doNothing().when(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setQuantity(Mockito.<Integer>any());
        doNothing().when(bookingDetails).setQuota(Mockito.<String>any());
        doNothing().when(bookingDetails).setTotalfare(Mockito.<Double>any());
        doNothing().when(bookingDetails).setTrain_id(Mockito.<String>any());
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

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setArrival("Arrival");
        bookingDetails2.setArrival_time("Arrival time");
        bookingDetails2.setBooked_by("Booked by");
        bookingDetails2.setCancel_status(true);
        bookingDetails2.setDepart("Depart");
        bookingDetails2.setDepart_time("Depart time");
        bookingDetails2.setId(1L);
        bookingDetails2.setPayOrderId("42");
        bookingDetails2.setPayment_status(true);
        bookingDetails2.setQuantity(1);
        bookingDetails2.setQuota("Quota");
        bookingDetails2.setTotalfare(10.0d);
        bookingDetails2.setTrain_id("Train id");
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails2);
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.cancelBooking("Bookid");
        verify(bookingRepo).findByid(Mockito.<String>any());
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
        verify(bookingDetails).setArrival(Mockito.<String>any());
        verify(bookingDetails).setArrival_time(Mockito.<String>any());
        verify(bookingDetails).setBooked_by(Mockito.<String>any());
        verify(bookingDetails, atLeast(1)).setCancel_status(Mockito.<Boolean>any());
        verify(bookingDetails).setDepart(Mockito.<String>any());
        verify(bookingDetails).setDepart_time(Mockito.<String>any());
        verify(bookingDetails).setId(Mockito.<Long>any());
        verify(bookingDetails).setPayOrderId(Mockito.<String>any());
        verify(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        verify(bookingDetails).setQuantity(Mockito.<Integer>any());
        verify(bookingDetails).setQuota(Mockito.<String>any());
        verify(bookingDetails).setTotalfare(Mockito.<Double>any());
        verify(bookingDetails).setTrain_id(Mockito.<String>any());
    }

    /**
     * Method under test: {@link BookingService#addBookingDetails(BookingDetails)}
     */
    @Test
    void testAddBookingDetails() {
        doNothing().when(producer).sendMessage(Mockito.<String>any());

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
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails);

        BookingDetails bookingmodel = new BookingDetails();
        bookingmodel.setArrival("Arrival");
        bookingmodel.setArrival_time("Arrival time");
        bookingmodel.setBooked_by("Booked by");
        bookingmodel.setCancel_status(true);
        bookingmodel.setDepart("Depart");
        bookingmodel.setDepart_time("Depart time");
        bookingmodel.setId(1L);
        bookingmodel.setPayOrderId("42");
        bookingmodel.setPayment_status(true);
        bookingmodel.setQuantity(1);
        bookingmodel.setQuota("Quota");
        bookingmodel.setTotalfare(10.0d);
        bookingmodel.setTrain_id("Train id");
        assertSame(bookingDetails, bookingService.addBookingDetails(bookingmodel));
        verify(producer).sendMessage(Mockito.<String>any());
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
    }

    /**
     * Method under test: {@link BookingService#addBookingDetails(BookingDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddBookingDetails2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.example.bookingservice.service.BookingService.addBookingDetails(BookingService.java:100)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(producer).sendMessage(Mockito.<String>any());
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenThrow(new NullPointerException("foo"));

        BookingDetails bookingmodel = new BookingDetails();
        bookingmodel.setArrival("Arrival");
        bookingmodel.setArrival_time("Arrival time");
        bookingmodel.setBooked_by("Booked by");
        bookingmodel.setCancel_status(true);
        bookingmodel.setDepart("Depart");
        bookingmodel.setDepart_time("Depart time");
        bookingmodel.setId(1L);
        bookingmodel.setPayOrderId("42");
        bookingmodel.setPayment_status(true);
        bookingmodel.setQuantity(1);
        bookingmodel.setQuota("Quota");
        bookingmodel.setTotalfare(10.0d);
        bookingmodel.setTrain_id("Train id");
        bookingService.addBookingDetails(bookingmodel);
    }

    /**
     * Method under test: {@link BookingService#addBookingDetails(BookingDetails)}
     */
    @Test
    void testAddBookingDetails3() {
        doNothing().when(producer).sendMessage(Mockito.<String>any());

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
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails);
        BookingDetails bookingmodel = mock(BookingDetails.class);
        doNothing().when(bookingmodel).setArrival(Mockito.<String>any());
        doNothing().when(bookingmodel).setArrival_time(Mockito.<String>any());
        doNothing().when(bookingmodel).setBooked_by(Mockito.<String>any());
        doNothing().when(bookingmodel).setCancel_status(Mockito.<Boolean>any());
        doNothing().when(bookingmodel).setDepart(Mockito.<String>any());
        doNothing().when(bookingmodel).setDepart_time(Mockito.<String>any());
        doNothing().when(bookingmodel).setId(Mockito.<Long>any());
        doNothing().when(bookingmodel).setPayOrderId(Mockito.<String>any());
        doNothing().when(bookingmodel).setPayment_status(Mockito.<Boolean>any());
        doNothing().when(bookingmodel).setQuantity(Mockito.<Integer>any());
        doNothing().when(bookingmodel).setQuota(Mockito.<String>any());
        doNothing().when(bookingmodel).setTotalfare(Mockito.<Double>any());
        doNothing().when(bookingmodel).setTrain_id(Mockito.<String>any());
        bookingmodel.setArrival("Arrival");
        bookingmodel.setArrival_time("Arrival time");
        bookingmodel.setBooked_by("Booked by");
        bookingmodel.setCancel_status(true);
        bookingmodel.setDepart("Depart");
        bookingmodel.setDepart_time("Depart time");
        bookingmodel.setId(1L);
        bookingmodel.setPayOrderId("42");
        bookingmodel.setPayment_status(true);
        bookingmodel.setQuantity(1);
        bookingmodel.setQuota("Quota");
        bookingmodel.setTotalfare(10.0d);
        bookingmodel.setTrain_id("Train id");
        assertSame(bookingDetails, bookingService.addBookingDetails(bookingmodel));
        verify(producer).sendMessage(Mockito.<String>any());
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
        verify(bookingmodel).setArrival(Mockito.<String>any());
        verify(bookingmodel).setArrival_time(Mockito.<String>any());
        verify(bookingmodel).setBooked_by(Mockito.<String>any());
        verify(bookingmodel).setCancel_status(Mockito.<Boolean>any());
        verify(bookingmodel).setDepart(Mockito.<String>any());
        verify(bookingmodel).setDepart_time(Mockito.<String>any());
        verify(bookingmodel).setId(Mockito.<Long>any());
        verify(bookingmodel).setPayOrderId(Mockito.<String>any());
        verify(bookingmodel).setPayment_status(Mockito.<Boolean>any());
        verify(bookingmodel).setQuantity(Mockito.<Integer>any());
        verify(bookingmodel).setQuota(Mockito.<String>any());
        verify(bookingmodel).setTotalfare(Mockito.<Double>any());
        verify(bookingmodel).setTrain_id(Mockito.<String>any());
    }

    /**
     * Method under test: {@link BookingService#updateOrderId(String, String)}
     */
    @Test
    void testUpdateOrderId() {
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

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setArrival("Arrival");
        bookingDetails2.setArrival_time("Arrival time");
        bookingDetails2.setBooked_by("Booked by");
        bookingDetails2.setCancel_status(true);
        bookingDetails2.setDepart("Depart");
        bookingDetails2.setDepart_time("Depart time");
        bookingDetails2.setId(1L);
        bookingDetails2.setPayOrderId("42");
        bookingDetails2.setPayment_status(true);
        bookingDetails2.setQuantity(1);
        bookingDetails2.setQuota("Quota");
        bookingDetails2.setTotalfare(10.0d);
        bookingDetails2.setTrain_id("Train id");
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails2);
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.updateOrderId("Bookid", "Orderid");
        verify(bookingRepo).findByid(Mockito.<String>any());
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
    }

    /**
     * Method under test: {@link BookingService#updateOrderId(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateOrderId2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.example.bookingservice.service.BookingService.updateOrderId(BookingService.java:115)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenThrow(new NullPointerException("foo"));
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.updateOrderId("Bookid", "Orderid");
    }

    /**
     * Method under test: {@link BookingService#updateOrderId(String, String)}
     */
    @Test
    void testUpdateOrderId3() {
        BookingDetails bookingDetails = mock(BookingDetails.class);
        doNothing().when(bookingDetails).setArrival(Mockito.<String>any());
        doNothing().when(bookingDetails).setArrival_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setBooked_by(Mockito.<String>any());
        doNothing().when(bookingDetails).setCancel_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setDepart(Mockito.<String>any());
        doNothing().when(bookingDetails).setDepart_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setId(Mockito.<Long>any());
        doNothing().when(bookingDetails).setPayOrderId(Mockito.<String>any());
        doNothing().when(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setQuantity(Mockito.<Integer>any());
        doNothing().when(bookingDetails).setQuota(Mockito.<String>any());
        doNothing().when(bookingDetails).setTotalfare(Mockito.<Double>any());
        doNothing().when(bookingDetails).setTrain_id(Mockito.<String>any());
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

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setArrival("Arrival");
        bookingDetails2.setArrival_time("Arrival time");
        bookingDetails2.setBooked_by("Booked by");
        bookingDetails2.setCancel_status(true);
        bookingDetails2.setDepart("Depart");
        bookingDetails2.setDepart_time("Depart time");
        bookingDetails2.setId(1L);
        bookingDetails2.setPayOrderId("42");
        bookingDetails2.setPayment_status(true);
        bookingDetails2.setQuantity(1);
        bookingDetails2.setQuota("Quota");
        bookingDetails2.setTotalfare(10.0d);
        bookingDetails2.setTrain_id("Train id");
        when(bookingRepo.save(Mockito.<BookingDetails>any())).thenReturn(bookingDetails2);
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.updateOrderId("Bookid", "Orderid");
        verify(bookingRepo).findByid(Mockito.<String>any());
        verify(bookingRepo).save(Mockito.<BookingDetails>any());
        verify(bookingDetails).setArrival(Mockito.<String>any());
        verify(bookingDetails).setArrival_time(Mockito.<String>any());
        verify(bookingDetails).setBooked_by(Mockito.<String>any());
        verify(bookingDetails).setCancel_status(Mockito.<Boolean>any());
        verify(bookingDetails).setDepart(Mockito.<String>any());
        verify(bookingDetails).setDepart_time(Mockito.<String>any());
        verify(bookingDetails).setId(Mockito.<Long>any());
        verify(bookingDetails, atLeast(1)).setPayOrderId(Mockito.<String>any());
        verify(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        verify(bookingDetails).setQuantity(Mockito.<Integer>any());
        verify(bookingDetails).setQuota(Mockito.<String>any());
        verify(bookingDetails).setTotalfare(Mockito.<Double>any());
        verify(bookingDetails).setTrain_id(Mockito.<String>any());
    }

    /**
     * Method under test: {@link BookingService#updatePaymentStatus(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePaymentStatus() throws RazorpayException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

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
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.updatePaymentStatus("42");
    }

    /**
     * Method under test: {@link BookingService#updatePaymentStatus(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePaymentStatus2() throws RazorpayException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        BookingDetails bookingDetails = mock(BookingDetails.class);
        when(bookingDetails.getPayOrderId()).thenReturn("42");
        doNothing().when(bookingDetails).setArrival(Mockito.<String>any());
        doNothing().when(bookingDetails).setArrival_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setBooked_by(Mockito.<String>any());
        doNothing().when(bookingDetails).setCancel_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setDepart(Mockito.<String>any());
        doNothing().when(bookingDetails).setDepart_time(Mockito.<String>any());
        doNothing().when(bookingDetails).setId(Mockito.<Long>any());
        doNothing().when(bookingDetails).setPayOrderId(Mockito.<String>any());
        doNothing().when(bookingDetails).setPayment_status(Mockito.<Boolean>any());
        doNothing().when(bookingDetails).setQuantity(Mockito.<Integer>any());
        doNothing().when(bookingDetails).setQuota(Mockito.<String>any());
        doNothing().when(bookingDetails).setTotalfare(Mockito.<Double>any());
        doNothing().when(bookingDetails).setTrain_id(Mockito.<String>any());
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
        when(bookingRepo.findByid(Mockito.<String>any())).thenReturn(bookingDetails);
        bookingService.updatePaymentStatus("42");
    }
}

