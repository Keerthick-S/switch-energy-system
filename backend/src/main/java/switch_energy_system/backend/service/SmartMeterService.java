package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.pojo.Provider;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.repository.ProviderRepo;
import switch_energy_system.backend.repository.SmartMeterRepo;
import switch_energy_system.backend.repository.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmartMeterService {
    @Autowired
    private SmartMeterRepo smartMeterRepo;

    @Autowired
    private ProviderRepo providerRepo;

    @Autowired
    private SmartMeterReadingService smartMeterReadingService;

    @Autowired
    @Lazy
    private UserRepo userRepo;

    public void disabledSmartMeter(String smartMeterId) {
        smartMeterRepo.disabledSmartMeter(smartMeterId);
        smartMeterReadingService.setSmartMeterStatus(smartMeterId, false);
    }

    public void newSmartMeter(String userId, String name) {
        smartMeterRepo.newSmartMeter(userId, getEnableProviderName(), name);
    }

    public String getEnableProviderName() {
        return providerRepo.allProvider().stream().filter(Provider::isEnable).collect(Collectors.toList()).get(0).getName();
    }

    public void switchSmartMeter(String providerName) {
        smartMeterRepo.switchSmartMeter(providerName, getEnableProviderName());
    }

    public List<SmartMeter> getPendingSmartMeters() {
        return smartMeterRepo.getPendingSmartMeters();
    }

    public void setSmartMeterStatus(String id , String status) {
        smartMeterRepo.setSmartMeterStatus(id , status);
        smartMeterReadingService.setSmartMeterStatus(id, false);
    }
    public List<SmartMeter> getUserSmartMeter(String userId) {
        return smartMeterRepo.getUserSmartMeter(userId);
    }
    public void createSmartMeter(SmartMeter smartMeter) {
        smartMeterRepo.newSmartMeter(smartMeter.getUserId(), smartMeter.getProvider(), smartMeter.getUserName());
    }

}
