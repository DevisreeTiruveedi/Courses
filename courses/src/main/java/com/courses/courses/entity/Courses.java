package com.courses.courses.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
//    private long userId;
    private String title;
    private String description;
    private String category;
    private String duration;
    private long creatorId;

//    public Long getUserId() {
//        return userId;
//    }
//
//    public Long getCourseId() {
//        return courseID;
//    }
}
