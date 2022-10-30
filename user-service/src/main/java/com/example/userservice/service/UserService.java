package com.example.userservice.service;

import com.example.userservice.constant.ErrorCode;
import com.example.userservice.entity.User;
import com.example.userservice.exception.AppException;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RabbitMqService mqService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user) {
        //getUserById(user.getUserId());
        mqService.sendMessage(user.getEmail());
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return  userRepository.findByUserId(id).orElseThrow(() -> AppException.
                builder()
                .errorCode(ErrorCode.USER_NOT_FOUND)
                .httpStatusCode(400)
                .build());
    }

    public boolean existsUser(int id) {
        return userRepository.existsByUserId(id);
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
