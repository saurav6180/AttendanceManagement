package com.nendrasys.command;

import com.nendrasys.model.StudentDetailsModel;

import java.util.List;

public class StudentListWrapper {
    private List<StudentDetailsModel> wrapperList;

    public List<StudentDetailsModel> getWrapperList() {
        return wrapperList;
    }

    public void setWrapperList(List<StudentDetailsModel> wrapperList) {
        this.wrapperList = wrapperList;
    }
}
