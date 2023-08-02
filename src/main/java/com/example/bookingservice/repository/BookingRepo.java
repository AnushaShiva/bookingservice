package com.example.bookingservice.repository;

import com.example.bookingservice.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo  extends JpaRepository<BookingDetails, Long> {
    BookingDetails findByid(String bookid);
}
