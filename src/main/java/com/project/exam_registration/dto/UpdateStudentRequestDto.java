package com.project.exam_registration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateStudentRequestDto {
    private String name;
    private List<Long> subjectIds;
    private List<Long> examIds;
}
