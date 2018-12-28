package com.dmd.parking_iot;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface for ParkingLotRow objects (JPA).
 */
public interface ParkingLotRowRepository extends CrudRepository<ParkingLotRow, Long> {
}
