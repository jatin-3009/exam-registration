package com.project.exam_registration.dto;

import com.project.exam_registration.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateSubjectRequestDto {
    private String name;
    private List<Student> students;
}
