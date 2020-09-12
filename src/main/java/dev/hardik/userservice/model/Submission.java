package dev.hardik.userservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

enum submission_status{

    SUBMITTED,SUCCESSFUL,FAILED;


}


@Getter
@Setter
@Entity
public class Submission {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column
    private String code;


    @Column
   private  String user_Id;

    @Column
   private  String problem_id;

    @Column
   private String language_id;

    @Column
   private submission_status submission_status;

}
