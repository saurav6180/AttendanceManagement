package com.nendrasys.dao;

import com.nendrasys.model.AttendanceList;
import com.nendrasys.model.AttendanceModel;
import com.nendrasys.model.StudentDetailsModel;

import java.util.List;

public interface AttendanceDao {

    public int attendanceSave(AttendanceModel attendanceModel);

    public List<StudentDetailsModel> getStudentsDetailsByClass(String class_Name);

    public List<StudentDetailsModel> getStudentDetails();

    public int deleteAttendanceDetails(AttendanceModel attendanceModel);
    public AttendanceModel getAttendanceDetailsById(AttendanceModel attendanceModel);

    public int updateAllStudent(List<StudentDetailsModel> list);
}
