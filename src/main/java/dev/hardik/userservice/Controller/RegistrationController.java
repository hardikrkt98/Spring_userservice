package dev.hardik.userservice.Controller;


import dev.hardik.userservice.Service.UserService;
import dev.hardik.userservice.dto.ResponseDto;
import dev.hardik.userservice.dto.UserDto;
import dev.hardik.userservice.dto.UserResponseDto;
import dev.hardik.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//Controller has one on one mapping with service
@RestController   //Why restcontroller . Restcontroller allows to pass JSON like object where as controller expect that to it you will give the name HTML page that u want to view on browser.
public class RegistrationController {

    @Autowired
    private UserService userService;

       @PostMapping("/user/register")
        public ResponseDto<UserResponseDto> registerUser(@RequestBody UserDto userDto)
         {

            User user = userService.registerUser(userDto);
             return new ResponseDto<>(

                     HttpStatus.OK,
                     new UserResponseDto(user.getId(),user.getFullName(),user.getEmail(),userDto.getPassword(),user.getActive())
             );



         }

        @GetMapping("/user/confirm")
         public ResponseDto<UserResponseDto> validateUser(@RequestParam String token)
        {


            userService.validateUser(token);

        }


}
