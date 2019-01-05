package com.dmd.parking_iot;

import com.dmd.iot.parking_iot.common.ParkingLotExample;
import com.dmd.iot.parking_iot.common.ParkingSpaceEvents;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingIoTApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
	private ParkingLotController parkingLotController;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(parkingLotController).isNotNull();
    }

    @Test
    public void getHomeWorks() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Inspired back the movement started in South Korea of using balloons");
    }

    /**
     * GET space-map/reset integration test. Also - domain model CRUD and unit testing done here,
     * taking advantage of the integration test populating the model
     */
    @Test
    public void putResetRouteAndModelDomainWorks() {
        //First do the integration test, which populates the database with our example parking lot.
        String result = restTemplate.getForObject(URI.create("http://localhost:" + port + "/space-map/reset"), String.class);
        assertNotNull(result);
        assertThat(result).contains("Drive ---->");

        //Now retrieve the parking lot, ensuring that it did in fact get created/persisted.
        ParkingLot parkingLot = parkingLotRepository.findByName(ParkingLotExample.PARKING_LOT_ONE_NAME).get();
        assertNotNull(parkingLot);
        assertTrue(parkingLot.getName().equals(ParkingLotExample.PARKING_LOT_ONE_NAME));

        //Next, make sure the parking lot has the correct rows.
        ParkingLotRow[] rows = new ParkingLotRow[ParkingLotExample.PARKING_LOT_ONE_NUM_ROWS];
        rows = parkingLot.getParkingLotRows().toArray(rows);
        ParkingLotRow row;
        for (int i = 0; i < ParkingLotExample.PARKING_LOT_ONE_NUM_ROWS; i++) {
            row = rows[i];
            assertTrue(row.getName().equals(ParkingLotExample.rows[i]));
        }

        //Now, check that all the spaces are correct in each row.
        //Row one first
        ParkingSpace[] rowOneSpaces = new ParkingSpace[ParkingLotExample.PARKING_LOT_ONE_R1_NUM_SPACES];
        rowOneSpaces = rows[0].getParkingSpaces().toArray(rowOneSpaces);
        for (int i = 0; i < ParkingLotExample.PARKING_LOT_ONE_R1_NUM_SPACES; i++) {
            rowOneSpaces[i].getName().equals(ParkingLotExample.rowOneSpaces[i]);
        }

        //Row two next
        ParkingSpace[] rowTwoSpaces = new ParkingSpace[ParkingLotExample.PARKING_LOT_ONE_R2_NUM_SPACES];
        rowTwoSpaces = rows[1].getParkingSpaces().toArray(rowTwoSpaces);
        for (int i = 0; i < ParkingLotExample.PARKING_LOT_ONE_R2_NUM_SPACES; i++) {
            rowTwoSpaces[i].getName().equals(ParkingLotExample.rowTwoSpaces[i]);
        }
    }

    @Test
    public void putSpaceWorks() {
        //First - populate database with example parking lot.
        String result = restTemplate.getForObject(URI.create("http://localhost:" + port + "/space-map/reset"), String.class);
        assertNotNull(result);
        assertThat(result).contains("Drive ---->");

        //Lets test the put route
        LinkedMultiValueMap paramsMap = new LinkedMultiValueMap();
        paramsMap.add("parkingLotName", ParkingLotExample.PARKING_LOT_ONE_NAME);
        paramsMap.add("parkingSpaceName", ParkingLotExample.PARKING_LOT_ONE_R1_S2_NAME);
        paramsMap.add("parkingSpaceEvent", ParkingSpaceEvents.OCCUPY);
        restTemplate.put(URI.create("http://localhost:" + port + "/space-map/update"), paramsMap);
    }
}
