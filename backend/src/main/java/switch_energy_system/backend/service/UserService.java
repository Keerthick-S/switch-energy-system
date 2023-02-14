package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public String createUser(User user) {
        return userRepo.createUser(user);
    }
    public void switchProvider(String smartMeterId, String providerName) {
        userRepo.switchProvider(smartMeterId, providerName);
    }

    public User getUser(long phoneNumber) {
        return userRepo.getUser(phoneNumber);
    }
}
