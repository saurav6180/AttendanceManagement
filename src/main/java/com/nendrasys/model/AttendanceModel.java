package com.nendrasys.model;

import java.util.Date;

public class AttendanceModel {
    private String class_Name;
    private String stdRoll_Number;
    private String std_Name;
    private String date;
    private String attendance;
    private double monthAvg;
    private double totalAvg;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public double getMonthAvg() {
        return monthAvg;
    }

    public void setMonthAvg(double monthAvg) {
        this.monthAvg = monthAvg;
    }

    public double getTotalAvg() {
        return totalAvg;
    }

    public void setTotalAvg(double totalAvg) {
        this.totalAvg = totalAvg;
    }

    @Override
    public String toString() {
        return "AttendanceModel{" +
                "class_Name='" + class_Name + '\'' +
                ", stdRoll_Number='" + stdRoll_Number + '\'' +
                ", std_Name='" + std_Name + '\'' +
                ", date='" + date + '\'' +
                ", attendance='" + attendance + '\'' +
                ", monthAvg='" + monthAvg + '\'' +
                ", totalAvg='" + totalAvg + '\'' +
                '}';
    }
}
