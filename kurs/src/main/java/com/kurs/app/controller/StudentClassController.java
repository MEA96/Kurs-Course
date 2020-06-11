package com.kurs.app.controller;

import com.kurs.app.model.*;
import com.kurs.app.service.*;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentClassController {
    private final StudentService studentService;
    private final ClassroomService classroomService;
    private final StudentClassService studentClassService;

    public StudentClassController(StudentService studentService, ClassroomService classroomService, StudentClassService studentClassService) {
        this.studentService = studentService;
        this.classroomService = classroomService;
        this.studentClassService = studentClassService;
    }

    @RestController
    public class IndexController implements ErrorController {
        private static final String PATH = "/error";

        @RequestMapping(value = PATH)
        public String error() {
            return "Hatalı İşlem Denemesi";
        }

        @Override
        public String getErrorPath() {
            return PATH;
        }
    }

    @RequestMapping("/StudentClass/{id}")
    public String StudentClassList(Model model, @PathVariable(name = "id") long id) {
        StudentClass studentClass = new StudentClass();
        Classroom classroom = new Classroom();
        classroom.setId(id);
        studentClass.setClassroom(classroom);
        model.addAttribute("studentClassList", studentClass);
        List<Student> studentList = studentService.listAll();
        model.addAttribute("studentList", studentList);
        return "studentclass/StudentClassList";
    }

    @PostMapping(value = "/saveStudentClass/{id}")
    public String postsaveStudentClass(@ModelAttribute("saveStudentClass") StudentClass saveStudentClass, @PathVariable(name = "id") long id, Model model) {
        Classroom classroom = new Classroom();
        classroom.setId(id);
        saveStudentClass.setClassroom(classroom);
        studentClassService.save(saveStudentClass);
        return "redirect:/classindex";
    }

    @GetMapping(value = "/detailStudentClass/{id}")
    public ModelAndView detailStudentClass(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("classroom/studentdetail");
        Classroom classroom = classroomService.get(id);
        List<StudentClass> studentClasses = studentClassService.getStudentClass(classroom);
        mav.addObject("studentClasses", studentClasses);
        return mav;
    }

    @GetMapping(value = "/deleteStudentClass/{id}")
    public String deleteStudentClass(@PathVariable(name = "id") int id) {
        studentClassService.delete(id);
        return "redirect:/";
    }

}
