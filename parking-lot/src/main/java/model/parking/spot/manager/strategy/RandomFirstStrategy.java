package model.parking.spot.manager.strategy;

import model.parking.spot.*;

import java.util.*;

public class RandomFirstStrategy implements EmptySlotFindingStrategy{

    @Override
    public ParkingSpot findEmptySlot(Collection<ParkingSpot> collection) {
        if(collection instanceof PriorityQueue<ParkingSpot>){
            PriorityQueue<ParkingSpot> pq = (PriorityQueue<ParkingSpot>) collection;
            return pq.peek();
        }
        else{
            return collection.stream().findFirst().orElse(null);
        }
    }
}
