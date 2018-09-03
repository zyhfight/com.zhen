package com.zhen.service;

import com.zhen.model.SubjectScore;

import java.util.List;

/**
 * Created by zhenyonghe on 2017/1/9.
 */
public interface SubjectScoreService {

    SubjectScore selectSubjectScoreById(String studentId);

    List<SubjectScore> selectAllSubjectScore();

    boolean deleteSubjectScore(String studentId);

    boolean updateSubjectScore(SubjectScore subjectScore);

    boolean addSubjectScore(SubjectScore subjectScore);
}
