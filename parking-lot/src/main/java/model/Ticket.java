package model;

import lombok.*;
import model.parking.spot.*;

import java.time.*;

@Data
@AllArgsConstructor
public class Ticket {
    // entry time, parking spot
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;

    public static Ticket getFor(ParkingSpot spot){
        return new Ticket(LocalDateTime.now(),spot);
    }
}
