package com.example.mulltiplesqldatabase.mysql.service.serviceImplementation;

import com.example.mulltiplesqldatabase.mysql.repository.StudentRepositoryMySql;
import com.example.mulltiplesqldatabase.mysql.service.StudentServiceMySql;
import com.example.mulltiplesqldatabase.mysql.model.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementationMysql implements StudentServiceMySql {

    @Autowired
    private StudentRepositoryMySql studentRepositoryMySql;

    @Override
    public Student addStudent(Student student) {
        return studentRepositoryMySql.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepositoryMySql.findById(id);
        if (studentOptional.isEmpty())
            throw new EntityNotFoundException("Student not found");
        studentRepositoryMySql.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        Optional<Student> studentOptional = studentRepositoryMySql.findById(id);
        if (studentOptional.isEmpty())
            throw new EntityNotFoundException("Student not found");
        Student student = studentOptional.get();
        student.setAddress(newStudent.getAddress());
        student.setCity(newStudent.getCity());
        student.setGpa(newStudent.getGpa());
        student.setEmail(newStudent.getEmail());
        student.setDateOfBirth(newStudent.getDateOfBirth());
        student.setName(newStudent.getName());
        return studentRepositoryMySql.saveAndFlush(student);
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> studentOptional = studentRepositoryMySql.findById(id);
        if (studentOptional.isEmpty())
            throw new EntityNotFoundException("Student not found");
        return studentOptional.get();
    }

    @Override
    public Page<Student> pageStudents(int page, int pageSize) {
        return studentRepositoryMySql.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Student> pageStudentsWithSort(int page, int pageSize, String field) {
        return studentRepositoryMySql.findAll(PageRequest.of(page,pageSize).withSort(Sort.by(field).ascending()));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepositoryMySql.findAll();
    }

    @Override
    public List<Student> sortStudents(String field) {
        List<Student> students = studentRepositoryMySql.findAll(Sort.by(field).ascending());
        return students.stream().limit(3).collect(Collectors.toList());

    }
}
