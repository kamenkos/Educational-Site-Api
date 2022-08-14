package com.example.EducationSite.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;
    private String first_name;
    private String last_name;
    private String school;
    @Transient
    @ManyToMany(mappedBy = "course")
    private List<Course> listOfCourses;

    public Student(long student_id, String first_name, String last_name, String school) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.school = school;
    }

    public Student() {
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
}
