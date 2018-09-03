package com.zhen.service.impl;

import com.zhen.dao.StudentInfoDao;
import com.zhen.model.StudentInfo;
import com.zhen.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoDao studentInfoDao;


    public List<StudentInfo> selectAllStudentInfo() {
        return studentInfoDao.selectAllStudentInfo();
    }

    public StudentInfo selectStudentInfoById(String studentId) {
        return studentInfoDao.selectStudentInfoById(studentId);
    }

    public boolean updateStudentInfo(StudentInfo studentInfo) {

        int cnt = studentInfoDao.updateStudentInfo(studentInfo);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean addStudentInfo(StudentInfo studentInfo) {

        int cnt = studentInfoDao.addStudentInfo(studentInfo);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean deleteStudentInfo(String studentId) {
        int cnt = studentInfoDao.deleteStudentInfo(studentId);

        if(cnt>0){
            return true;
        }

        return false;
    }
}
