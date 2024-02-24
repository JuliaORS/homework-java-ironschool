package org;

import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;
    private static int idCounter = 1;

    // Constructor
    public Student(String name, String address, String email) {
        assignStudentId();
        setName(name);
        setAddress(address);
        setEmail(email);
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Helpers
    private void assignStudentId() {
        this.studentId = "S" + String.valueOf(idCounter++);
    }

    public void getInfo() {
        System.out.println("Student - ID: " + this.studentId + " | Name: " + getName() + " | Address: " + getAddress() + " | Email: " + getEmail());
    }
}