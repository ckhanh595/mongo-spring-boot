package com.spring.mongo.service;

import com.spring.mongo.entity.Student;
import com.spring.mongo.repository.DepartmentRepository;
import com.spring.mongo.repository.StudentRepository;
import com.spring.mongo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student create(Student student) {
        if (student.getDepartment() != null) {
            departmentRepository.save(student.getDepartment());
        }

        if (student.getSubjects() != null && student.getSubjects().size() > 0) {
            subjectRepository.saveAll(student.getSubjects());
        }

        return studentRepository.save(student);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public String delete(String id) {
        studentRepository.deleteById(id);
        return "Deleted!";
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> searchAll() {
        return studentRepository.findAll();
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student searchByNameAndMail(String name, String email) {
        return studentRepository.findByEmailAndName(email, name);
    }

    public List<Student> searchByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> searchAllPagination(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber - 1, pageSize);
        return studentRepository.findAll(page).getContent();
    }

    public List<Student> searchAllSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
//        return studentRepository.findByDepartment_DepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> emailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
