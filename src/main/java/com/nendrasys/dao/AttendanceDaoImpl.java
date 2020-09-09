package com.nendrasys.dao;

import com.nendrasys.model.AttendanceModel;
import com.nendrasys.model.StudentDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AttendanceDaoImpl implements AttendanceDao {
    private  static final String UPDATE_QUERY = "UPDATE STUDENTDETAILS SET ATTENDANCE=? WHERE STDROLL_NUMBER=? ";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int attendanceSave(AttendanceModel attendanceModel ) {

               String sql="insert into attendancetable(class_Name,stdRoll_Number,std_Name,date,attendance,monthAvg,totalAvg) values('" + attendanceModel.getClass_Name() + "','" + attendanceModel.getStdRoll_Number() + "','" + attendanceModel.getStd_Name() + "','" + attendanceModel.getDate() + "','" + attendanceModel.getAttendance() + "','" + attendanceModel.getMonthAvg() + "','" + attendanceModel.getTotalAvg() + "')";
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<StudentDetailsModel> getStudentsDetailsByClass(String class_Name) {
        List<StudentDetailsModel> studentDetailsModelList = jdbcTemplate.query("select * from studentdetails where class_Name='"+class_Name+"'", new RowMapper<StudentDetailsModel>() {
            int count=0;
            @Override
            public StudentDetailsModel mapRow(ResultSet rs, int i) throws SQLException {
                StudentDetailsModel b = new StudentDetailsModel();
                b.setIndex(count);
                b.setClass_Name(rs.getString("class_Name"));
                b.setStdRoll_Number(rs.getString("stdRoll_Number"));
                b.setStd_Name(rs.getString("std_Name"));
                b.setFather_Name(rs.getString("father_Name"));
                b.setMother_Name(rs.getString("mother_Name"));
                b.setAddress(rs.getString("address"));
                b.setDoj(rs.getDate("doj"));
                b.setAttendance(rs.getInt("attendance"));
                count++;
                return b;
            }
        });
        return studentDetailsModelList;
    }


    @Override
    public List<StudentDetailsModel> getStudentDetails() {
        List<StudentDetailsModel> studentDetailsModelList = jdbcTemplate.query("select * from studentdetails ", new RowMapper<StudentDetailsModel>() {
            @Override
            public StudentDetailsModel mapRow(ResultSet rs, int i) throws SQLException {
                StudentDetailsModel b = new StudentDetailsModel();
                 b.setClass_Name(rs.getString("class_Name"));
                b.setStdRoll_Number(rs.getString("stdRoll_Number"));
                b.setStd_Name(rs.getString("std_Name"));
                b.setFather_Name(rs.getString("father_Name"));
                b.setMother_Name(rs.getString("mother_Name"));
                b.setAddress(rs.getString("address"));
                b.setDoj(rs.getDate("doj"));
                return b;
            }
        });
        return studentDetailsModelList;
    }
    @Override
    public int deleteAttendanceDetails(AttendanceModel attendanceModel){
        String querydel = "delete from attendancetable where stdRoll_Number='"+attendanceModel.getStdRoll_Number()+"' and date='"+attendanceModel.getDate()+"' ";
        return jdbcTemplate.update(querydel);
    }
    @Override
    public AttendanceModel getAttendanceDetailsById(AttendanceModel attendanceModel) {
        String sql="select * from attendancetable stdRoll_Number='"+attendanceModel.getStdRoll_Number()+"' and date='"+attendanceModel.getDate()+"'";
        AttendanceModel studentinfo = (AttendanceModel) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(AttendanceModel.class));
        //System.out.println("from dao: "+studentinfo);
        return studentinfo;
    }

   /* @Override
    public int updateAllStudent(List<StudentDetailsModel> list) {
        AtomicInteger result = new AtomicInteger();
        list.forEach(student->{
            result.set(jdbcTemplate.update(UPDATE_QUERY, student.getAttendance(), student.getStdRoll_Number()));
        });
        return result.get();
    }*/

   /* @Override
    public int updateAllStudent(List<StudentDetailsModel> list) {
        AtomicInteger result = new AtomicInteger();


        list.forEach(student->{
            int attendance=student.getAttendance();
            if(attendance==0)
            int a=student.getAttendance();
            int b=a1;
            result.set(jdbcTemplate.update(UPDATE_QUERY, b, student.getStdRoll_Number()));
        });
        return result.get();
    }*/

   private static final String insert="insert into studentdetails(class_Name,stdRoll_Number,std_Name,father_Name,mother_Name,address,doj,attendance) values(?,?,?,?,?,?,?,?)";

    public int updateAllStudent(List<StudentDetailsModel> list) {
        AtomicInteger result = new AtomicInteger();
        list.forEach(student->{
            result.set(jdbcTemplate.update(insert,student.getClass_Name(),student.getStdRoll_Number(),student.getStd_Name(),student.getFather_Name(),student.getMother_Name(),student.getAddress(),student.getDoj(),student.getAttendance()));
        });
        return result.get();
    }

}
