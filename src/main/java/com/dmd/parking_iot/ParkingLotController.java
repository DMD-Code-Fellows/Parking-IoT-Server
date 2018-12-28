package com.dmd.parking_iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring Boot controller class for ParkingLot class.
 */
@Controller
public class ParkingLotController {

    /**
     * The parking lot repository.
     */
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    /**
     * The parking lot row repository.
     */
    @Autowired
    private ParkingLotRowRepository parkingLotRowRepository;

    /**
     * The parking space repository.
     */
    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

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
