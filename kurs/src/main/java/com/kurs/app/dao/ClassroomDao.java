package com.kurs.app.dao;

import com.kurs.app.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomDao extends JpaRepository<Classroom, Long> {
}
