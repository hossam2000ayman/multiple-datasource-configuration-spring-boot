package com.example.mulltiplesqldatabase.postgresql.controller;

import com.example.mulltiplesqldatabase.postgresql.model.Student;
import com.example.mulltiplesqldatabase.postgresql.service.StudentServicePostgresql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentControllerPostgresql {

    @Autowired
    private StudentServicePostgresql studentServicePostgresql;

    @PostMapping("addStudentPostgresql")
    Student addStudent(@RequestBody Student student) {
        return studentServicePostgresql.addStudent(student);
    }

    @DeleteMapping("deleteStudentPostgresql/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentServicePostgresql.deleteStudent(id);
    }

    @PutMapping("updateStudentPostgresql/{id}")
    Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        return studentServicePostgresql.updateStudent(id, newStudent);
    }

    @GetMapping("getStudentPostgresql/{id}")
    Student getStudent(@PathVariable Long id) {
        return studentServicePostgresql.getStudent(id);
    }

    @GetMapping("getAllStudentsPostgresql")
    List<Student> getAllStudents() {
        return studentServicePostgresql.getAllStudents();
    }

    @GetMapping("sortStudentsPostgresql")
    List<Student> sortStudents(@RequestParam String field) {
        return studentServicePostgresql.sortStudents(field);
    }


    @GetMapping("pageStudentsPostgresql")
    Page<Student> pageStudents(@RequestParam int page, @RequestParam int pageSize) {
        return studentServicePostgresql.pageStudents(page, pageSize);
    }

    @GetMapping("pageStudentsWithSortPostgresql")
    Page<Student> pageStudentsWithSort(@RequestParam int page, @RequestParam int pageSize, @RequestParam String field) {
        return studentServicePostgresql.pageStudentsWithSort(page, pageSize, field);
    }
}
