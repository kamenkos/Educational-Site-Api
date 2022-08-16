package com.example.EducationSite.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mark_id;
    private Long student_id;
    private Long course_id;

    /*@Transient
    @ManyToMany(mappedBy = "course")
    private List<Course> listOfCourses;*/

    public Mark() {
    }

    public Mark(Long mark_id, Long student_id, Long course_id) {
        this.mark_id = mark_id;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public Long getMark_id() {
        return mark_id;
    }

    public void setMark_id(Long mark_id) {
        this.mark_id = mark_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    /*public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }*/
}
