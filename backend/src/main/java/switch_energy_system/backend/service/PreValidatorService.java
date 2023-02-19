package switch_energy_system.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.repository.UserRepo;

@Service
public class PreValidatorService {

    @Autowired
    private UserRepo userRepo;
    public void checkEmail(String email) throws Exception {
        if(userRepo.getUserById(email) != null) {
            throw new UsernameNotFoundException("This Email is Already Exists");
        }
    }
    public void checkPhoneNumber(long phoneNumber) throws Exception {
        if(userRepo.getUserByPhoneNumber(phoneNumber) != null) {
            throw new UsernameNotFoundException("This PhoneNumber is Already Exists");
        }
    }
}
