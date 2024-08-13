package com.courses.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDto {

    private String title;
    private long courseId;
//    private long userId;
    private String description;
    private String category;
    private String duration;
    private long creatorId;
}
