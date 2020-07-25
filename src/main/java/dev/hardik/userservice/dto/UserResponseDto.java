package dev.hardik.userservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

      private Long id;

      private String fullName;

      private String email;

      private  String password;

      private boolean active;

    public UserResponseDto(Long id, String fullName, String email, String password, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.active = active;
    }
}
