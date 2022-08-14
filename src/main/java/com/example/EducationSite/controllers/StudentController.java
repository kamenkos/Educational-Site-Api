package com.example.EducationSite.controllers;

import com.example.EducationSite.models.Student;
import com.example.EducationSite.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        Optional<Student> opt = studentRepository.findById(id);

        return opt.orElse(null);

        /*if(opt.isPresent())
            return opt.get();
        else
            return null;*/
    }

    @PostMapping
    public Student postStudent(@RequestBody final Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> opt = studentRepository.findById(id);
        Student existingStudent;
        if(opt.isPresent()) {
            existingStudent = opt.get();
            BeanUtils.copyProperties(student, existingStudent, "student_id");

            return studentRepository.saveAndFlush(existingStudent);
        }
        else return null;
    }

}
