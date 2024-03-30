package com.fullstack.studentgrades.controller;

import com.fullstack.studentgrades.model.Grade;
import com.fullstack.studentgrades.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.findAllGrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        return gradeService.findGradeById(id)
                .map(grade -> ResponseEntity.ok().body(grade))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade gradeDetails) {
        return gradeService.findGradeById(id)
                .map(grade -> {
                    grade.setSubject(gradeDetails.getSubject());
                    grade.setScore(gradeDetails.getScore());
                    // Make sure to update any other fields that are provided in the request
                    Grade updatedGrade = gradeService.saveGrade(grade);
                    return ResponseEntity.ok().body(updatedGrade);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable Long id) {
        return gradeService.findGradeById(id)
                .map(grade -> {
                    gradeService.deleteGrade(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
