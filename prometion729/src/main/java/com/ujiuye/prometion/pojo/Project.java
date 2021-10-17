package com.ujiuye.prometion.pojo;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private Integer id;
    private String name;
    private String companyname;
    private String companyperson;
    private Integer customer_fk;
    private Integer employee_count;
    private Date starttime;
    private Date buildtime;
    private Integer cost;
    private String level;
    private Date endtime;
    private String remark;
    private Integer employee_fk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson;
    }

    public Integer getCustomer_fk() {
        return customer_fk;
    }

    public void setCustomer_fk(Integer customer_fk) {
        this.customer_fk = customer_fk;
    }

    public Integer getEmployee_count() {
        return employee_count;
    }

    public void setEmployee_count(Integer employee_count) {
        this.employee_count = employee_count;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEmployee_fk() {
        return employee_fk;
    }

    public void setEmployee_fk(Integer employee_fk) {
        this.employee_fk = employee_fk;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyname='" + companyname + '\'' +
                ", companyperson='" + companyperson + '\'' +
                ", customer_fk=" + customer_fk +
                ", employee_count=" + employee_count +
                ", starttime=" + starttime +
                ", buildtime=" + buildtime +
                ", cost=" + cost +
                ", level='" + level + '\'' +
                ", endtime=" + endtime +
                ", remark='" + remark + '\'' +
                ", employee_fk=" + employee_fk +
                '}';
    }
}