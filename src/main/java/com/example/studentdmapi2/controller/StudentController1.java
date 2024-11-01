package com.example.studentdmapi2.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentdmapi2.model.Student1;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController1 {

    private final Map<Integer, Student1> studentData = new HashMap<>();
    private int currentId = 1;

    @GetMapping
    public List<Student1> getAllStudents(
            @RequestParam(required = false) String course,
            @RequestParam(required = false) Boolean feesPaid,
            @RequestParam(required = false) Double minMarks,
            @RequestParam(required = false) Double maxMarks) {
        //filtering options
        return studentData.values().stream()
                .filter(student -> (course == null || student.getCourse().equalsIgnoreCase(course)) &&
                                  (feesPaid == null || student.getFeesPaid().equals(feesPaid)) &&
                                  (minMarks == null || student.getMarks() >= minMarks) &&
                                  (maxMarks == null || student.getMarks() <= maxMarks))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Student1 getStudentById(@PathVariable Integer id) {
        return studentData.get(id);
    }

    @PostMapping
    public Student1 createStudent(@Valid @RequestBody Student1 student) {
        student.setId(currentId++);  
        studentData.put(student.getId(), student);
        return student;
    }

    @PutMapping("/{id}")
    public Student1 updateStudent(@PathVariable Integer id, @Valid @RequestBody Student1 updatedStudent) {
        Student1 student = studentData.get(id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setCourse(updatedStudent.getCourse());
            student.setMarks(updatedStudent.getMarks());
            student.setFeesPaid(updatedStudent.getFeesPaid());
        }
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentData.remove(id);
    }

    @GetMapping("/top/{n}")
    public List<Student1> getTopNRankers(@PathVariable int n) {
        return studentData.values().stream()
                .sorted(Comparator.comparingDouble(Student1::getMarks).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}
