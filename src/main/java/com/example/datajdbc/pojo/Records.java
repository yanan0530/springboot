package com.example.datajdbc.pojo;


public class Records {

  private Integer id;
  private Integer projectid;
  private String createtime;
  private String thingid;
  private String remarks;
  private String areaid;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getProjectid() {
    return projectid;
  }

  public void setProjectid(Integer projectid) {
    this.projectid = projectid;
  }


  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public String getThingid() {
    return thingid;
  }

  public void setThingid(String thingid) {
    this.thingid = thingid;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getAreaid() {
    return areaid;
  }

  public void setAreaid(String areaid) {
    this.areaid = areaid;
  }

}
