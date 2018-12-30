package com.dmd.parking_iot;

import java.util.ArrayList;

/**
 * Helper class designed to create example parking lots, consisting of rows, and their spaces.
 * Intended for demonstration and testing purposes only.
 * TODO Enhance to create parking lots based on a JSON file.
 */
class ParkingLotHelper {

    /**
     * Creates a 2x6 parking lot.
     * @return The parking lot.
     */
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
        row1.addAllParkingSpaces(spaces);
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
        row2.addAllParkingSpaces(spaces2);
        rows.add(row2);

        parkingLot.addAllParkingLotRows(rows);

        return parkingLot;
    }
}
