package com.zhen.model;

import java.util.Date;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
public class StudentInfo {

    private String studentId;//学号
    private String studentName;//姓名
    private String studentSex;//性别
    private int studentAge;//年龄
    private String studentHome;//籍贯
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private int deleted;//是否被删除，0-未删除，1-已删除

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentHome() {
        return studentHome;
    }

    public void setStudentHome(String studentHome) {
        this.studentHome = studentHome;
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
        return "StudentInfo{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex=" + studentSex +
                ", studentAge=" + studentAge +
                ", studentHome='" + studentHome + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
