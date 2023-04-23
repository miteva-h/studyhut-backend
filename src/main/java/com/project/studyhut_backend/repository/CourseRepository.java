package com.project.studyhut_backend.repository;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Query("SELECT c FROM Course c JOIN c.categories cat WHERE cat IN :categories GROUP BY c HAVING COUNT(DISTINCT cat) = :#{#categories.size()}")
    List<Course> findByCategoriesIn(@Param("categories") List<Category> categories);
    List<Course> findAll();
}
