package com.project.exam_registration.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RegisterStudentForExamDto {
    @NotBlank
    private Long studentId;
    @NotBlank
    private Long examId;
    @NotBlank
    private Long subjectId;
}
