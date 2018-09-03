package com.zhen.service;

import com.zhen.model.StudentInfo;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
public interface StudentInfoService {

    List<StudentInfo> selectAllStudentInfo();

    StudentInfo selectStudentInfoById(String studentId);

    boolean updateStudentInfo(StudentInfo studentInfo);

    boolean  addStudentInfo(StudentInfo studentInfo);

    boolean deleteStudentInfo(String studentId);

}
