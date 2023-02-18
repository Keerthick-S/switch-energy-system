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
    @PutMapping("/{smartMeterId}/disabled")
    public void disabledSmartMeter(@PathVariable String smartMeterId) {
        smartMeterService.disabledSmartMeter(smartMeterId);
    }

    @GetMapping("/pending-request")
    public List<SmartMeter> getPendingSmartMeters() {
        return smartMeterService.getPendingSmartMeters();
    }

    @PutMapping("/approved/{id}")
    public void smartMeterSetApprovedStatus(@PathVariable("id") String id) {
        smartMeterService.setSmartMeterStatus(id, "approved");
    }

    @PutMapping("/rejected/{id}")
    public void smartMeterSetRejectStatus(@PathVariable("id") String id) {
        smartMeterService.setSmartMeterStatus(id, "rejected");
    }

    @GetMapping("/{email}")
    public List<SmartMeter> getUserSmartMeter(@PathVariable String email) {
        return smartMeterService.getUserSmartMeter(email);
    }
    @PostMapping
    public void createSmartMeter(@RequestBody SmartMeter smartMeter) {
        smartMeterService.createSmartMeter(smartMeter);
    }
    @PutMapping("/switch-provider/{providerName}/{smartMeterId}")
    public void switchProvider(@PathVariable("providerName") String providerName,
                               @PathVariable("smartMeterId") String smartMeterId) {
        smartMeterService.switchProvider(smartMeterId, providerName);
    }
}
