package switch_energy_system.backend.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "smart_meter")
@Data
public class SmartMeter {
    @Id
    private String id;
    private String userId;
    private String userName;
    private double reading;
    private LocalTime time;
    private LocalDate date;
    private String enrollStatus;
    private String provider;

    public SmartMeter(String userId, String provider, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.reading = 0;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.enrollStatus = "pending";
        this.provider = provider;
    }
}
