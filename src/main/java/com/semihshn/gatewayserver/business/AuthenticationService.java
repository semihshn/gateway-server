package com.semihshn.gatewayserver.business;

import com.semihshn.gatewayserver.core.security.JwtProvider;
import com.semihshn.gatewayserver.core.security.UserPrincipal;
import com.semihshn.gatewayserver.entities.User;
import com.semihshn.gatewayserver.entities.exception.ExceptionType;
import com.semihshn.gatewayserver.entities.exception.SemAuthenticationException;
import com.semihshn.gatewayserver.entities.exception.SemUserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;

    public String signInAndReturnJWT(User signInRequest) {
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
            );
        } catch (Exception e) {
            throw new SemAuthenticationException(ExceptionType.AUTHENTICATION_ERROR, "Kullanıcı adı veya şifreniz hatalı");
        }

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return jwtProvider.generateToken(userPrincipal);
    }

    public User signUp(User user) {
        if (userService.findByUsername(user.getUsername()).isPresent())
        {
            throw new SemUserAlreadyExistsException(ExceptionType.ALREADY_EXISTS, "Böyle bir kullanıcı zaten mevcut");
        }
        return userService.saveUser(user);
    }

    /*public Object refreshToken(RefreshTokenRequest refreshTokenRequest) {

        return jwtProvider.resolveToken(refreshTokenRequest.getToken());
    }*/
}
