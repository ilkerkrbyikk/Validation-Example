package com.Ilker.ValidationExample.controller;

import com.Ilker.ValidationExample.entity.Student;
import com.Ilker.ValidationExample.request.CreateStudentRequest;
import com.Ilker.ValidationExample.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public ResponseEntity<?> createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.createStudent(createStudentRequest);
        return ResponseEntity.ok().body(createStudentRequest);
    }


}
