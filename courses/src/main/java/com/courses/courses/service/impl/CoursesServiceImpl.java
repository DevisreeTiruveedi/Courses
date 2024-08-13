package com.courses.courses.service.impl;

import com.courses.courses.dto.AssignDto;
import com.courses.courses.dto.CoursesDto;
import com.courses.courses.entity.Assign;
import com.courses.courses.entity.Courses;
import com.courses.courses.exceptions.ResourceNotFoundException;
import com.courses.courses.mapper.AssignMapper;
import com.courses.courses.mapper.CoursesMapper;
import com.courses.courses.repository.AssignRepository;
import com.courses.courses.repository.CoursesRepository;
import com.courses.courses.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CoursesServiceImpl implements ICourseService{
    private AssignRepository assignRepository;
    private CoursesRepository coursesRepository;

    @Override
    public void addCourse(CoursesDto coursesDto) {

        Courses courses = CoursesMapper.mapToCourses(coursesDto,new Courses());
        coursesRepository.save(courses);

//        Assign assign=createNewAssign(courses.getCourseId(),courses.getCourseId());
//        assignRepository.save(assign);
        
    }
//    private Assign createNewAssign(long courseId,long userId) {
//        Assign assign=new Assign();
//        assign.setCourseId(courseId);
//        assign.setUserId(userId);
//        return assign;
//
//    }
    @Override
    public boolean deleteCourse(long courseId) {
        boolean isDeleted = false;

        Courses course = coursesRepository.findByCourseId(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course", "Course ID", courseId)
        );

        if (course != null) {
//            assignRepository.deleteByCourseId(courseId);
            coursesRepository.delete(course);
            isDeleted = true;
        }

        return isDeleted;
    }


    @Override
    public boolean updateCourse(CoursesDto coursesDto) {
        boolean isUpdated = false;

        Courses course = coursesRepository.findById(coursesDto.getCourseId()).orElseThrow(
                () -> new ResourceNotFoundException("Course", "Course ID", coursesDto.getCourseId())
        );

        if (course != null) {
            CoursesMapper.mapToCourses(coursesDto, course);

            coursesRepository.save(course);

//            Assign assign = assignRepository.findByCourseId(course.getCourseId()).orElseThrow(
//                    () -> new ResourceNotFoundException("Assign", "Course ID", course.getCourseId())
//            );
//
//            // Assuming you might want to update some assignment details based on coursesDto
//            Assign updatedAssign = AssignMapper.mapToAssign(new AssignDto(), assign);
//
//            assignRepository.save(updatedAssign);
            isUpdated = true;
        }

        return isUpdated;
    }



    @Override
    public List<CoursesDto> getCoursesByCreatorId(long creatorId) {
        List<Courses> courses = coursesRepository.findByCreatorId(creatorId);
        return courses.stream()
                .map(course -> CoursesMapper.mapToCoursesDto(course, new CoursesDto()))
                .collect(Collectors.toList());
    }

    @Override
    public void enrollCourse(AssignDto assignDto)
    {

        Courses courses = coursesRepository.findByCourseId(assignDto.getCourseId()).orElseThrow(
                () -> new ResourceNotFoundException("Course", "Course ID", assignDto.getCourseId())
        );

        if (courses != null) {
            Assign assign=AssignMapper.mapToAssign(assignDto,new Assign());
            assignRepository.save(assign);
        }

    }
    @Override
    public List<AssignDto> getCoursesByUserId(long userId) {
        List<Assign> assign = assignRepository.findByUserId(userId);
        return assign.stream()
                .map(assigns -> AssignMapper.mapToAssignDto(assigns, new AssignDto()))
                .collect(Collectors.toList());
    }

}


