package com.example.demo.user.model;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
