package cn.elves.parking.domain.parking;

import cn.elves.parking.domain.parking.command.CheckInCommand;
import cn.elves.parking.domain.parking.command.CheckOutCommand;

import java.time.LocalDateTime;

public class ParkingAgg {

    private String plate;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private Integer totalPaid;

    public void checkIn(CheckInCommand checkInCommand){
        this.setPlate(checkInCommand.getPlate());
        this.setCheckInTime(checkInCommand.getCheckInTime());
    }

    public void checkOut(CheckOutCommand checkOutCommand){
        this.setPlate(checkOutCommand.getPlate());
        this.setCheckOutTime(checkOutCommand.getCheckOutTime());
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Integer totalPaid) {
        this.totalPaid = totalPaid;
    }
}
