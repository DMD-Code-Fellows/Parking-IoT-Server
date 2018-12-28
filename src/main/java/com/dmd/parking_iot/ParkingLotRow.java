package com.dmd.parking_iot;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * A parking lot row consisting of adjacent parking spaces.
 */
@Entity
class ParkingLotRow {

    /**
     * Unique id of this parking lot row.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * This rows name.
     */
    private String rowName;

    /**
     * The list of parking spaces in this row.
     */
    @OneToMany
    private final List<ParkingSpace> parkingSpaces = new LinkedList<>();

    /**
     * Getter method. Returns the name of this row.
     * @return The name of this row.
     */
    public String getRowName() {
        return rowName;
    }

    /**
     * Getter method. Returns the list of parking spaces in this row.
     * @return The parking spaces in this row.
     */
    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }
}
