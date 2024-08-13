package com.courses.courses.controller;

import com.courses.courses.dto.AssignDto;
import com.courses.courses.dto.CoursesDto;
import com.courses.courses.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//void enrollCourse(String courseId);
//void addCourse(String userId1, String UserId2);
//boolean deleteCourse(String courseId);
//boolean updateCourse(CoursesDto CoursesDto);
//CoursesDto getCourseByUser(String us


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CourseController {
    private ICourseService iCourseService;
    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody CoursesDto coursesDto)
    {
        iCourseService.addCourse(coursesDto);
        return ResponseEntity.status(HttpStatus.OK).body("created");
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateCourse(@RequestBody CoursesDto coursesDto) {
        boolean isUpdated = iCourseService.updateCourse(coursesDto);
        if (isUpdated) {
            return ResponseEntity.ok("Course updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCourse(@RequestParam(name="courseId") long courseId) {
        boolean isDeleted = iCourseService.deleteCourse(courseId);
        if (isDeleted) {
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
    }

    @GetMapping("/creator/{creatorId}")
    public List<CoursesDto> getCoursesByCreatorId(@PathVariable Long creatorId) {
        return iCourseService.getCoursesByCreatorId(creatorId);
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollCourse(@RequestBody AssignDto assignDto)
    {
        iCourseService.enrollCourse(assignDto);
        return ResponseEntity.status(HttpStatus.OK).body("created");
    }
    @GetMapping("/user/{userId}")
    public List<AssignDto> getCoursesByUserId(@PathVariable Long userId) {
        return iCourseService.getCoursesByUserId(userId);
    }



}
