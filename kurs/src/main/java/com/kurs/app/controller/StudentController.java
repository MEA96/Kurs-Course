package com.kurs.app.controller;


import com.kurs.app.model.Student;
import com.kurs.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("")
    public String viewStudent(Model model) {
        List<Student> studentList = studentService.listAll();
        model.addAttribute("studentList", studentList);
        return "student/index";
    }

    @GetMapping(value = "/savestudent")
    public String getStudentSave(@ModelAttribute("student") Student student) {
        return "student/create";
    }

    @PostMapping(value = "/savestudent")
    public String postStudentSave(@ModelAttribute @Valid Student student) {
        student.setAylik(student.getKayittutar() / student.getTaksitsayisi());
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping(value = "/updatestudent/{id}")
    public String getUpdateStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.get(id);
        model.addAttribute("update", student);
        return "student/edit";
    }

    @GetMapping(value = "/detailstudent/{id}")
    public String postDetailStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
