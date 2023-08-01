package com.company.entity;

public class Nationality {
    private int id;
    private String name;

    public Nationality(){

    }

    public Nationality(int id, String name){
        this.id = id;
        this.name = name;
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

    public String toString() {
        return  "Nationality("  + "id= " + id + ", name= " + name + ")";
    }
}
