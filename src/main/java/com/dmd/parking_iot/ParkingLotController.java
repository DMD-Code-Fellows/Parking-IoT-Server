package com.dmd.parking_iot;

import com.dmd.iot.parking_iot.common.ParkingSpaceEvents;
import com.dmd.iot.parking_iot.common.ParkingSpaceStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//    /**
//     * TODO
//     */
//    @Autowired
//    private StateMachine<ParkingSpaceStates, ParkingSpaceEvents> parkingSpaceStateMachine;

    /**
     * Returns the path to the home page template index.html.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * Route mapping to the space-map page.
     * @param m the ParkingLot Object
     * @return The route to space.html
     */
    @RequestMapping(value = "/space-map", method = RequestMethod.GET)
    public String showSpace(Model m) {
        m.addAttribute("lots", parkingLotRepository.findAll());
        return "space";
    }

    /**
     * Processes event parkingSpaceEvent, for parking space with name parkingSpaceName,
     * contained in parking lot, with name parkingLotName.
     * @param parkingLotName The unique name of the parking lot, which is used to find the parking space subject of the event.
     * @param parkingSpaceName The parking space name, unique within the parking lot, subject to the event.
     * @param parkingSpaceEvent The event to the parking space, to process.
     * @return The route to space-map-updated.html.
     */
    @RequestMapping(value = "/space-map/update", method = RequestMethod.PUT)
    public String processParkingSpaceEvent(
            @RequestParam String parkingLotName,
            @RequestParam String parkingSpaceName,
            @RequestParam String parkingSpaceEvent) {
        ParkingLot parkingLot = parkingLotRepository.findByName(parkingLotName).get();
        ParkingSpace parkingSpace = parkingLot.findParkingSpaceForName(parkingSpaceName);
        ParkingSpaceEvents event = ParkingSpaceEvents.valueOf(parkingSpaceEvent);
        switch (event) {
            case OCCUPY:
                parkingSpace.setStatus(ParkingSpaceStates.OCCUPIED);
                break;

            case VACATE:
                parkingSpace.setStatus(ParkingSpaceStates.VACANT);
                break;
        }

        //TODO Create and save a new ParkingSpaceTransaction for this event
        parkingLotRepository.save(parkingLot);
        return"space-map-updated";
    }

    //TODO there must be a better way than with a route. Something we could add to main?
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
