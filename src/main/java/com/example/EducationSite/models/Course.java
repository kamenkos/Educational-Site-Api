package com.example.EducationSite.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;
    private String course_name;
    private String course_description;
    private String course_length;
    @Transient
    @ManyToMany
    @JoinTable(
            name = "course_lecturers",
            joinColumns = @JoinColumn(name= "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    List<Lecturer> listOfLecturers;
    @Transient
    @ManyToMany
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name= "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    List<Student> listOfStudents;

    public Course(int course_id, String course_name, String course_description, String course_length) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_length = course_length;
    }

    public Course() {

    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_length() {
        return course_length;
    }

    public void setCourse_length(String course_length) {
        this.course_length = course_length;
    }

    public List<Lecturer> getListOfLecturers() {
        return listOfLecturers;
    }

    public void setListOfLecturers(List<Lecturer> listOfLecturers) {
        this.listOfLecturers = listOfLecturers;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }


}
