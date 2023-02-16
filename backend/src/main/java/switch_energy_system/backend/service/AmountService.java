package switch_energy_system.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.dto.ReadingRes;
import switch_energy_system.backend.repository.AmountRepo;
import switch_energy_system.backend.repository.SmartMeterReadingRepo;

import java.util.List;

@Service
public class AmountService {

    private static final Logger log = LoggerFactory.getLogger(SmartMeterReadingService.class);

    @Autowired
    AmountRepo amountRepo;
    @Autowired
    SmartMeterReadingRepo smartMeterReadingRepo;

    public void amountCalculate() {
        smartMeterReadingRepo.getTotalReading();
    }
}
