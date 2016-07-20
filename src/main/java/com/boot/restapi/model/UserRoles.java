package com.boot.restapi.model;

import javax.persistence.*;

/**
 * Created by Oleg on 20 Jul 2016.
 */

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

}
