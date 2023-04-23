package com.project.studyhut_backend.web;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.dtos.CourseDto;
import com.project.studyhut_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return this.courseService.listAllCourses();
    }



    @PutMapping("/{id}/edit")
    public ResponseEntity<Course> editCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {
        return this.courseService.editCourse(id, courseDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        return this.courseService.deleteCourse(id)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/filter")
    public List<Course> filterByCategories(@RequestBody List<Category> categories) {
        return this.courseService.filterByCategory(categories);
    }
}
