package com.example.grade_management.controller;

import com.example.grade_management.entity.Grade;
import com.example.grade_management.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    // Hiển thị danh sách điểm
    @GetMapping
    public String listGrades(Model model) {
        List<Grade> grades = gradeService.getAllGrades();
        model.addAttribute("grades", grades);
        return "grades/list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm mới điểm
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "grades/form";
    }

    // Xử lý thêm hoặc cập nhật điểm
    @PostMapping("/save")
    public String saveGrade(@ModelAttribute Grade grade) {
        gradeService.saveGrade(grade);
        return "redirect:/grades";
    }

    // Hiển thị form chỉnh sửa điểm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Grade grade = gradeService.getGradeById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
        model.addAttribute("grade", grade);
        return "grades/form";
    }

    // Xóa điểm
    @GetMapping("/delete/{id}")
    public String deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return "redirect:/grades";
    }
}
