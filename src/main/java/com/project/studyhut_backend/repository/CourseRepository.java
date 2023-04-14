package com.project.studyhut_backend.repository;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findCoursesByCategories(List<Category> categories);
}
