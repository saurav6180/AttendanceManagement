package com.nendrasys.service;

import com.nendrasys.dao.AttendanceDaoImpl;
import com.nendrasys.model.AttendanceModel;
import com.nendrasys.model.StudentDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AttendanceServiceImpl  implements  AttendanceService{

    @Autowired
    AttendanceDaoImpl attendanceDao;
    @Override
    public String attendanceSave(AttendanceModel attendanceModel) {
        String id=attendanceModel.getStdRoll_Number();
        int count=0;
        count=attendanceDao.attendanceSave(attendanceModel);
        if(count==1) {

        String msg=id;
            return msg;
        }
        else {
                return "Attendance not Added";
            }
        }

    @Override
    public String updateAllStudentsAttendance(List<StudentDetailsModel> list) {
       int result =  attendanceDao.updateAllStudent(list);
        return result==0? "Student Attendance Failed update" : "Student Attendance update successfully";
    }
}

