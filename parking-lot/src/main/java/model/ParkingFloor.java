package model;

import lombok.*;
import model.parking.spot.*;
import model.parking.spot.manager.*;
import model.vehicle.*;

import java.util.*;

@Data
public class ParkingFloor {
    HashMap<VehicleType,ParkingManager> parkingManagerMap;

    private int twoWheelerCapacity;
    private int fourWheelerCapacity;

    ParkingFloor(){
        // get capacities from db
        twoWheelerCapacity = 10;
        fourWheelerCapacity = 10;

        ParkingManager twoWheelerParkingManager = new DefaultParkingManager(twoWheelerCapacity);
        ParkingManager fourWheelerParkingManager = new DefaultParkingManager(fourWheelerCapacity);

        parkingManagerMap.put(VehicleType.TWO,twoWheelerParkingManager);
        parkingManagerMap.put(VehicleType.FOUR,fourWheelerParkingManager);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingManager parkingManager = parkingManagerMap.get(vehicle.getType());
        if(parkingManager==null){
            System.out.println("This vehicle category cannot be parked in the parking lot");
            return null;
        }
        else{
            return parkingManager.parkVehicle(vehicle);
        }
    }

    public void unParkVehicle(Ticket ticket){
        Vehicle vehicle = ticket.getParkingSpot().getVehicle();
        parkingManagerMap.get(vehicle.getType()).removeVehicle(ticket.getParkingSpot());
    }

    public boolean isFull(VehicleType type){
        return parkingManagerMap.get(type).isFull();
    }

}
