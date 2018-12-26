package com.dmd.parking_iot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring Boot controller class for ParkingLot class.
 */
@Controller
public class
ParkingLotController {

    /**
     * TODO
     *  The template to map to the home page.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
