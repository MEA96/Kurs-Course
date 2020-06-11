package com.kurs.app.dao;

import com.kurs.app.model.Classroom;
import com.kurs.app.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentClassDao extends JpaRepository<StudentClass, Long> {
    List<StudentClass> findByClassroom(Classroom classroom);
}
