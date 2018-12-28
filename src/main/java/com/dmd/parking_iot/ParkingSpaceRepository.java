package com.dmd.parking_iot;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface for ParkingSpace objects (JPA).
 */
public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace, Long> {
}
