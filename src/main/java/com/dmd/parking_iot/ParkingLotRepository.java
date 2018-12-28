package com.dmd.parking_iot;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface for ParkingLot objects (JPA).
 */
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {
}
