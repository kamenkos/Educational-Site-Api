package com.example.EducationSite.repositories;

import com.example.EducationSite.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
