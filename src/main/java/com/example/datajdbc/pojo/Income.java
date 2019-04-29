package com.example.datajdbc.pojo;


public class Income {

  private Integer id;
  private String datetime;
  private Integer vegetable;
  private double money;
  private double weight;
  private double unitprice;
  private Integer projectId;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }


  public Integer getVegetable() {
    return vegetable;
  }

  public void setVegetable(Integer vegetable) {
    this.vegetable = vegetable;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }


  public double getUnitprice() {
    return unitprice;
  }

  public void setUnitprice(double unitprice) {
    this.unitprice = unitprice;
  }


  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

}
