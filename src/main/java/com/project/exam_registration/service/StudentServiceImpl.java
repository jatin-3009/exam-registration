package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateStudentRequestDto;
import com.project.exam_registration.dto.UpdateStudentRequestDto;
import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.entity.Student;
import com.project.exam_registration.entity.Subject;
import com.project.exam_registration.exception.StudentNotFoundException;
import com.project.exam_registration.repository.ExamRepository;
import com.project.exam_registration.repository.StudentRepository;
import com.project.exam_registration.repository.SubjectRepository;
import com.project.exam_registration.util.ExamUtility;
import com.project.exam_registration.util.SubjectUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamUtility examUtility;
    @Autowired
    private SubjectUtility subjectUtility;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Long createStudent(CreateStudentRequestDto createStudentRequestDto) {
        String newName = createStudentRequestDto.getName();
        List<Long> newSubjectIds = createStudentRequestDto.getSubjectIds();
        List<Long> newExamIds = createStudentRequestDto.getExamIds();

        Student student = new Student();
        student.setName(newName);

        if (newSubjectIds != null && !newSubjectIds.isEmpty()) {
            List<Subject> newSubjects = subjectUtility.fetchSubjectsByIds(newSubjectIds);
            student.setSubjects(newSubjects);
        }

        if (newExamIds != null && !newExamIds.isEmpty()) {
            List<Exam> newExams = examUtility.fetchExamsByIds(newExamIds);
            student.setExams(newExams);
        }

        student = studentRepository.save(student);
        return student.getId();
    }

    @Override
    public Student updateStudent(String id, UpdateStudentRequestDto updateStudentRequestDto) {
        Long studentId = Long.parseLong(id);
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        String updatedName = updateStudentRequestDto.getName();
        List<Long> updatedSubjectIds = updateStudentRequestDto.getSubjectIds();
        List<Long> updatedExamIds = updateStudentRequestDto.getExamIds();

        if (updatedName != null && !updatedName.isBlank()) {
            student.setName(updatedName);
        }

        if (updatedSubjectIds != null) {
            List<Subject> updatedSubjects = subjectUtility.fetchSubjectsByIds(updatedSubjectIds);
            student.setSubjects(updatedSubjects);
        }

        if (updatedExamIds != null) {
            List<Exam> updatedExams = examUtility.fetchExamsByIds(updatedExamIds);
            student.setExams(updatedExams);
        }

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        Long studentId = Long.parseLong(id);
        studentRepository.deleteById(studentId);
    }
}