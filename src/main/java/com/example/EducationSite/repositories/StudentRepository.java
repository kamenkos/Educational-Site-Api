package com.example.EducationSite.repositories;

import com.example.EducationSite.models.Course;
import com.example.EducationSite.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
