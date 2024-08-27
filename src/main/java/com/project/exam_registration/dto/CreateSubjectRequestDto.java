package com.project.exam_registration.dto;

import com.project.exam_registration.entity.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CreateSubjectRequestDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private List<Student> students;
}
