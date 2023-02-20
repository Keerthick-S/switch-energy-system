package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.pojo.Provider;
import switch_energy_system.backend.service.ProviderService;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
    public void createProvider(@RequestBody Provider provider) {
        providerService.createProvider(provider);
    }

    @PutMapping("/enable/{providerName}")
    public void enableProvider(@PathVariable String providerName) {
        providerService.enableProvider(providerName);
    }

    @PutMapping("/disable/{providerName}")
    public void disableProvider(@PathVariable String providerName) {
        providerService.disableProvider(providerName);
    }

    @GetMapping
    public List<Provider> getAllProvider() {
        return providerService.getAllProvider();
    }
    @GetMapping("/enabled")
    public List<Provider> getEnabledProvider() {
        return providerService.getEnabledProvider();
    }
    @PutMapping("/{smartMeterId}/{providerName}")
    public void switchProvider(@PathVariable("providerName") String providerName,
                               @PathVariable("smartMeterId") String smartMeterId) {
        providerService.switchProvider(smartMeterId, providerName);
    }

}
