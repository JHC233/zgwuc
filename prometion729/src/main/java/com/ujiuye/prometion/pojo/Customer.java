package com.ujiuye.prometion.pojo;

import java.util.Date;

public class Customer {
  private Integer id;
  private String name;
  private String companyperson;
  private String address;
  private String phone;
  private String camera;
  private String present;
  private String remark;
  private Date addtime;

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

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyperson='" + companyperson + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", camera='" + camera + '\'' +
                ", present='" + present + '\'' +
                ", remark='" + remark + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}
