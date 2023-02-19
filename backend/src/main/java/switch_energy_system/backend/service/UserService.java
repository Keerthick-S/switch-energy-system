package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private PreValidatorService preValidatorService;
    public void createUser(User user) throws Exception {
        preValidatorService.checkEmail(user.getEmail());
        preValidatorService.checkPhoneNumber(user.getPhoneNumber());
        user.setUserName(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("User");
        userRepo.createUser(user);
    }
    public void switchProvider(String smartMeterId, String providerName) {
        userRepo.switchProvider(smartMeterId, providerName);
    }

    public User getUserById(String email) {
        return userRepo.getUserById(email);
    }
}
