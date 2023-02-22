package com.example.pizzaapp.service;

import com.example.pizzaapp.model.User;
import com.example.pizzaapp.model.dto.RegisterDto;
import com.example.pizzaapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private ModelMapper mapper;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(ModelMapper mapper,
                       PasswordEncoder passwordEncoder,
                       UserRepository userRepository) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void register(RegisterDto dto) {
        User newUser = mapper.map(dto, User.class);
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(newUser);
    }
}
