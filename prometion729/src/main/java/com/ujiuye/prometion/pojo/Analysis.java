package com.ujiuye.prometion.pojo;

import java.io.Serializable;
import java.util.Date;

public class Analysis implements Serializable {
    private Integer id;
    private String projectname;
    private String title;
    private String simpledis;
    private String detaileddis;
    private Date addtime;
    private Date updatetime;
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSimpledis() {
        return simpledis;
    }

    public void setSimpledis(String simpledis) {
        this.simpledis = simpledis;
    }

    public String getDetaileddis() {
        return detaileddis;
    }

    public void setDetaileddis(String detaileddis) {
        this.detaileddis = detaileddis;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "id=" + id +
                ", projectname='" + projectname + '\'' +
                ", title='" + title + '\'' +
                ", simpledis='" + simpledis + '\'' +
                ", detaileddis='" + detaileddis + '\'' +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", remark='" + remark + '\'' +
                '}';
    }
}