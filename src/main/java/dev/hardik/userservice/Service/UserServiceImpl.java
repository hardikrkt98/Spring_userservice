package dev.hardik.userservice.Service;

import dev.hardik.userservice.dto.UserDto;
import dev.hardik.userservice.model.User;
import dev.hardik.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserDto userDto) {
         if(userRepository.findByEmail(userDto.getEmail())!=null)
         {
              //TODO:THROW exception

         }
         User user = new User();
         user.setEmail(userDto.getEmail());
         user.setFullName(userDto.getName());
         user.setActive(true);
         user.setPassword(passwordEncoder.encode((userDto.getPassword())));//encrypt the password
        User savedUser = userRepository.save(user);
        return savedUser;




    }
}
