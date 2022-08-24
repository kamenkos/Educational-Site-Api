package com.example.EducationSite.controllers;

import com.example.EducationSite.models.Course;
import com.example.EducationSite.models.Lecturer;
import com.example.EducationSite.repositories.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Course getCourse(@PathVariable Long id){
        Optional<Course> opt = courseRepository.findById(id);

        return opt.orElse(null);

        /*if (opt.isPresent())
            return opt.get();
        else
            return null;*/
    }

    @PostMapping
    public Course postCourse(@RequestBody final Course course){
        return courseRepository.saveAndFlush(course);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Optional<Course> opt = courseRepository.findById(id);
        Course existingCourse;
        if(opt.isPresent()) {
            existingCourse = opt.get();
            BeanUtils.copyProperties(course, existingCourse, "course_id");

            return courseRepository.saveAndFlush(existingCourse);
        }
        else
            return null;
    }
}
