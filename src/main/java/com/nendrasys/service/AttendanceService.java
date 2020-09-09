package com.nendrasys.service;

import com.nendrasys.model.AttendanceList;
import com.nendrasys.model.AttendanceModel;
import com.nendrasys.model.StudentDetailsModel;

import java.util.List;

public interface AttendanceService {
    public String attendanceSave(AttendanceModel attendanceModel);

    public String updateAllStudentsAttendance(List<StudentDetailsModel> list);

}
