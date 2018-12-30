package com.dmd.parking_iot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingIoTApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
	private ParkingLotController parkingLotController;

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

    //TODO Project Requirements:
    // Unit Tests
	//   - Getters/Setters
	//   - API Endpoints
	//   - CRUD operations

}
