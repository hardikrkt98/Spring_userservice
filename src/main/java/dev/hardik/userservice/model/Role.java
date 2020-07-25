package dev.hardik.userservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
                                           inverseJoinColumns = @JoinColumn (name = "permission_id",referencedColumnName = "id"))
    private List<Permissions> permissions;


    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
   private List<User> users;



}
