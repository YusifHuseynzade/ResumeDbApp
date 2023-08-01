package com.company.entity;

public class UserSkill {
    private Integer id; // Integer classı olaraq yazdığımız zaman yerinə null göndərə bilirik.
    private User user;
    private Skill skill;
    private int power;

    public UserSkill(){

    }

    public UserSkill(Integer id, User user, Skill skill, int power){
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public String toString() {
        return  "UserSkill("  + "id= " + id + ", user= " + user + ", user= " + user + ", skill= " + skill + ", power= " + power + ")";
    }
}
