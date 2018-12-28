package com.dmd.parking_iot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value="/space-map", method= RequestMethod.GET)
    public String showSpace(){
        return "space";
    }
}
