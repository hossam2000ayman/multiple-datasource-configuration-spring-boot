package com.example.mulltiplesqldatabase.postgresql.service.serviceImplementation;

import com.example.mulltiplesqldatabase.postgresql.model.Student;
import com.example.mulltiplesqldatabase.postgresql.repository.StudentRepositoryPostgresql;
import com.example.mulltiplesqldatabase.postgresql.service.StudentServicePostgresql;
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
public class StudentServiceImplementationPostgresql implements StudentServicePostgresql {

    @Autowired
    private StudentRepositoryPostgresql studentRepositoryPostgresql;

    @Override
    public Student addStudent(Student student) {
        return studentRepositoryPostgresql.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepositoryPostgresql.findById(id);
        if (studentOptional.isEmpty())
            throw new EntityNotFoundException("Student not found");
        studentRepositoryPostgresql.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        Optional<Student> studentOptional = studentRepositoryPostgresql.findById(id);
        if (studentOptional.isEmpty())
            throw new EntityNotFoundException("Student not found");
        Student student = studentOptional.get();
        student.setAddress(newStudent.getAddress());
        student.setCity(newStudent.getCity());
        student.setGpa(newStudent.getGpa());
        student.setEmail(newStudent.getEmail());
        student.setDateOfBirth(newStudent.getDateOfBirth());
        student.setName(newStudent.getName());
        return studentRepositoryPostgresql.saveAndFlush(student);
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> studentOptional = studentRepositoryPostgresql.findById(id);
        if (studentOptional.isEmpty())
            throw new EntityNotFoundException("Student not found");
        return studentOptional.get();
    }

    @Override
    public Page<Student> pageStudents(int page, int pageSize) {
        return studentRepositoryPostgresql.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Student> pageStudentsWithSort(int page, int pageSize, String field) {
        return studentRepositoryPostgresql.findAll(PageRequest.of(page,pageSize).withSort(Sort.by(field).ascending()));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepositoryPostgresql.findAll();
    }

    @Override
    public List<Student> sortStudents(String field) {
        List<Student> students = studentRepositoryPostgresql.findAll(Sort.by(field).ascending());
        return students.stream().limit(3).collect(Collectors.toList());

    }
}
