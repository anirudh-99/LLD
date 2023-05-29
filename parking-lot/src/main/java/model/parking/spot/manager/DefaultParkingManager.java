package model.parking.spot.manager;

import model.parking.spot.*;
import model.parking.spot.manager.strategy.*;

import java.util.*;

public class DefaultParkingManager extends ParkingManager {
    private TreeSet<ParkingSpot> emptyParkingSpots;
    private TreeSet<ParkingSpot> occupiedParkingSpots;
    private EmptySlotFindingStrategy emptySlotFindingStrategy;

    public DefaultParkingManager(int capacity) {
        super(capacity);
        this.emptySlotFindingStrategy = new RandomFirstStrategy();
    }

    @Override
    protected ParkingSpot getEmptyParkingSpot(){
        ParkingSpot spot = emptySlotFindingStrategy.findEmptySlot(emptyParkingSpots);
        if(spot == null){
            System.out.println("All the parking lots are filled :(");
            return null;
        }
        emptyParkingSpots.remove(spot);
        occupiedParkingSpots.add(spot);
        return spot;
    }

    @Override
    public void removeVehicle(ParkingSpot spot) {
        spot.removeVehicle();
        occupiedParkingSpots.remove(spot);
        emptyParkingSpots.add(spot);
    }

    @Override
    public boolean isFull() {
        return emptyParkingSpots.isEmpty();
    }

}
