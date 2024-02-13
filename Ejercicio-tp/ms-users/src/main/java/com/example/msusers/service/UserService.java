package com.example.msusers.service;

import com.example.msusers.domain.User;
import com.example.msusers.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User findById(String id){
        return userRepository.findById(id);
    }
}
