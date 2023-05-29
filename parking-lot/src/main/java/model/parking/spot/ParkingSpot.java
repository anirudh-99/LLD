package model.parking.spot;

import lombok.*;
import model.vehicle.*;

@Data
public abstract class ParkingSpot {

    private int id;
    private boolean empty;
    private Vehicle vehicle;
    private double price;
    private ParkingSpotType parkingSpotType;

    public ParkingSpot(int id, double price,ParkingSpotType type) {
        this.id = id;
        this.empty = true;
        this.vehicle = null;
        this.price = price;
        this.parkingSpotType = type;
    }

    public void parkVehicle(Vehicle vehicle){
        this.setVehicle(vehicle);
        this.empty = false;
    }

    public void removeVehicle(){
        this.setVehicle(null);
        this.empty = true;
    }

}
