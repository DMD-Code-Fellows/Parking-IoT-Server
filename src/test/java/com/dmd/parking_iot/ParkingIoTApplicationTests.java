package com.dmd.parking_iot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingIoTApplicationTests {

	@Autowired
	private ParkingLotController parkingLotController;

    @Test
    public void contextLoads() {
        assertThat(parkingLotController).isNotNull();
    }

    @Test
    public void testParkingSpaceStateMachine() {
        ParkingSpace parkingSpace = new ParkingSpace();
    }
}

