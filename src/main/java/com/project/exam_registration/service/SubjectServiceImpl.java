package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateSubjectRequestDto;
import com.project.exam_registration.dto.EnrollStudentInSubjectDto;
import com.project.exam_registration.dto.UpdateSubjectRequestDto;
import com.project.exam_registration.entity.Student;
import com.project.exam_registration.entity.Subject;
import com.project.exam_registration.exception.StudentNotFoundException;
import com.project.exam_registration.exception.SubjectNotFoundException;
import com.project.exam_registration.repository.StudentRepository;
import com.project.exam_registration.repository.SubjectRepository;
import com.project.exam_registration.util.StudentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentUtility studentUtility;

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Long createSubject(CreateSubjectRequestDto createSubjectRequestDto) {
        String newName = createSubjectRequestDto.getName();
        List<Long> newStudentIds = createSubjectRequestDto.getStudentIds();

        Subject subject = new Subject();
        subject.setName(newName);

        if (newStudentIds != null && !newStudentIds.isEmpty()) {
            List<Student> newStudents = studentUtility.fetchStudentsByIds(newStudentIds);
            subject.setStudents(newStudents);
        }

        subject = subjectRepository.save(subject);
        return subject.getId();
    }

    @Override
    public Subject updateSubject(String id, UpdateSubjectRequestDto updateSubjectRequestDto) {
        Long subjectId = Long.parseLong(id);
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + id));

        String updatedName = updateSubjectRequestDto.getName();
        List<Long> updatedStudentIds = updateSubjectRequestDto.getStudentIds();

        if (updatedName != null && !updatedName.isBlank()) {
            subject.setName(updatedName);
        }

        if (updatedStudentIds != null && !updatedStudentIds.isEmpty()) {
            List<Student> updatedStudents = studentUtility.fetchStudentsByIds(updatedStudentIds);
            subject.setStudents(updatedStudents);
        }

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(String id) {
        Long subjectId = Long.parseLong(id);
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public void enroll(EnrollStudentInSubjectDto enrollStudentInSubjectDto) {
        Long subjectId = enrollStudentInSubjectDto.getSubjectId();
        Long studentId = enrollStudentInSubjectDto.getStudentId();

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + subjectId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

        List<Student> enrolledStudents = subject.getStudents();
        enrolledStudents.add(student);

        subject.setStudents(enrolledStudents);
        subjectRepository.save(subject);
    }
}
