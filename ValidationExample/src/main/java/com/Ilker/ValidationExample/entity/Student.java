package com.Ilker.ValidationExample.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Name can not be null.")
    @Size(min = 3, max = 15, message = "Name should be between 3-15 characters.")
    private String name;

    @NotNull(message = "Surname can not be null.")
    @Size(min = 2, max = 25, message = "Surname should be between 3-25 characters.")
    private String surname;

    @NotNull(message = "School can not be null.")
    @Size(min = 3, max = 15, message = "Name should be between 3-15 characters.")
    private String schoolName;

    @NotNull(message = "AGE can not be null.")
    @Min(value = 10, message = "Age can not be under 10.")
    private int age;

}
