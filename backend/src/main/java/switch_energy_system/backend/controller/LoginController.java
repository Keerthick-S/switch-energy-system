package switch_energy_system.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import switch_energy_system.backend.dto.AuthRequest;
import switch_energy_system.backend.dto.Token;
import switch_energy_system.backend.service.JwtService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authentication")
    public Token authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(authRequest.getUserName());
            return new Token(token);
        }
        else {
            throw new UsernameNotFoundException("Invalid User Name");
        }

    }
}
