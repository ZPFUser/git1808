package com.qianfeng.pojo;

public class SysUser {
    private Integer usrId;

    private String usrName;

    private String usrPassword;

    private Integer usrRoleId;

    private String usrFlag;

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName == null ? null : usrName.trim();
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword == null ? null : usrPassword.trim();
    }

    public Integer getUsrRoleId() {
        return usrRoleId;
    }

    public void setUsrRoleId(Integer usrRoleId) {
        this.usrRoleId = usrRoleId;
    }

    public String getUsrFlag() {
        return usrFlag;
    }

    public void setUsrFlag(String usrFlag) {
        this.usrFlag = usrFlag == null ? null : usrFlag.trim();
    }
}