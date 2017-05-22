package com.aungthumoe.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aungthumoe on 21/05/2017.
 */
@RestController
public class StudentController {
    private List<StudentModel> students = new ArrayList<>();

    public StudentController() {
        super();
        this.students.add(new StudentModel(1, "Mg Mg", 12, "male"));
        this.students.add(new StudentModel(2, "Ni Ni", 13, "female"));
        this.students.add(new StudentModel(3, "Aung Aung", 11, "male"));
        this.students.add(new StudentModel(4, "Kyaw Kyaw", 14, "male"));
        this.students.add(new StudentModel(5, "Win Win", 12, "female"));
    }
    @GetMapping("/api/students")
    @ResponseBody
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(this.students);
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id) {
        for(StudentModel student: this.students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
