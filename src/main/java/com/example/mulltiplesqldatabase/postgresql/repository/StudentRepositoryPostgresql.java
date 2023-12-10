package com.example.mulltiplesqldatabase.postgresql.repository;

import com.example.mulltiplesqldatabase.postgresql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryPostgresql extends JpaRepository<Student, Long> {

}
