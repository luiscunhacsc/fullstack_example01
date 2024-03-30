package com.fullstack.studentgrades.repository;

import com.fullstack.studentgrades.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods can be added here if needed
}
