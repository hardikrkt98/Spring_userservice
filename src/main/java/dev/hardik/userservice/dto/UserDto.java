package dev.hardik.userservice.dto;
//DTO stands for data transfer object .Used in case of registration of users to contain only those variabble required for regustration

//DAO is data access object another word for repository


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {


    @NotEmpty
    @Size(min=5)
    private String name;

    @NotEmpty
    @Size(min=1)
    private String email;

    //TODO: Implement Custom Validator
    @NotEmpty
    @Size(min = 6)
    private String password;
}
//Why getter and setter important
//BEhind scenes, spring will receive request
//  userdto = new userdto()
//  userdto.setFullName()
