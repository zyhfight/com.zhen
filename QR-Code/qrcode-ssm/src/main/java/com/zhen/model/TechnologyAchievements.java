package com.zhen.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Repository
public class TechnologyAchievements {

    private String studentId;
    private String achievementId;
    private String achievementDescription;
    private int achievementScore;
    private Date createTime;
    private Date updateTime;
    private int deleted;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementDescription() {
        return achievementDescription;
    }

    public void setAchievementDescription(String achievementDescription) {
        this.achievementDescription = achievementDescription;
    }

    public int getAchievementScore() {
        return achievementScore;
    }

    public void setAchievementScore(int achievementScore) {
        this.achievementScore = achievementScore;
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
        return "TechnologyAchievements{" +
                "studentId='" + studentId + '\'' +
                ", achievementId='" + achievementId + '\'' +
                ", achievementDescription='" + achievementDescription + '\'' +
                ", achievementScore=" + achievementScore +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
