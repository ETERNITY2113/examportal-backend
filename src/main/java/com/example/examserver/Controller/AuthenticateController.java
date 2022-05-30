package com.example.examserver.Controller;

import com.example.examserver.config.JwtUtil;
import com.example.examserver.model.JwtRequest;
import com.example.examserver.model.JwtResponse;
import com.example.examserver.model.User;
import com.example.examserver.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token =  this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception {
        try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e)
        {
            throw new Exception("User Disabled :: "+e.getMessage());
        }catch (BadCredentialsException e)
        {
            throw new Exception("Invalid Credentials :: "+e.getMessage());
        }
    }

    //returns the current logged in user details
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        return   ( (User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}
