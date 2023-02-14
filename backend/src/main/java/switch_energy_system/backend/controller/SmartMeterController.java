package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.service.SmartMeterService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("smart-meter")
public class SmartMeterController {
    @Autowired
    SmartMeterService smartMeterService;
    @PutMapping("/{userId}/disabled")
    public String disabledSmartMeter(@PathVariable String userId) {
        return smartMeterService.disabledSmartMeter(userId);
    }

    @GetMapping("/pending-request")
    public List<SmartMeter> getPendingSmartMeters() {
        return smartMeterService.getPendingSmartMeters();
    }

    @PutMapping("/{id}/{status}")
    public void smartMeterSetStatus(@PathVariable("id") String id,
                                    @PathVariable("status") String status) {
        smartMeterService.smartMeterSetStatus(id, status);
    }

    @GetMapping("/{userId}")
    public List<SmartMeter> getUserSmartMeter(@PathVariable String userId) {
        return smartMeterService.getUserSmartMeter(userId);
    }

    @PostMapping
    public void createSmartMeter(@RequestBody SmartMeter smartMeter) {
        smartMeterService.createSmartMeter(smartMeter);
    }
}
