package com.itlize.springsecurityjwt.controller;

import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import com.itlize.springsecurityjwt.models.AuthenticationResponse;
import com.itlize.springsecurityjwt.service.MyUserDetailsService;
import com.itlize.springsecurityjwt.service.userServiceImpl.UserServiceImpl;
import com.itlize.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloworldController {


        @Autowired
        private AuthenticationManager authenticaitonManager;

        @Autowired
        private JwtUtil jwtTokenUtil;

        @Autowired
        private MyUserDetailsService userDetailsService;

        @Autowired
        private UserServiceImpl userService;

        @GetMapping( "/hello" )
        public String firstPage() {
            return "Hello World";
        }

        @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

            try {
                authenticaitonManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
                );
            }
            catch (BadCredentialsException e) {
                throw new Exception("Incorrect username or password", e);
            }


            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }

	@PostMapping("/signUp")
    public ResponseEntity createUser(@RequestBody AuthenticationRequest useDetail){
            System.out.println("SYs");
        userService.create(useDetail);
        return ResponseEntity.ok("User is created!!");
    }


}
