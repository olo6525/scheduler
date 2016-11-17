package com.capston.googolhkl.scheduler;

/**
 * Created by googolhkl on 2016. 11. 6..
 */
import java.io.Serializable;

public class ClassInformation implements Serializable{

    private String time;
    private String schoolName;
    private String className;
    private String classNumber;
    private String professor;
    private String classRoom;
    private String memo;
    private String classColor;

    public ClassInformation(){}
    public ClassInformation(String str){
        String[] arr = str.split(":");
        time = arr[0];
        schoolName = arr[1];
        className = arr[2];
        classNumber = arr[3];
        professor = arr[4];
        classRoom = arr[5];
        memo = arr[6];
        classColor = arr[7];
    }
    public ClassInformation(String time, String schoolName, String className, String classNumber,
                             String professor, String classRoom, String memo, String classColor){
        this.time = time;
        this.schoolName = schoolName;
        this.className = className;
        this.classNumber = classNumber;
        this.professor = professor;
        this.classRoom = classRoom;
        this.memo = memo;
        this.classColor = classColor;
    }




    public String getTime() { return time; }
    public String getSchoolName() {
        return schoolName;
    }
    public String getClassName() {
        return className;
    }
    public String getClassNumber() {
        return classNumber;
    }
    public String getProfessor() {
        return professor;
    }
    public String getClassRoom() {
        return classRoom;
    }
    public String getMemo() {
        return memo;
    }
    public String getClassColor() {
        return classColor;
    }


    public void setTime(String time) {this.time = time; }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public void setClassColor(String classColor) {
        this.classColor = classColor;
    }
}