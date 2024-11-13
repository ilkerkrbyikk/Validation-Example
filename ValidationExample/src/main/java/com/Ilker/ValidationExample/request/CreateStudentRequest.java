package com.Ilker.ValidationExample.request;

import lombok.Data;

@Data
public class CreateStudentRequest {

    private String name;

    private String surname;

    private String schoolName;

    private int age;
}
