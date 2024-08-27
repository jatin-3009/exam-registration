package com.project.exam_registration.dto;

import com.project.exam_registration.entity.Student;
import com.project.exam_registration.entity.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateExamRequestDto {
    private Subject subject;
    private List<Student> students;
}
