package com.kurs.app.controller;

import com.kurs.app.model.Teacher;
import com.kurs.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/teacherindex")
    public String viewTeacher(Model model) {
        List<Teacher> teacherList = teacherService.listAll();
        model.addAttribute("teacherList", teacherList);
        return "teacher/index";
    }

    @GetMapping(value = "/saveteacher")
    public String getSaveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        return "teacher/create";
    }

    @PostMapping(value = "/saveteacher")
    public String postSaveTeacher(@ModelAttribute Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teacherindex";
    }

    @GetMapping(value = "/updateteacher/{id}")
    public String getUpdateStudent(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.get(id);
        model.addAttribute("update", teacher);
        return "teacher/edit";
    }

    @GetMapping(value = "/detailteacher/{id}")
    public String postDetailStudent(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.get(id);
        model.addAttribute("teacher", teacher);
        return "teacher/detail";
    }

    @GetMapping(value = "/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return "redirect:/teacherindex";
    }
}
