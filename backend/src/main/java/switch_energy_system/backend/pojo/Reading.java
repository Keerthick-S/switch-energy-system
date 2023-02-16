package switch_energy_system.backend.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class Reading {
    private double reading;
    private LocalDateTime timeAndDate;
    public Reading(double reading) {
        this.reading = reading;
        this.timeAndDate = LocalDateTime.now();
    }
}