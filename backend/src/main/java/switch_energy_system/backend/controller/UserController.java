package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{smartMeterId}/switch-provider/{providerName}")
    public void switchProvider(@PathVariable("smartMeterId") String smartMeterId,
                                @PathVariable("providerName") String providerName) {
        userService.switchProvider(smartMeterId, providerName);
    }
}
