package com.kurs.app.service;

import com.kurs.app.dao.StudentClassDao;
import com.kurs.app.model.Classroom;
import com.kurs.app.model.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassDao studentClassDao;

    public List<StudentClass> getStudentClass(Classroom classroom) {
        return studentClassDao.findByClassroom(classroom);
    }

    public List<StudentClass> listAll() {
        return studentClassDao.findAll();
    }

    public void save(StudentClass studentClass) {
        studentClassDao.save(studentClass);
    }

    public StudentClass get(long id) {

        return studentClassDao.findById(id).get();
    }

    public void delete(long id) {
        studentClassDao.deleteById(id);
    }
}
