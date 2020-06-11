package com.kurs.app.service;

import com.kurs.app.dao.TeacherDao;
import com.kurs.app.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> listAll() {
        return teacherDao.findAll();
    }

    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    public Teacher get(long id) {
        return teacherDao.findById(id).get();
    }

    public void delete(long id) {
        teacherDao.deleteById(id);
    }

}
