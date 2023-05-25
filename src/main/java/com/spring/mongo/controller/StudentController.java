package com.spring.mongo.controller;

import com.spring.mongo.entity.Department;
import com.spring.mongo.entity.Student;
import com.spring.mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable String id) {
        return studentService.findById(id);
    }

    @GetMapping()
    public List<Student> search() {
        return studentService.searchAll();
    }

    @GetMapping("/name")
    public List<Student> searchByName(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @GetMapping("/name-and-email")
    public Student studentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
        return studentService.searchByNameAndMail(name, email);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return studentService.delete(id);
    }

    @GetMapping("/name-or-email")
    public List<Student> studentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
        return studentService.searchByNameOrMail(name, email);
    }

    @GetMapping("/pagination")
    public List<Student> searchAllPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return studentService.searchAllPagination(pageNumber, pageSize);
    }

    @GetMapping("/sorting")
    public List<Student> searchAllSorting() {
        return studentService.searchAllSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String deptName) {
        return studentService.byDepartmentName(deptName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName) {
        return studentService.bySubjectName(subName);
    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email) {
        return studentService.emailLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name) {
        return studentService.nameStartsWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String deptId) {
        return studentService.byDepartmentId(deptId);
    }

    @GetMapping("/name-native")
    public List<Student> searchByNameNative(@RequestParam String name) {
        return studentService.searchByNameNative(name);
    }
}
