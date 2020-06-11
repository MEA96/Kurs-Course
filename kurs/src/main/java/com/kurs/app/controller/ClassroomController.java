package com.kurs.app.controller;

import com.kurs.app.model.Classroom;
import com.kurs.app.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @RequestMapping("/classindex")
    public String classIndex(Model model) {
        List<Classroom> classroomList = classroomService.listAll();
        model.addAttribute("classroomList", classroomList);
        return "classroom/index";
    }

    @GetMapping(value = "/saveClass")
    public String getSaveTeacher(@ModelAttribute("classroom") Classroom classroom) {
        return "classroom/create";
    }

    @PostMapping(value = "/saveClass")
    public String postSaveTeacher(@ModelAttribute Classroom classroom) {
        classroomService.save(classroom);
        return "redirect:/classindex";
    }

    @GetMapping(value = "/updateClassroom/{id}")
    public String getUpdateStudent(@PathVariable("id") Long id, Model model) {
        Classroom classroom = classroomService.get(id);
        model.addAttribute("update", classroom);
        return "classroom/edit";
    }

    @GetMapping(value = "/deleteClassroom/{id}")
    public String deleteClassroom(@PathVariable("id") Long id) {
        classroomService.delete(id);
        return "redirect:/classindex";
    }

}
