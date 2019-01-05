package com.dmd.parking_iot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A parking lot consisting of rows of parking spaces.
 * Parking lots are guaranteed to have uniquely named rows.
 * Parking lots are guaranteed to have uniquely names spaces.
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
    @OneToMany(fetch = FetchType.EAGER)
    private final List<ParkingLotRow> parkingLotRows = new LinkedList<>();
    //We made it EAGER to make testing work. That's a hack.

    /**
     * Default constructor.
     */
    public ParkingLot(){};

    /**
     * Constructor.
     * @param name This parking lots name.
     */
    public ParkingLot(String name) { this.name = name; }

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

    /**
     * Convenience method to add a list of parking lot rows to this parking lot.
     * @param rows The list of rows to add.
     */
    public void addAllParkingLotRows(ArrayList<ParkingLotRow> rows) {
        //TODO Enhance to ensure that no two rows have the same name
        //TODO Enhance to ensure that no two spaces have the same name
        if (rows == null) {
            throw new IllegalArgumentException("Error: invalid input - rows to add is null");
        }
        parkingLotRows.addAll(rows);
    }

    /**
     * Convenience method that searches all the rows for a space with matching name.
     * @param name The name of the parking space to find.
     * @return The parking space with passed in name. May be null.
     */
    public ParkingSpace findParkingSpaceForName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Error: invalid input - name to search for is null!");
        }
        ParkingLotRow row;
        ParkingSpace space;
        for (int i = 0; i < parkingLotRows.size(); i++) {
            row = parkingLotRows.get(i);
            for (int j = 0; j < row.getParkingSpaces().size(); j++) {
                space = row.getParkingSpaces().get(j);
                if (space.getName().equals(name)) {
                    return space;
                }
            }
        }
        return null;
    }
}
