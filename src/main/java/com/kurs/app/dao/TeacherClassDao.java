package com.kurs.app.dao;

import com.kurs.app.model.Classroom;
import com.kurs.app.model.TeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherClassDao extends JpaRepository<TeacherClass, Long> {
    List<TeacherClass> findByClassroom(Classroom classroom);
}
