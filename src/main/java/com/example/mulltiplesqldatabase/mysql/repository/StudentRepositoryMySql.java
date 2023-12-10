package com.example.mulltiplesqldatabase.mysql.repository;

import com.example.mulltiplesqldatabase.mysql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryMySql extends JpaRepository<Student,Long> {
}
