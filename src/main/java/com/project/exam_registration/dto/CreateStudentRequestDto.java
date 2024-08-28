package com.project.exam_registration.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CreateStudentRequestDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private List<Long> subjectIds;
    private List<Long> examIds;
}
