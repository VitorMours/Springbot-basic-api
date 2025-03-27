package com.webserver.diorailway.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name="user_table")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_id")
    private String id;
    @Column(length=50, nullable=false)
    private String name;
    @Column(length=100, nullable=false)
    private String email;
    @Column(length=80, nullable=false)
    private String password;
    @Column(length=10)
    private String phone;


    // Getters and Setters
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

}
