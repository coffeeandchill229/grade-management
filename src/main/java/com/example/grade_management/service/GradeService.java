package com.example.grade_management.service;
import com.example.grade_management.entity.Student;

import com.example.grade_management.entity.Grade;
import com.example.grade_management.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    // Lấy tất cả điểm từ database
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    // Lấy điểm theo ID
    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    // Lưu điểm mới hoặc cập nhật điểm
    public Grade saveGrade(Grade grade) {
        System.out.println("DEBUG: Saving grade - ID: " + grade.getId() +
                ", Student: " + grade.getStudentName() +
                ", Subject: " + grade.getSubject() +
                ", Score: " + grade.getScore());
        return gradeRepository.save(grade);
    }

    // Xóa điểm theo ID
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    // Lấy danh sách điểm của một sinh viên theo tên
    public List<Grade> getGradesByStudent(Student student) {
        return gradeRepository.findByStudent(student);
    }
}
