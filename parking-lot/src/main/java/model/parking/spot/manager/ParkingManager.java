package model.parking.spot.manager;

import model.*;
import model.parking.spot.*;
import model.vehicle.*;

import java.time.*;

public abstract class ParkingManager {
    private int capacity;

    public ParkingManager(int capacity) {
        this.capacity = capacity;
    }

    abstract protected ParkingSpot getEmptyParkingSpot();

    /**
     *
     * @param vehicle
     * @return null if there are no parking slots else Ticket
     */
    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot = getEmptyParkingSpot();
        if(spot!=null){
            spot.parkVehicle(vehicle);
            return new Ticket(LocalDateTime.now(),spot);
        }
        else return null;
    }

    abstract public void removeVehicle(ParkingSpot spot);

    abstract public boolean isFull();

}
