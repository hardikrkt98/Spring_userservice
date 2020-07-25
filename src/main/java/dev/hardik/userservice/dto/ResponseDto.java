package dev.hardik.userservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class ResponseDto<T> {

     private T data;

     private HttpStatus httpStatus;

     public ResponseDto(HttpStatus httpStatus,T data)
     {
         this.data = data;
         this.httpStatus = httpStatus;

     }


}
