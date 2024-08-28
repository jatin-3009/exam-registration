package com.project.exam_registration.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EnrollStudentInSubjectDto {
    @NotBlank
    private Long studentId;
    private Long subjectId;
}
