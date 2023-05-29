package model.vehicle;

import lombok.*;

@Data
public class Vehicle {
    private int regNo;
    private VehicleType type;

    public Vehicle(int regNo, VehicleType type) {
        this.regNo = regNo;
        this.type = type;
    }
}
