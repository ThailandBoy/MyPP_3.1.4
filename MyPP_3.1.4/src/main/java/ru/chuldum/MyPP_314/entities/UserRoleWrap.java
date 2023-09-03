package ru.chuldum.MyPP_314.entities;

import java.util.List;

public class UserRoleWrap {
    private User user;
    private List<Role> roleList;

    private Long[] roleList2;

    public UserRoleWrap() {
    }

    public UserRoleWrap(User user, List<Role> roleList, Long[] roleList2) {
        this.user = user;
        this.roleList = roleList;
        this.roleList2 = roleList2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Long[] getRoleList2() {
        return roleList2;
    }

    public void setRoleList2(Long[] roleList2) {
        this.roleList2 = roleList2;
    }

    @Override
    public String toString() {
        return "UserRoleWrap{" +
                "user=" + user +
                ", roleList=" + roleList +
                '}';
    }
}
