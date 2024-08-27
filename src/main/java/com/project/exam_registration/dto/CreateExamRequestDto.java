package com.project.exam_registration.dto;

import com.project.exam_registration.entity.Student;
import com.project.exam_registration.entity.Subject;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CreateExamRequestDto {
    @NotBlank(message = "Subject cannot be blank")
    private Subject subject;
    private List<Student> students;
}
