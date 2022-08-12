package com.example.EducationSite.repositories;

import com.example.EducationSite.models.Course;
import com.example.EducationSite.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
}
