package com.zhen.dao;

import com.zhen.model.StudentInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Repository
public interface StudentInfoDao {

    //查询所有学生信息
    List<StudentInfo> selectAllStudentInfo();

    //通过学号查询学生信息
    StudentInfo selectStudentInfoById(String studentId);

    //更新学生信息
    int updateStudentInfo(StudentInfo studentInfo);

    //添加学生信息
    int  addStudentInfo(StudentInfo studentInfo);

    //删除学生信息
    int deleteStudentInfo(String studentId);
}
