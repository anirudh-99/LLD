package model.parking.spot.manager.strategy;

import model.parking.spot.*;

import java.util.*;

public interface EmptySlotFindingStrategy {

    ParkingSpot findEmptySlot(Collection<ParkingSpot> collection);

}
