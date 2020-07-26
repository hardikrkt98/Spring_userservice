package dev.hardik.userservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;



@Getter
@Setter
@Entity
public class VerificationToken {

    private static final int VALIDITY_TIME = 4*60;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class)
    private  User user;

    private Date expiryTime;

    public VerificationToken() {
    }

    public VerificationToken(User user) {

        String  token = generateRandomToken();
      this.token = token;
        this.user =  user;
        this.expiryTime  = calculateexpiryTime();


    }

    public void updateToken()
    {
        //TODO:UPDATE token


    }


    private  String generateRandomToken()
    {
        return UUID.randomUUID().toString();


    }
    private Date calculateexpiryTime()
    {

        Calendar calendar  = Calendar.getInstance();
        Date currentTimeDate = new Date();

        calendar.setTimeInMillis(currentTimeDate.getTime());
        calendar.add(Calendar.MINUTE,VALIDITY_TIME);
        return calendar.getTime();



    }

}
