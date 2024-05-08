package com.example.womansafteyapp;

public class Child {
    private String name;
    private int age;
    private String guardianId;

    public Child() {
        // Default constructor required for Firebase
    }

    public Child(String name, int age, String guardianId) {
        this.name = name;
        this.age = age;
        this.guardianId = guardianId;
    }

    // Getter and setter methods for name, age, and guardianId
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

    public String getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(String guardianId) {
        this.guardianId = guardianId;
    }
}