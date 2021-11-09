package com.m4u.estude.service;

import com.m4u.estude.dto.user.UserPostRequestBody;
import com.m4u.estude.dto.user.UserPutRequestBody;
import com.m4u.estude.exception.badRequest.BadRequestException;
import com.m4u.estude.model.User;
import com.m4u.estude.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
//        User user = User.builder()
//                .username(userDTO.getUsername())
//                .password(userDTO.getPassword())
//                .student(userDTO.getStudent())
//                .build();
        return userRepository.save(user);
    }

    public User findByIdOrThrowBadRequestException(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Users not found"));
    }

    public void delete(Long id){
        userRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public User update(Long id, UserPutRequestBody userDto){
        User userSaved = findByIdOrThrowBadRequestException(id);

        User user = User.builder()
                .id(userSaved.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();

        return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }
}