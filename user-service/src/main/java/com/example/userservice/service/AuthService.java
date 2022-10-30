package com.example.userservice.service;

import com.example.userservice.dto.AuthRequest;
import com.example.userservice.dto.AuthResponse;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository authRepository;

    private final JwtUtil jwtUtil;

    public AuthResponse getToken(AuthRequest request){
        User user = authRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("No"));

        if (!isValidPassword(user.getPassword(), request.getPassword())) {
            log.error("User's password not valid " + request.getEmail());
            throw new RuntimeException("No");
        }

        return new AuthResponse(jwtUtil.generateToken(user));
    }

    public static boolean isValidPassword(String password, String password2) {
        return password.equals(password2);
    }
}
