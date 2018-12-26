package com.dmd.parking_iot;

import org.springframework.data.repository.CrudRepository;

/**
 * Java Spring Boot JPA Interface.
 */
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {
}
