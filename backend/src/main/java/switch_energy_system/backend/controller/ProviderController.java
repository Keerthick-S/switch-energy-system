package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.pojo.Provider;
import switch_energy_system.backend.service.ProviderService;
import java.util.List;

@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
    public String createProvider(@RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }

    @PutMapping("/enable/{providerName}")
    public String enableProvider(@PathVariable String providerName) {
        return providerService.enableProvider(providerName);
    }

    @PutMapping("/disable/{providerName}")
    public String disableProvider(@PathVariable String providerName) {
        return providerService.disableProvider(providerName);
    }

    @GetMapping
    public List<Provider> getAllProvider() {
        return providerService.getAllProvider();
    }
}
