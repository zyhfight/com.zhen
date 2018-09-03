package com.zhen.model;

/**
 * Created by zhenyonghe on 2017/1/11.
 */
public class Ability {

    private String studentId;
    private int subjectSumScore;
    private int achievementSumScore;
    private int evaluateSumScore;
    private double sumScore;

    @Override
    public String toString() {
        return "Ability{" +
                "studentId='" + studentId + '\'' +
                ", subjectSumScore=" + subjectSumScore +
                ", achievementSumScore=" + achievementSumScore +
                ", evaluateSumScore=" + evaluateSumScore +
                ", sumScore=" + sumScore +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSubjectSumScore() {
        return subjectSumScore;
    }

    public void setSubjectSumScore(int subjectSumScore) {
        this.subjectSumScore = subjectSumScore;
    }

    public int getAchievementSumScore() {
        return achievementSumScore;
    }

    public void setAchievementSumScore(int achievementSumScore) {
        this.achievementSumScore = achievementSumScore;
    }

    public int getEvaluateSumScore() {
        return evaluateSumScore;
    }

    public void setEvaluateSumScore(int evaluateSumScore) {
        this.evaluateSumScore = evaluateSumScore;
    }

    public double getSumScore() {
        return sumScore;
    }

    public void setSumScore(double sumScore) {
        this.sumScore = sumScore;
    }
}
