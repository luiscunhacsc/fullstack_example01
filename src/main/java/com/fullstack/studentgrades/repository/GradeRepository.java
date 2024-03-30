
package com.fullstack.studentgrades.repository;

import com.fullstack.studentgrades.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Custom query methods can be added here if needed
}
