package com.Ilker.ValidationExample.service;

import com.Ilker.ValidationExample.entity.Student;
import com.Ilker.ValidationExample.repository.StudentRepository;
import com.Ilker.ValidationExample.request.CreateStudentRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(CreateStudentRequest request){
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setSurname(request.getSurname());
        student.setSchoolName(request.getSchoolName());

        return studentRepository.save(student);
    }
}
