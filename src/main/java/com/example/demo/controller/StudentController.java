package com.example.demo.controller;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WP
 * @date 2020/12/30  17:43
 */

@RestController
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/getStudentList")
    public List<Student> getStudentList(){
        List<Student> studentList = studentMapper.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
        return studentList;
    }

    @GetMapping("getStudentById")
    public Student getStudentById(){
        Student student = studentMapper.getStudentById(1);
        System.out.println(student);
        return student;
    }

    @GetMapping("addStudent")
    public String addStudent(){
        studentMapper.addStudent(new Student(4, "pw", "654321"));
        return "OK";
    }

    @GetMapping("updateStudentById")
    public String updateStudentById(){
        studentMapper.updateStudentById(new Student(3,"wp","123456"));
        return "OK";
    }
    @GetMapping("deleteStudentById")
    public String deleteStudentById(){
        studentMapper.deleteStudentById(3);
        return "OK";
    }
}
