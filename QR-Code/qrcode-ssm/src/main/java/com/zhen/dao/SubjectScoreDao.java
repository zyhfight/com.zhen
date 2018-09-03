package com.zhen.dao;

import com.zhen.model.StudentInfo;
import com.zhen.model.SubjectScore;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Repository
public interface SubjectScoreDao {

    SubjectScore selectSubjectScoreById(String studentId);

    List<SubjectScore> selectAllSubjectScore();

    int deleteSubjectScore(String studentId);

    int updateSubjectScore(SubjectScore subjectScore);

    int addSubjectScore(SubjectScore subjectScore);

}
