package com.dmd.parking_iot;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String name;

    /**
     * The list of parking spaces in this row.
     */
    @OneToMany
    private final List<ParkingSpace> parkingSpaces = new LinkedList<>();

    /**
     * Constructor.
     * @param name The name of this row.
     */
    public ParkingLotRow(String name) {
        this.name = name;
    }

    /**
     * Getter method. Returns the name of this row.
     * @return The name of this row.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method. Returns the list of parking spaces in this row.
     * @return The parking spaces in this row.
     */
    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    /**
     * Adds all the passed in parking space objects to the end of this row, in order.
     * @param spaces The list of spaces to add to this row.
     */
    public void addAllParkingSpaces(ArrayList<ParkingSpace> spaces) {
        //TODO Enhance to ensure that no two spaces have the same name
        if (spaces == null) {
            throw new IllegalArgumentException("Error: invalid input - spaces to add is null!");
        }
        parkingSpaces.addAll(spaces);
    }
}
