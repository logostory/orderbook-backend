package io.logostory.orderbook.orderbookbackend.domain;


import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

@Data
@Entity
@Table(name = "ob_seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long seatId;

    String name;
}
