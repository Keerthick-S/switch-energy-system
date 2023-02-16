package switch_energy_system.backend.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "smart_meter_reading")
@Data
public class SmartMeterReading {
    private String smartMeterId;
    private boolean enrollStatus;
    private List<Reading> electricityReading;

    public SmartMeterReading(String smartMeterId) {
        this.smartMeterId = smartMeterId;
        this.enrollStatus = true;
        this.electricityReading = new ArrayList<>();
    }
}