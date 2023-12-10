package com.example.mulltiplesqldatabase.postgresql.service;

import com.example.mulltiplesqldatabase.postgresql.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentServicePostgresql {

    Student addStudent(Student student);

    void deleteStudent(Long id);

    Student updateStudent(Long id, Student newStudent);

    Student getStudent(Long id);

    List<Student> getAllStudents();

    List<Student> sortStudents(String field);


    Page<Student> pageStudents(int page, int pageSize);

    Page<Student> pageStudentsWithSort(int page, int pageSize, String field);


}
