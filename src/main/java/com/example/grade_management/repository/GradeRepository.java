package com.example.grade_management.repository;

import com.example.grade_management.entity.Grade;
import com.example.grade_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Lấy danh sách điểm theo sinh viên
    List<Grade> findByStudent(Student student);
}
