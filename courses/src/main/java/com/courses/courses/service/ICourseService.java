package com.courses.courses.service;

import com.courses.courses.dto.AssignDto;
import com.courses.courses.dto.CoursesDto;

import java.util.List;

public interface ICourseService {
      List<CoursesDto> getCoursesByCreatorId(long creatorId);

      void enrollCourse(AssignDto assignDto);
      void addCourse(CoursesDto coursesDto);
      boolean deleteCourse(long courseId);
      boolean updateCourse(CoursesDto CoursesDto);
//      List<CoursesDto> getCoursesByCreatorId(long creatorId);

      List<AssignDto> getCoursesByUserId(long userId);

}
