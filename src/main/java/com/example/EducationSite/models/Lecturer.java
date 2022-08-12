package com.example.EducationSite.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lecturer_id;
    private String first_name;
    private String last_name;
    @Transient
    @ManyToMany(mappedBy = "course")
    List<Course> listOfCourses;

    public Lecturer(long lecturer_id, String first_name, String last_name) {
        this.lecturer_id = lecturer_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Lecturer() {

    }

    public long getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(long lecturer_id) {
        this.lecturer_id = lecturer_id;
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

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
}
