package com.dmd.parking_iot;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface for ParkingSpaceTransaction objects (JPA).
 */
public interface ParkingSpaceTransactionRepository  extends CrudRepository<ParkingSpaceTransaction, Long> {
}
