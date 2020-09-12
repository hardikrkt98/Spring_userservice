package dev.hardik.userservice.Service;

import dev.hardik.userservice.dto.UserDto;
import dev.hardik.userservice.event.SuccessfulRegistrationEvent;
import dev.hardik.userservice.model.User;
import dev.hardik.userservice.model.VerificationToken;
import dev.hardik.userservice.repository.UserRepository;
import dev.hardik.userservice.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements    UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

//    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

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
         user.setPassword(userDto.getPassword());//encrypt the password
        User savedUser = userRepository.save(user);

        applicationEventPublisher.publishEvent(
                new SuccessfulRegistrationEvent(savedUser)
        );
        //TODO:Send email to user and allocate resources to user.
         //should be another class why? if otp registration fails entire process will fail , including return user.We don't want that.
        return savedUser;




    }

    @Override
    public User validateUser(String token) {
        //TODO: CHeck token repo if there is that token
        //TODO: if it exists- > check if ti is for some user
        //TODO: check if it is not expired yet
        //if not expired return verified user
        VerificationToken verificationToken =  verificationTokenRepository.findByToken(token);
        //else return null

        if(verificationToken==null)
        {


            return null;

        }

       if(verificationToken.getExpiryTime().getTime()-new Date().getTime()>0)
       {
           User verifiedUser = verificationToken.getUser();
           verifiedUser.setActive(true);
           userRepository.save(verifiedUser);
           verificationTokenRepository.deleteByToken(verificationToken.getToken());
           return  verifiedUser;
           //token has not expired

       }
       else
           return null;



    }
}
