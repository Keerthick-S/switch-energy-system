package switch_energy_system.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Document(collection = "smartMeter")
@Data
public class
SmartMeter {
    private String Id;
    private String smartMeterName;
    private String userId;
    private double reading;
    private LocalTime time;
    private LocalDate date;
    private String enrollStatus;
    private String provider;

    public SmartMeter(String userId, String provider) {
        this.userId = userId;
        this.reading = 0;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.enrollStatus = "pending";
        this.provider = provider;
    }
}
