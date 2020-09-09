package com.nendrasys.controller;

import com.nendrasys.command.StudentListWrapper;
import com.nendrasys.dao.AttendanceDaoImpl;
import com.nendrasys.model.AttendanceList;
import com.nendrasys.model.AttendanceModel;
import com.nendrasys.model.StudentDetailsModel;
import com.nendrasys.service.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class AttendanceController {

    @Autowired
    AttendanceDaoImpl attendanceDao;
    @Autowired
    AttendanceServiceImpl attendanceService;

    @RequestMapping("/attendance/{class_Name}")
    public String attendanceForm(Model model,@PathVariable("class_Name") String class_Name){
      /*  AttendanceList attendanceList = new AttendanceList();
        List<AttendanceModel> attendanceModelList = new ArrayList<AttendanceModel>();
        for(int i=0; i<2; i++) {
            attendanceModelList.add(new AttendanceModel());
        }
        attendanceList.setAttendanceModelList(attendanceModelList);*/
        StudentListWrapper wrapper = new StudentListWrapper();
        List<StudentDetailsModel> studentDetailsModel =  attendanceDao.getStudentsDetailsByClass(class_Name);
        wrapper.setWrapperList(studentDetailsModel);
        model.addAttribute("studentsList",wrapper);
        model.addAttribute("date",new Date());
        //model.addAttribute("attendanceModel",new AttendanceModel());
        return "attendanceForm";
    }

    @RequestMapping("/attendanceAction")
    public String attendanceFormAction(@ModelAttribute("studentsList") StudentListWrapper wrapper, String class_Name, Model model ){
        //System.out.println(attendanceModel);
     /*   for(AttendanceModel attendanceModel1 : attendanceModel.getAttendanceModelList()) {
            attendanceService.attendanceSave(attendanceModel1);
        }*/
       /* List<StudentDetailsModel> studentDetailsModel=  attendanceDao.getStudentsDetailsByClass(class_Name);
        model.addAttribute("studentsList",studentDetailsModel);
        model.addAttribute("attendanceModel",attendanceModel);
        model.addAttribute("msg",attendanceService.attendanceSave(attendanceModel));*/
       List<StudentDetailsModel> list = wrapper.getWrapperList();
       String result = attendanceService.updateAllStudentsAttendance(list);
       model.addAttribute("result ",result);
       return "attendanceForm";
    }

    @RequestMapping("/getStdDetails")
    public String getStudentDetails(Model model){
       List<StudentDetailsModel> model1=  attendanceDao.getStudentDetails();
        model.addAttribute("details",model1);
        return "studentDetails";
    }

    @RequestMapping("/getStdDetailsByClass/{class_Name}")
    public String getStudentDetailsByClass(@PathVariable("class_Name") String class_Name, Model model){
        List<StudentDetailsModel> studentDetailsModel=  attendanceDao.getStudentsDetailsByClass(class_Name);
        model.addAttribute("details",studentDetailsModel);
        return "studentDetailsByClass";
    }

    @RequestMapping("deleteForm")
    public String delAttendanceForm(Model model,AttendanceModel attendanceModel){
        model.addAttribute("del",attendanceModel);
     return "delForm";
    }

    @RequestMapping(value = "delete")
    public String deleteAttendanceDataById(@ModelAttribute("del")AttendanceModel attendanceModel, Model model) {
        System.out.println(attendanceModel+"model");
        model.addAttribute("deleteById", attendanceDao.deleteAttendanceDetails(attendanceModel));
        return "delAttendance";
    }

}
