package com.project.exam_registration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateExamRequestDto {
    private Long subjectId;
    private List<Long> studentIds;
}
