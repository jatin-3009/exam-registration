package com.project.exam_registration.util;

import com.project.exam_registration.entity.Subject;
import com.project.exam_registration.exception.SubjectNotFoundException;
import com.project.exam_registration.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectUtility {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> fetchSubjectsByIds(List<Long> subjectIds) {
        List<Subject> subjects = new ArrayList<>();
        for (Long id : subjectIds) {
            Subject subject = subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + id));
            subjects.add(subject);
        }
        return subjects;
    }
}
