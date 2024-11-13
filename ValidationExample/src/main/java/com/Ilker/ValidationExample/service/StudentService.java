package com.Ilker.ValidationExample.service;

import com.Ilker.ValidationExample.entity.Student;
import com.Ilker.ValidationExample.request.CreateStudentRequest;

public interface StudentService {

    Student createStudent(CreateStudentRequest request);
}
