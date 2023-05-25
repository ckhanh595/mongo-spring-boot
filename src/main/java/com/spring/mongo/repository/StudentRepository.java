package com.spring.mongo.repository;

import com.spring.mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);
    Student findByEmailAndName (String email, String name);
    List<Student> findByNameOrEmail (String name, String email);

    // This is ok too ( _ or without _ is ok)
//    List<Student> findByDepartment_DepartmentName(String deptName);
    List<Student> findByDepartmentDepartmentName(String deptName);

    List<Student> findBySubjectsSubjectName(String subjectName);
    List<Student> findByEmailIsLike (String email);
    List<Student> findByNameStartsWith(String name);
    List<Student> findByDepartmentId(String deptId);

    @Query("{ \"name\" : \"?0\" }")
    List<Student> getByNameNative(String name);

}
