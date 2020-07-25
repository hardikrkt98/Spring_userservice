package dev.hardik.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//Hibernate allows to not write native queries but higher level thing like .save to save in database
//JPA is technology allows to save(Persist) the data ,store data somewhere in either Database, or messaging queue. etc.
@SpringBootApplication()
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
