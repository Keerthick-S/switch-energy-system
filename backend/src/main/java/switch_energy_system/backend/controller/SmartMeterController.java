package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.service.SmartMeterService;
@RestController
@RequestMapping("smart-meter")
public class SmartMeterController {
    @Autowired
    SmartMeterService smartMeterService;
    @PutMapping("/{userId}/disabled")
    public String disabledSmartMeter(@PathVariable String userId) {
        return smartMeterService.disabledSmartMeter(userId);
    }
}
