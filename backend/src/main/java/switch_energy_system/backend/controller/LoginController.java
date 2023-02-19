package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.dto.AuthRequest;
import switch_energy_system.backend.dto.Token;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.repository.UserRepo;
import switch_energy_system.backend.service.JwtService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/authentication")
    public Token authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        User user = userRepo.getUserById(authRequest.getUserName());
        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(authRequest.getUserName());
            return new Token(token, user.getRole(), user.getId());
        }
        else {
            throw new UsernameNotFoundException("Invalid User Name");
        }
    }
}
