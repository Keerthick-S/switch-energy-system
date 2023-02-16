package switch_energy_system.backend.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class Reading {
    private double reading;
    private LocalTime time;
    private LocalDate date;

    public Reading(double reading) {
        this.reading = reading;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }
}