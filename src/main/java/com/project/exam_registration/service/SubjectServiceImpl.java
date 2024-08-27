package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateSubjectRequestDto;
import com.project.exam_registration.dto.UpdateSubjectRequestDto;
import com.project.exam_registration.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Override
    public List<Subject> getSubjects() {
        return null;
    }

    @Override
    public String createSubject(CreateSubjectRequestDto createSubjectRequestDto) {
        return null;
    }

    @Override
    public Subject updateSubject(String id, UpdateSubjectRequestDto updateSubjectRequestDto) {
        return null;
    }

    @Override
    public void deleteSubject(String id) {

    }
}
