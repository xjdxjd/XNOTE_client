package com.xnote.client.module.user.bean;

import java.util.Date;

public class User {
    private String id;

    private String loginName;

    private String password;

    private Integer loginStatus;

    private Integer passStatus;

    private Date passUpdateTime;

    private Integer userStatus;

    private Integer freezeDuration;

    private Date freezeTime;

    private Integer firstLogin;

    private Date lastLoginTime;

    private String userRoleId;

    private String userRoleName;

    private Integer userSort;

    private String infoId;

    private Date createTime;

    private Date updateTime;

    private Long timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Integer getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(Integer passStatus) {
        this.passStatus = passStatus;
    }

    public Date getPassUpdateTime() {
        return passUpdateTime;
    }

    public void setPassUpdateTime(Date passUpdateTime) {
        this.passUpdateTime = passUpdateTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getFreezeDuration() {
        return freezeDuration;
    }

    public void setFreezeDuration(Integer freezeDuration) {
        this.freezeDuration = freezeDuration;
    }

    public Date getFreezeTime() {
        return freezeTime;
    }

    public void setFreezeTime(Date freezeTime) {
        this.freezeTime = freezeTime;
    }

    public Integer getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Integer firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName == null ? null : userRoleName.trim();
    }

    public Integer getUserSort() {
        return userSort;
    }

    public void setUserSort(Integer userSort) {
        this.userSort = userSort;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", passStatus=" + passStatus +
                ", passUpdateTime=" + passUpdateTime +
                ", userStatus=" + userStatus +
                ", freezeDuration=" + freezeDuration +
                ", freezeTime=" + freezeTime +
                ", firstLogin=" + firstLogin +
                ", lastLoginTime=" + lastLoginTime +
                ", userRoleId='" + userRoleId + '\'' +
                ", userRoleName='" + userRoleName + '\'' +
                ", userSort=" + userSort +
                ", infoId='" + infoId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", timestamp=" + timestamp +
                '}';
    }
}