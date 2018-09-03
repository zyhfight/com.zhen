package com.zhen.service.impl;

import com.zhen.dao.SubjectScoreDao;
import com.zhen.model.SubjectScore;
import com.zhen.service.SubjectScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/9.
 */
@Service
public class SubjectScoreServiceImpl implements SubjectScoreService {
    @Autowired
    SubjectScoreDao scoreDao;

    public SubjectScore selectSubjectScoreById(String studentId) {
        return scoreDao.selectSubjectScoreById(studentId);
    }

    public List<SubjectScore> selectAllSubjectScore() {
        return scoreDao.selectAllSubjectScore();
    }

    public boolean updateSubjectScore(SubjectScore subjectScore) {

        int cnt = scoreDao.updateSubjectScore(subjectScore);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean addSubjectScore(SubjectScore subjectScore) {

        int cnt = scoreDao.addSubjectScore(subjectScore);

        if(cnt>0){
            return true;
        }

        return false;
    }

    public boolean deleteSubjectScore(String studentId) {
        int cnt = scoreDao.deleteSubjectScore(studentId);

        if(cnt>0){
            return true;
        }

        return false;
    }
}
