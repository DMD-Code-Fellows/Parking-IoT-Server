package com.dmd.parking_iot;

import org.springframework.statemachine.annotation.WithStateMachine;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * A parking space for a vehicle.
 */
@Entity
//@WithStateMachine
public class ParkingSpace {

    /**
     * Unique id of this parking space.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * This parking space name.
     */
    @Column(unique = true)
    private String name;

    /**
     * The list of transactions involving this parking space.
     */
    @OneToMany
    private final List<ParkingSpaceTransaction> transactions = new LinkedList<>();

    /**
     * The current state of this parking space.
     */
    private ParkingSpaceStates status;

    /**
     * Constructor.
     * @param name The name of this parking space.
     */
    public ParkingSpace(String name) {
        this.name = name;
    }

    /**
     * Changes state of this parking space to {@link ParkingSpaceStates#OCCUPIED}
     */
    @StatesOnTransition(source = ParkingSpaceStates.VACANT, target = ParkingSpaceStates.OCCUPIED)
    void occupy() {
        status = ParkingSpaceStates.OCCUPIED;
    }

    /**
     * Changes state of this parking space to {@link ParkingSpaceStates#VACANT}
     */
    @StatesOnTransition(source = ParkingSpaceStates.OCCUPIED, target = ParkingSpaceStates.VACANT)
    void vacate() {
        status = ParkingSpaceStates.VACANT;
    }

    /**
     * Changes state of this parking space to {@link ParkingSpaceStates#OUT_OF_SERVICE}
     */
    @StatesOnTransition(source = ParkingSpaceStates.VACANT, target = ParkingSpaceStates.OUT_OF_SERVICE)
    void removeFromService() {
        status = ParkingSpaceStates.OUT_OF_SERVICE;
    }

    /**
     * Changes state of this parking space to {@link ParkingSpaceStates#VACANT}
     */
    @StatesOnTransition(source = ParkingSpaceStates.OUT_OF_SERVICE, target = ParkingSpaceStates.VACANT)
    void putIntoService() {
        status = ParkingSpaceStates.VACANT;
    }

    /**
     * Getter method. Returns the list of transactions involving this parking space.
     * @return The list of transactions involving this parking space.
     */
    public List<ParkingSpaceTransaction> getTransactions() {
        return transactions;
    }

    /**
     * Getter method. Returns the status of this parking space. {@link ParkingSpaceStates}
     * @return The status of this parking space.
     */
    public ParkingSpaceStates getStatus() {
        return status;
    }

    /**
     * Getter method. Returns the name of this parking space.
     * @return The name of this parking space.
     */
    public String getName() {
        return name;
    }
}
