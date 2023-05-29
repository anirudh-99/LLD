package model.gate;

import lombok.*;
import model.*;

import java.time.*;
import java.time.temporal.*;

@Data
public class ExitGate {
    // calculateFee(),emptyParkingLot(), acceptPayment()
    private ParkingFloor parkingFloor;

    public double calculateFee(Ticket ticket){
        long minutes = ChronoUnit.MINUTES.between(ticket.getEntryTime(),LocalDateTime.now());
        return minutes*0.5;
    }

    public void acceptPayment(Ticket ticket,double money){
        System.out.println(String.format("Received %d",money));
        ticket.getParkingSpot().removeVehicle();
        // add to empty slots
    }
}
