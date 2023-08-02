package com.example.bookingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDetails {


    @Id
    private Long id;
    private String train_id;
    private Integer quantity;
    private Double totalfare;
    private String quota;
    private String booked_by;
    private Boolean payment_status;
    private Boolean cancel_status;
    private String payOrderId;
    private String depart;
    private String arrival;
    private String depart_time;
    private String arrival_time;



}
