/**
 * ParkingSpaceFactoryTest.java
 * Test class to test ParkingSpaceFactory.java class
 * Author: Sonwabile Gxoyiya (219267189)
 * Date: 6 April 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ParkingLot;
import za.ac.cput.entity.ParkingSpace;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceFactoryTest {

    @Test
    public void testCreateParkingSpace(){
        ParkingLot parkingLot = ParkingLotFactory.build("District6CampusLot","1");
        ParkingSpace parkingSpace = ParkingSpaceFactory.build("4",parkingLot.getParkingLotID());
        assertNotNull(parkingSpace);
        System.out.println(parkingSpace.toString());
    }

    @Test
    public void testParkingSpaceNotSame(){
        ParkingLot parkingLot = ParkingLotFactory.build("District6CampusLot","1");
        ParkingSpace parkingSpace = ParkingSpaceFactory.build("4",parkingLot.getParkingLotID());
        ParkingSpace parkingSpace1 = new ParkingSpace.Builder()
                .copy(parkingSpace)
                .build();
        assertNotSame(parkingSpace1, parkingSpace);

    }

}