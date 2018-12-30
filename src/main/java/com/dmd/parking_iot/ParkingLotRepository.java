package com.dmd.parking_iot;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Spring data repository interface for ParkingLot objects (JPA).
 */
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {

    /**
     * Searches the repository for a parking lot with matching name.
     * @param name The parking lot name for which to search.
     * @return The matching parking lot.
     */
    public Optional<ParkingSpace> findByName(String name);
}
