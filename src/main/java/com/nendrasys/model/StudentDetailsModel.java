package com.nendrasys.model;

import java.sql.Date;

public class StudentDetailsModel {

    private String class_Name;
    private String stdRoll_Number;
    private String std_Name;
    private String father_Name;
    private String mother_Name;
    private String address;
    private Date doj;
    private int attendance;
    private int index;

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getClass_Name() {
        return class_Name;
    }

    public void setClass_Name(String class_Name) {
        this.class_Name = class_Name;
    }

    public String getStdRoll_Number() {
        return stdRoll_Number;
    }

    public void setStdRoll_Number(String stdRoll_Number) {
        this.stdRoll_Number = stdRoll_Number;
    }

    public String getStd_Name() {
        return std_Name;
    }

    public void setStd_Name(String std_Name) {
        this.std_Name = std_Name;
    }

    public String getFather_Name() {
        return father_Name;
    }

    public void setFather_Name(String father_Name) {
        this.father_Name = father_Name;
    }

    public String getMother_Name() {
        return mother_Name;
    }

    public void setMother_Name(String mother_Name) {
        this.mother_Name = mother_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "StudentDetailsModel{" +
                "class_Name='" + class_Name + '\'' +
                ", stdRoll_Number='" + stdRoll_Number + '\'' +
                ", std_Name='" + std_Name + '\'' +
                ", father_Name='" + father_Name + '\'' +
                ", mother_Name='" + mother_Name + '\'' +
                ", address='" + address + '\'' +
                ", doj=" + doj +
                ", attendance=" + attendance +
                ", index=" + index +
                '}';
    }
}
