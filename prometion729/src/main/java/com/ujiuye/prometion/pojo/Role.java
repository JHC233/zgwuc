package com.ujiuye.prometion.pojo;

public class Role {
   private String roleid;
   private String rolename;
   private String roledis;
   private String status;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledis() {
        return roledis;
    }

    public void setRoledis(String roledis) {
        this.roledis = roledis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", roledis='" + roledis + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
