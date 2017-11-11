package com.yxs.crm.staff.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/10.
 */
public class Post {
    private int postID;
    private String postName;
    private Department department;
    private Set<Staff> staffs = new HashSet<>();

    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(int postID, String postName) {
        this.postID = postID;
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postName='" + postName + '\'' +
                '}';
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
