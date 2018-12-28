package com.dmd.parking_iot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Transaction involving a parking space. Dates and times, with events
 */
@Entity
public class ParkingSpaceTransaction {

    /**
     * Unique id of this transaction.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The timestamp for this transaction
     */
    private String timestamp;

    /**
     * The event that triggered this transaction
     */
    private String event;

    /**
     * Getter method. Returns the timestamp of this transaction.
     * @return The timestamp of this transaction.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Getter method. Returns the event that triggered this transaction.
     * @return The event that triggered this transaction.
     */
    public String getEvent() {
        return event;
    }
}
