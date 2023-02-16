package switch_energy_system.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableScheduling
public class SwitchEnergySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwitchEnergySystemApplication.class, args);
	}

}
