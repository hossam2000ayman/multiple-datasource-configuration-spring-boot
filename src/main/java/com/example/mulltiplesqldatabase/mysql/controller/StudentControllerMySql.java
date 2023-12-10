package com.example.mulltiplesqldatabase.mysql.controller;

import com.example.mulltiplesqldatabase.mysql.service.StudentServiceMySql;
import com.example.mulltiplesqldatabase.mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentControllerMySql {

    @Autowired
    private StudentServiceMySql studentServiceMySql;

    @PostMapping("addStudentMySql")
    Student addStudent(@RequestBody Student student) {
        return studentServiceMySql.addStudent(student);
    }

    @DeleteMapping("deleteStudentMySql/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentServiceMySql.deleteStudent(id);
    }

    @PutMapping("updateStudentMySql/{id}")
    Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        return studentServiceMySql.updateStudent(id, newStudent);
    }

    @GetMapping("getStudentMySql/{id}")
    Student getStudent(@PathVariable Long id) {
        return studentServiceMySql.getStudent(id);
    }

    @GetMapping("getAllStudentsMySql")
    List<Student> getAllStudents() {
        return studentServiceMySql.getAllStudents();
    }

    @GetMapping("sortStudentsMySql")
    List<Student> sortStudents(@RequestParam String field) {
        return studentServiceMySql.sortStudents(field);
    }


    @GetMapping("pageStudentsMySql")
    Page<Student> pageStudents(@RequestParam int page, @RequestParam int pageSize) {
        return studentServiceMySql.pageStudents(page, pageSize);
    }

    @GetMapping("pageStudentsWithSortMySql")
    Page<Student> pageStudentsWithSort(@RequestParam int page, @RequestParam int pageSize, @RequestParam String field) {
        return studentServiceMySql.pageStudentsWithSort(page, pageSize, field);
    }
}
