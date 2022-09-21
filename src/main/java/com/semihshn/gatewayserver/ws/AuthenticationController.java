package com.semihshn.gatewayserver.ws;

import com.semihshn.gatewayserver.business.AuthenticationService;
import com.semihshn.gatewayserver.business.request.RefreshTokenRequest;
import com.semihshn.gatewayserver.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user)
    {
        return new ResponseEntity<>(authenticationService.signUp(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user)
    {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
