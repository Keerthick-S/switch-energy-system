package switch_energy_system.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.repository.SmartMeterReadingRepo;

@Service
public class SmartMeterReadingService {

    @Autowired
    private SmartMeterReadingRepo smartMeterReadingRepo;

    private static final Logger log = LoggerFactory.getLogger(SmartMeterReadingService.class);

    @Scheduled(fixedRate = 5000)
    public void storeReading() {
       log.info("hii");
    }
}
