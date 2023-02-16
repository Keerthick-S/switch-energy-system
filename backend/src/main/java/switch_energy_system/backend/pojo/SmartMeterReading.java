package switch_energy_system.backend.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "smartMeterReading")
@Data
public class SmartMeterReading {
    private String smartMeterId;
    private List<Double> reading;
    private LocalTime time;
    private LocalDate date;
    private boolean enrollStatus;

    public SmartMeterReading(String smartMeterId) {
        this.smartMeterId = smartMeterId;
        this.reading = new ArrayList<>();
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.enrollStatus = true;
    }
}