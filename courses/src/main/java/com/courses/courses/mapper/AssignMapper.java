package com.courses.courses.mapper;


import com.courses.courses.dto.AssignDto;
import com.courses.courses.dto.CoursesDto;
import com.courses.courses.entity.Assign;
import com.courses.courses.entity.Courses;

public class AssignMapper {
    public static Assign mapToAssign(AssignDto assignDto, Assign assign){
        assign.setCourseId(assignDto.getCourseId());
        assign.setUserId(assignDto.getUserId());
        return assign;

    }
    public static AssignDto mapToAssignDto(Assign assign, AssignDto assignDto){

        assignDto.setCourseId(assign.getCourseId());
        assignDto.setUserId(assign.getUserId());
        return assignDto;
    }

}
