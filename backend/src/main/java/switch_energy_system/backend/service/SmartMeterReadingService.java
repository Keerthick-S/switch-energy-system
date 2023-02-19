package switch_energy_system.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.dto.ReadingRes;
import switch_energy_system.backend.pojo.SmartMeterReading;
import switch_energy_system.backend.repository.SmartMeterReadingRepo;

import javax.management.Query;
import java.util.List;

@Service
public class SmartMeterReadingService {

    @Autowired
    private SmartMeterReadingRepo smartMeterReadingRepo;

    private static final Logger log = LoggerFactory.getLogger(SmartMeterReadingService.class);

    @Scheduled(cron = "1 * * * * *")
    public void storeReading() {
        smartMeterReadingRepo.storeReading();
        log.info("working");
    }

    public void setSmartMeterStatus(String id, boolean status) {
        smartMeterReadingRepo.setSmartMeterStatus(id, status);
    }

    public List<ReadingRes> calculateTotalReading(String smartMeterId) {
        return smartMeterReadingRepo.getTotalReading(smartMeterId);
    }

}
