package com.company.bean;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date birthDate;
    private Nationality nationality;
    private List<UserSkill> userSkills;

    public User(){

    }
    public User(int id){
        this.id = id;
    }
    public User(int id, String name, String surname, String phone, String email, Date birthDate, Nationality nationality){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Nationality getNationality() {return nationality;}
    public void setNationality(Nationality nationality) {this.nationality = nationality;}
    public List<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }
    public String toString() {
        return  "User("  + "id= " + id + ", name= " + name + ", surname= " + surname + ", phone= " + phone + ", email= " + email + ", birthday= " + birthDate + ", nationality= " + nationality + ")";
    }
}
