package com.example.demo.model;

public class FootballPlayer {

    private String name;
    private int age;
    private String position;
    private String team;

    public FootballPlayer() {
    }

    public FootballPlayer(String name, int age, String position, String team) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}