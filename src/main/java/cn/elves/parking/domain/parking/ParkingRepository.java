package cn.elves.parking.domain.parking;

public interface ParkingRepository {

    ParkingAgg findLastOneByPlate(String plate);

    ParkingAgg save(ParkingAgg parkingAgg);
}
