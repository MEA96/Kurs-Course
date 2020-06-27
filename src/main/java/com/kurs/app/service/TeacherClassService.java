package com.kurs.app.service;

import com.kurs.app.dao.TeacherClassDao;
import com.kurs.app.model.Classroom;
import com.kurs.app.model.TeacherClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherClassService {

    @Autowired
    private TeacherClassDao teacherClassDao;

    public List<TeacherClass> getTeacherClass(Classroom classroom) {
        return teacherClassDao.findByClassroom(classroom);
    }

    public List<TeacherClass> listAll() {
        return teacherClassDao.findAll();
    }

    public void save(TeacherClass teacherClass) {
        teacherClassDao.save(teacherClass);
    }

    public TeacherClass get(long id) {

        return teacherClassDao.findById(id).get();
    }

    public void delete(long id) {
        teacherClassDao.deleteById(id);
    }
}
