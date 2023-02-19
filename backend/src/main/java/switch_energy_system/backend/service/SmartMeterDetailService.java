package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.dto.Amount;
import switch_energy_system.backend.dto.ReadingRes;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.repository.ProviderRepo;
import switch_energy_system.backend.repository.SmartMeterRepo;

import java.util.List;

@Service
public class SmartMeterDetailService {
    @Autowired
    private SmartMeterReadingService smartMeterReadingService;
    @Autowired
    private SmartMeterRepo smartMeterRepo;

    @Autowired
    private ProviderRepo providerRepo;

    public Amount smartMeterView(String smartMeterId) {
        String providerName = smartMeterRepo.getSmartMeterById(smartMeterId).getProvider();
        double rate = providerRepo.getProviderByName(providerName).getRate();
        double totalReading = smartMeterReadingService.calculateTotalReading(smartMeterId).get(0).getTotalReading();
        double amount = calculateAmount(rate, totalReading);
        return new Amount(totalReading, amount, smartMeterId);
    }

    public double calculateAmount(double rate, double reading) {
            return reading * rate;
    }

}
