package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.dto.Amount;
import switch_energy_system.backend.service.SmartMeterDetailService;

@RestController
@RequestMapping("/smart-meter")
@CrossOrigin("*")
public class SmartMeterDetailController {

    @Autowired
    private SmartMeterDetailService smartMeterDetailService;
    @GetMapping("/view/{smartMeterId}")
    public Amount smartMeterView(@PathVariable String smartMeterId) {
        return smartMeterDetailService.smartMeterView(smartMeterId);
    }
}
