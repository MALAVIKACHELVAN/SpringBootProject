package com.example.workspace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
    @Id
    private Integer userid;
    private String name;
    
    private int age;
    private String gender;
    private String phone;
    UserDetails(){

    }
    public UserDetails(Integer userid, String name, int age, String gender, String phone) {
        this.userid = userid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
