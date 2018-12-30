package com.dmd.parking_iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

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
     * The parking space repository.
     */
    @Autowired
    private ParkingSpaceTransactionRepository parkingSpaceTransactionRepository;

    /**
     * TODO
     *  The template to map to the home page.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * route mapping to the space-map page.
     * @param m
     * @return
     */
    @RequestMapping(value = "/space-map", method = RequestMethod.GET)
    public String showSpace(Model m) {
        m.addAttribute("spaces", parkingSpaceRepository.findAll());
        m.addAttribute("rows", parkingLotRowRepository.findAll());
        m.addAttribute("lots", parkingLotRepository.findAll());
        return "space";
    }

    /**
     * This method is for project demo purposes only. If things go haywire with lot data,
     * or if you just want to reset to a known point for presentation purposes, use it.
     * @return A redirect to the /space-map route.
     */
    @RequestMapping(value = "/space-map/reset", method = RequestMethod.GET)
    public RedirectView resetParkingLot() {
        ParkingLot parkingLot = ParkingLotHelper.makeParkingLotOne();
        ParkingLotRow row;
        for (int i = 0; i < parkingLot.getParkingLotRows().size(); i++) {
            row = parkingLot.getParkingLotRows().get(i);
            parkingSpaceRepository.saveAll(row.getParkingSpaces());
        }
        parkingLotRowRepository.saveAll(parkingLot.getParkingLotRows());
        parkingLotRepository.save(parkingLot);
        return new RedirectView("/space-map");
    }
}
