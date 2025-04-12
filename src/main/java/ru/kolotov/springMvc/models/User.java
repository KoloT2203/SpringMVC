package ru.kolotov.springMvc.models;

public class User {

    private int id;
    private String name;
    private String lastName;
    private int age;

    public User() {}

    public User(int id, String name, String lastName, int age) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
