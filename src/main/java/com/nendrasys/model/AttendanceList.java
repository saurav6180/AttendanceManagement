package com.nendrasys.model;

import java.util.List;

public class AttendanceList {
    private List<AttendanceModel> attendanceModelList;

    public List<AttendanceModel> getAttendanceModelList() {
        return attendanceModelList;
    }

    public void setAttendanceModelList(List<AttendanceModel> attendanceModelList) {
        this.attendanceModelList = attendanceModelList;
    }

    @Override
    public String toString() {
        return "AttendanceList{" +
                "attendanceModelList=" + attendanceModelList +
                '}';
    }
}
