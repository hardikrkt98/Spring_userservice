package dev.hardik.userservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name="problems")
public class Problem {


@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

@Column
@NotNull
private String problem;



@Column
@NotNull
private String title;











}
