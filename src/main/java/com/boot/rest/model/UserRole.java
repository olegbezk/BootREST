package com.boot.rest.model;

import javax.persistence.*;

/**
 * Created by Oleg on 26 Jul 2016.
 */

@Entity
@Table(name = "userRoles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "users",
            joinColumns = @JoinColumn(name = "username" ))
    private User username;

    @Column(name = "role")
    private String role;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user_id=" + user_id +
                ", username=" + username +
                ", role='" + role + '\'' +
                '}';
    }
}
