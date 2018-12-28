package com.dmd.parking_iot;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

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
     * The rows of this parking lot.
     */
    @OneToMany
    private final List<ParkingLotRow> parkingLotRows = new LinkedList<>();

    /**
     * Getter method. Returns the name of this parking lot.
     * @return The parking lot name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method. Returns the list of rows in this parking lot.
     * @return The rows in this parking lot.
     */
    public List<ParkingLotRow> getParkingLotRows() {
        return parkingLotRows;
    }
}
