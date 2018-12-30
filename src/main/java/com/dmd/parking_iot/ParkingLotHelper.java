package com.dmd.parking_iot;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Helper class designed to create example parking lots, consisting of rows, and their spaces.
 * Intended for demonstration and testing purposes only.
 * TODO Enhance to create parking lots based on a JSON file.
 */
class ParkingLotHelper {

//    /**
//     * The parking lot repository.
//     */
//    @Autowired
//    private static ParkingLotRepository parkingLotRepository;
//
//    /**
//     * The parking lot row repository.
//     */
//    @Autowired
//    private static ParkingLotRowRepository parkingLotRowRepository;
//
//    /**
//     * The parking space repository.
//     */
//    @Autowired
//    private ParkingSpaceRepository parkingSpaceRepository;

    static ParkingLot makeParkingLotOne() {
        ParkingLot parkingLot = new ParkingLot(Constants.PARKING_LOT_ONE_NAME);
        ArrayList<ParkingLotRow> rows = new ArrayList<>();

        // Setup row1
        ArrayList<ParkingSpace> spaces = new ArrayList<>();
        ParkingLotRow row1 = new ParkingLotRow(Constants.PARKING_LOT_ONE_R1_NAME);
        spaces.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R1_S1_NAME));
        spaces.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R1_S2_NAME));
        spaces.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R1_S3_NAME));
        spaces.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R1_S4_NAME));
        spaces.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R1_S5_NAME));
        spaces.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R1_S6_NAME));
//        parkingSpaceRepository.saveAll(spaces);
        row1.addAllParkingSpaces(spaces);
//        parkingLotRowRepository.save(row1);
        rows.add(row1);

        // Setup row2
        ArrayList<ParkingSpace> spaces2 = new ArrayList<>();
        ParkingLotRow row2 = new ParkingLotRow(Constants.PARKING_LOT_ONE_R2_NAME);
        spaces2.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R2_S1_NAME));
        spaces2.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R2_S2_NAME));
        spaces2.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R2_S3_NAME));
        spaces2.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R2_S4_NAME));
        spaces2.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R2_S5_NAME));
        spaces2.add(new ParkingSpace(Constants.PARKING_LOT_ONE_R2_S6_NAME));
//        parkingSpaceRepository.saveAll(spaces2);
        row2.addAllParkingSpaces(spaces2);
//        parkingLotRowRepository.save(row2);
        rows.add(row2);

        // Finally, define the parking lot's rows
//        parkingLot.addAllParkingLotRows(rows);

//        parkingLotRepository.save(parkingLot);

        parkingLot.addAllParkingLotRows(rows);

        return parkingLot;
    }
}
