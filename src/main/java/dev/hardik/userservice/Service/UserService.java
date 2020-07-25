package dev.hardik.userservice.Service;

import dev.hardik.userservice.dto.UserDto;
import dev.hardik.userservice.model.User;

public interface UserService {

    public User registerUser(UserDto userDto);
}
