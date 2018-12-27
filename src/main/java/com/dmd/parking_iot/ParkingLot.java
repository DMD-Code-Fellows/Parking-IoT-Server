package com.dmd.parking_iot;

import javax.persistence.*;

/**
 * A parking lot consisting of rows of parking spaces.
 */
@Entity
public class ParkingLot {

    /**
     * Unique id of this parking lot.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The name of this parking lot.
     */
    @Column(unique = true)
    private String name;

    /**
     * Getter method. Returns the name of this parking lot.
     * @return The parking lot name.
     */
    public String getName() {
        return name;
    }
}
