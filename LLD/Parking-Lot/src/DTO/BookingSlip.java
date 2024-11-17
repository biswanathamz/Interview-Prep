package DTO;

import lombok.Data;
import Enum.VehicleType;

@Data
public class BookingSlip {
    private int levelNumber;
    private int spotNumber;
    private VehicleType vehicleType;
}
