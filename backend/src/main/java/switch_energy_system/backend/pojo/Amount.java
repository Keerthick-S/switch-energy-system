package switch_energy_system.backend.pojo;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "amount")
@Data
public class Amount {
    private String smartMeterId;
    private double reading;
    private double amount;

    public Amount(String smartMeterId) {
        this.smartMeterId = smartMeterId;
        this.reading = 0;
        this.amount = 0;
    }
}
