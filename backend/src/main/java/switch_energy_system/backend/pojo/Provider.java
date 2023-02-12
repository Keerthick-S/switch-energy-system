package switch_energy_system.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "provider")
@NoArgsConstructor
@Data
public class Provider {
    @Id
    private String id;
    private String name;
    private double rate;
    private boolean isEnable;

    public Provider(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }
}
