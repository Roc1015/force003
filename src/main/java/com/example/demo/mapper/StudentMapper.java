package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WP
 * @date 2020/12/30  17:46
 */

@Mapper
@Repository
public interface StudentMapper {
    //查询全部学生
    List<Student> getStudentList();
    //通过Id查询学生信息
    Student getStudentById(int id);
    //添加学生
    int addStudent (Student student);
    //通过Id更新学生信息
    int updateStudentById (Student student);
    //通过Id删除学生
    int deleteStudentById (int id);

}
