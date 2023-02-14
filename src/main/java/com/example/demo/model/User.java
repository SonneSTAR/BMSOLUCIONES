package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String modiEd;
    private boolean isactive;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;


    public User(){

    }

    public User(Integer id, String name, String email, String password, String modiEd, boolean isactive, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.modiEd = modiEd;
        this.isactive = isactive;
        this.phones = phones;
    }

    public User(String name, String email, String password, String modiEd, boolean isactive, List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.modiEd = modiEd;
        this.isactive = isactive;
        this.phones = phones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModiEd() {
        return modiEd;
    }

    public void setModiEd(String modiEd) {
        this.modiEd = modiEd;
    }

    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", modiEd='" + modiEd + '\'' +
                ", isactive=" + isactive +
                ", phones=" + phones +
                '}';
    }
}
