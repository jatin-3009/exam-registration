package com.project.exam_registration.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CreateExamRequestDto {
    @NotBlank(message = "Exam id cannot be blank")
    private Long subjectId;
    private List<Long> studentIds;
}
