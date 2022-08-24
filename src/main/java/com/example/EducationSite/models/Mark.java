package com.example.EducationSite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mark_id;
    private int mark;

    public Mark() {
    }

    public Mark(Long mark_id, int mark) {
        this.mark_id = mark_id;
        this.mark = mark;
    }

    public Long getMark_id() {
        return mark_id;
    }

    public void setMark_id(Long mark_id) {
        this.mark_id = mark_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
