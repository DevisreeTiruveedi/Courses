package com.courses.courses.repository;
import com.courses.courses.entity.Assign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface AssignRepository extends JpaRepository<Assign, Long> {
    void deleteByCourseId(long courseId);
    Optional<Assign> findByCourseId(long courseId);
    List<Assign> findByUserId(long userId);
}
