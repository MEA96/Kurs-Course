package com.kurs.app.service;

import com.kurs.app.dao.StudentDao;
import com.kurs.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> listAll() {
        return studentDao.findAll();
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public Student get(long id) {
        return studentDao.findById(id).get();
    }

    public void delete(long id) {
        studentDao.deleteById(id);
    }
}
