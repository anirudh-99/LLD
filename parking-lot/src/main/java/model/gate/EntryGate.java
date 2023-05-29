package model.gate;

import lombok.*;
import model.*;
import model.parking.spot.*;

@Data
public class EntryGate {
    private ParkingFloor parkingFloor;

    private ParkingSpot getEmptyParkingSpot(){
        return parkingFloor.getEmptyParkingSpot();
    }

    public Ticket generateEntryTicket(){
        ParkingSpot spot = getEmptyParkingSpot();
        return Ticket.getFor(spot);
    }
}
