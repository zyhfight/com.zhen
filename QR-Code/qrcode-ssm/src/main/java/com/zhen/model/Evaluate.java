package com.zhen.model;

import java.util.Date;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
public class Evaluate {

    private String studentId;
    private int evaluateScore;
    private String evaluateDescription;
    private Date createTime;
    private Date updateTime;
    private int deleted;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateDescription() {
        return evaluateDescription;
    }

    public void setEvaluateDescription(String evaluateDescription) {
        this.evaluateDescription = evaluateDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "studentId='" + studentId + '\'' +
                ", evaluateScore=" + evaluateScore +
                ", evaluateDescription=" + evaluateDescription +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
