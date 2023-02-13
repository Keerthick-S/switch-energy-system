package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.pojo.Provider;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.repository.ProviderRepo;
import switch_energy_system.backend.repository.SmartMeterRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmartMeterService {
    @Autowired
    private SmartMeterRepo smartMeterRepo;

    @Autowired
    private ProviderRepo providerRepo;

    public String disabledSmartMeter(String userId) {
        return smartMeterRepo.disabledSmartMeter(userId);
    }

    public void newSmartMeter(String userId, String userName) {
        smartMeterRepo.newSmartMeter(userId, getEnableProviderName(), userName);
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

    public void smartMeterSetStatus(String id , String status) {
        smartMeterRepo.smartMeterSetStatus(id , status);
    }
}