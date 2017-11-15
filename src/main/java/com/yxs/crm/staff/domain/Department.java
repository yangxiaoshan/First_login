package com.yxs.crm.staff.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/10.
 */
public class Department {
    private int deptID;
    private String deptName;
    private Set<Post> posts = new HashSet<>();
    private Set<Staff> staffs = new HashSet<>();

    public Department() {
    }

    public Department(int deptID) {
        this.deptID = deptID;
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(int deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptID=" + deptID +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

}
