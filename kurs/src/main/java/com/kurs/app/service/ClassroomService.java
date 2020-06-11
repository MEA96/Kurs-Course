package com.kurs.app.service;

import com.kurs.app.dao.ClassroomDao;
import com.kurs.app.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomDao classroomDao;

    public List<Classroom> listAll() {
        return classroomDao.findAll();
    }

    public void save(Classroom classroom) {
        classroomDao.save(classroom);
    }

    public void delete(long id) {
        classroomDao.deleteById(id);
    }

    public Classroom get(long id) {
        return classroomDao.findById(id).get();
    }

}
