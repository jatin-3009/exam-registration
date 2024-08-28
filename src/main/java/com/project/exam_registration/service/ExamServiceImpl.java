package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateExamRequestDto;
import com.project.exam_registration.dto.RegisterStudentForExamDto;
import com.project.exam_registration.dto.UpdateExamRequestDto;
import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.entity.Student;
import com.project.exam_registration.entity.Subject;
import com.project.exam_registration.exception.CustomException;
import com.project.exam_registration.exception.ExamNotFoundException;
import com.project.exam_registration.exception.StudentNotFoundException;
import com.project.exam_registration.exception.SubjectNotFoundException;
import com.project.exam_registration.repository.ExamRepository;
import com.project.exam_registration.repository.StudentRepository;
import com.project.exam_registration.repository.SubjectRepository;
import com.project.exam_registration.util.StudentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentUtility studentUtility;

    @Override
    public List<Exam> getExams() {
        return examRepository.findAll();
    }

    @Override
    public Long createExam(CreateExamRequestDto createExamRequestDto) {
        Long subjectId = createExamRequestDto.getSubjectId();
        List<Long> newStudentIds = createExamRequestDto.getStudentIds();

        Exam exam = new Exam();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + subjectId));

        exam.setSubject(subject);

        if (newStudentIds != null && !newStudentIds.isEmpty()) {
            List<Student> newStudents = studentUtility.fetchStudentsByIds(newStudentIds);
            subject.setStudents(newStudents);
        }

        exam = examRepository.save(exam);
        return exam.getId();
    }

    @Override
    public Exam updateExam(String id, UpdateExamRequestDto updateExamRequestDto) {
        Long examId = Long.parseLong(id);
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam not found with id: " + id));

        Long subjectId = updateExamRequestDto.getSubjectId();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + subjectId));
        List<Long> updatedStudentIds = updateExamRequestDto.getStudentIds();

        if (subject != null) {
            exam.setSubject(subject);
        }

        if (updatedStudentIds != null && !updatedStudentIds.isEmpty()) {
            List<Student> updatedStudents = studentUtility.fetchStudentsByIds(updatedStudentIds);
            exam.setStudents(updatedStudents);
        }

        return examRepository.save(exam);
    }

    @Override
    public void deleteExam(String id) {
        Long examId = Long.parseLong(id);
        examRepository.deleteById(examId);
    }

    @Override
    public void register(RegisterStudentForExamDto registerStudentForExamDto) {
        Long examId = registerStudentForExamDto.getExamId();
        Long subjectId = registerStudentForExamDto.getSubjectId();
        Long studentId = registerStudentForExamDto.getStudentId();

        Exam exam = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam not found with id: " + examId));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + subjectId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

        if (subject.getId() != exam.getSubject().getId()) {
            throw new CustomException("There is no exam with exam id: " + examId + " and subject id: " + subjectId);
        }

        List<Student> registeredStudents = exam.getStudents();
        registeredStudents.add(student);

        exam.setStudents(registeredStudents);
        examRepository.save(exam);
    }
}
