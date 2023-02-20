package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public void createUser(@RequestBody User user) throws Exception {
        userService.createUser(user);
    }
    @PutMapping("/{smartMeterId}/switch-provider/{providerName}")
    public void switchProvider(@PathVariable("smartMeterId") String smartMeterId,
                                @PathVariable("providerName") String providerName) {
        userService.switchProvider(smartMeterId, providerName);
    }
    @GetMapping("/{email}")
    public User getUserById(@PathVariable String email) {
        return userService.getUserById(email);
    }

    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }
}
