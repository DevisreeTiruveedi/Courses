package com.courses.courses.mapper;

import com.courses.courses.dto.CoursesDto;
import com.courses.courses.entity.Courses;

public class CoursesMapper {
    public static Courses mapToCourses(CoursesDto coursesDto, Courses courses){

        courses.setTitle(coursesDto.getTitle());
        courses.setCourseId(coursesDto.getCourseId());
//        courses.setUserId(coursesDto.getUserId());
        courses.setDescription(coursesDto.getDescription());
        courses.setCategory(coursesDto.getCategory());
        courses.setDuration(coursesDto.getDuration());
        courses.setCreatorId(coursesDto.getCreatorId());
        return courses;
    }
    public static CoursesDto mapToCoursesDto(Courses courses, CoursesDto coursesDto){

//        coursesDto.setUserId(courses.getUserId());
        coursesDto.setCourseId(courses.getCourseId());
        coursesDto.setDescription(courses.getDescription());
        coursesDto.setTitle(courses.getTitle());
        coursesDto.setCategory(courses.getCategory());
        coursesDto.setDuration(courses.getDuration());
        coursesDto.setCreatorId(courses.getCreatorId());
        return coursesDto;
    }
}
