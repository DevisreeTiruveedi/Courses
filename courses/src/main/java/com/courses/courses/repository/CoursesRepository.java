package com.courses.courses.repository;

import com.courses.courses.entity.Courses;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

    Optional<Courses> findByCourseId(long courseId);

    List<Courses> findByCreatorId(Long creatorId);

}
