package com.projekt.services;

import com.projekt.models.User;
import com.projekt.payload.request.*;
import com.projekt.payload.request.add.AddUserRequest;
import com.projekt.payload.request.edit.EditProfileDetailsRequest;
import com.projekt.payload.request.edit.EditUserRequest;
import com.projekt.payload.response.LoginResponse;
import com.projekt.payload.response.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    User findUserByUsername(String name);

    List<UserDetails> loadAll();

    boolean exists(Long id);

    UserDetails loadById(Long id);

    void editUser(EditUserRequest request) throws Exception;

    void delete(Long id);

    void activate(Long userID);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void register(RegisterRequest request) throws MessagingException;

    LoginResponse authenticate(LoginRequest request);

    com.projekt.payload.response.UserDetails getUserDetails(String name);

    void updateProfile(EditProfileDetailsRequest request);

    boolean isActive(Long userID);

    void addUser(AddUserRequest request);
}
