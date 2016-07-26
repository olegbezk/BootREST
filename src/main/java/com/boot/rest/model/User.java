package com.boot.rest.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg on 26 Jul 2016.
 */

@Entity
@Table(name = "users")
public class User {

    private Set<UserRole> userRole = new HashSet<>(0);

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "userRole=" + userRole +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
