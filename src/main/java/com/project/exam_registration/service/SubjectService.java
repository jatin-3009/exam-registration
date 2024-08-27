package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateSubjectRequestDto;
import com.project.exam_registration.dto.UpdateSubjectRequestDto;
import com.project.exam_registration.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<Subject> getSubjects();

    String createSubject(CreateSubjectRequestDto createSubjectRequestDto);

    Subject updateSubject(String id, UpdateSubjectRequestDto updateSubjectRequestDto);

    void deleteSubject(String id);
}
