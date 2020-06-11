package com.kurs.app.controller;

import com.kurs.app.model.Classroom;
import com.kurs.app.model.Teacher;
import com.kurs.app.model.TeacherClass;
import com.kurs.app.service.ClassroomService;
import com.kurs.app.service.TeacherClassService;
import com.kurs.app.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeacherClassController {
    private final TeacherService teacherService;
    private final ClassroomService classroomService;
    private final TeacherClassService teacherClassService;

    public TeacherClassController(TeacherService teacherService, ClassroomService classroomService, TeacherClassService teacherClassService) {
        this.teacherService = teacherService;
        this.classroomService = classroomService;
        this.teacherClassService = teacherClassService;
    }

    @RequestMapping("/TeacherClass/{id}")
    public String TeacherClassList(Model model, @PathVariable(name = "id") long id) {
        TeacherClass teacherClass = new TeacherClass();
        Classroom classroom = new Classroom();
        classroom.setId(id);
        teacherClass.setClassroom(classroom);
        model.addAttribute("teacherClassList", teacherClass);
        List<Teacher> teacherList = teacherService.listAll();
        model.addAttribute("teacherList", teacherList);
        return "teacherclass/TeacherClassList";
    }

    @PostMapping(value = "/saveTeacherClass/{id}")
    public String postsaveTeacherClass(@ModelAttribute("saveTeacherClass") TeacherClass saveTeacherClass, @PathVariable(name = "id") long id, Model model) {
        Classroom classroom = new Classroom();
        classroom.setId(id);
        saveTeacherClass.setClassroom(classroom);
        teacherClassService.save(saveTeacherClass);
        return "redirect:/classindex";
    }

    @GetMapping(value = "/detailTeacherClass/{id}")
    public ModelAndView detailTeacherStudent(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("classroom/teacherdetail");
        Classroom classroom = classroomService.get(id);
        List<TeacherClass> teacherClass = teacherClassService.getTeacherClass(classroom);
        mav.addObject("teacherClass", teacherClass);
        return mav;
    }

    @GetMapping(value = "/deleteTeacherClass/{id}")
    public String deleteTeacherStudent(@PathVariable(name = "id") int id) {
        teacherClassService.delete(id);
        return "redirect:/classindex";
    }

}
