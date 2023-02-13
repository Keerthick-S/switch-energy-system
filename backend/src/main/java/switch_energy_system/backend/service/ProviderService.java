package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.pojo.Provider;
import switch_energy_system.backend.repository.ProviderRepo;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepo providerRepo;

    @Autowired
    private SmartMeterService smartMeterService;

    public void createProvider(Provider provider) {
        provider.setEnable(true);
         providerRepo.createProvider(provider);
    }

    public void enableProvider(String providerName) {
        providerRepo.enableDisabledProvider(providerName, true);
    }

    public void disableProvider(String providerName) {
        providerRepo.enableDisabledProvider(providerName, false);
        smartMeterService.switchSmartMeter(providerName);
    }
    public List<Provider> getAllProvider() {
        return providerRepo.allProvider();
    }
}
