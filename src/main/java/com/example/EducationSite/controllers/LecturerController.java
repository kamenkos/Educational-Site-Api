package com.example.EducationSite.controllers;

import com.example.EducationSite.models.Lecturer;
import com.example.EducationSite.models.Student;
import com.example.EducationSite.repositories.LecturerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/lecturers")
public class LecturerController {

    @Autowired
    private LecturerRepository lecturerRepository;

    @GetMapping
    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Lecturer getLecturer(@PathVariable Long id) {
        Optional<Lecturer> opt = lecturerRepository.findById(id);

        return opt.orElse(null);

        /*if(opt.isPresent())
            return opt.get();
        else
            return null;*/
    }

    @PostMapping
    public void postLecturer(@RequestBody final Lecturer lecturer) {
        lecturerRepository.saveAndFlush(lecturer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteLecturer(@PathVariable Long id) {
        lecturerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Lecturer updateLecturer(@PathVariable Long id, @RequestBody Lecturer lecturer) {
        Optional<Lecturer> opt = lecturerRepository.findById(id);
        Lecturer existingLecturer;
        if(opt.isPresent()) {
            existingLecturer = opt.get();
            BeanUtils.copyProperties(lecturer, existingLecturer, "lecturer_id");

            return lecturerRepository.saveAndFlush(existingLecturer);
        }
        else
            return null;
    }
}
