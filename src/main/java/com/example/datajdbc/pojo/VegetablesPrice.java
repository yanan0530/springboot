package com.example.datajdbc.pojo;


public class VegetablesPrice {

  private Integer id;
  private String name;
  private Integer vegetableId;
  private double unitprice;
  private String datetime;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getVegetableId() {
    return vegetableId;
  }
  public void setVegetableId(Integer vegetableId) {
    this.vegetableId = vegetableId;
  }

  public double getUnitprice() {
    return unitprice;
  }

  public void setUnitprice(double unitprice) {
    this.unitprice = unitprice;
  }


  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "VegetablesPrice{" +
            "id=" + id +
            ", vegetableId=" + vegetableId +
            ", unitprice=" + unitprice +
            ", datetime='" + datetime + '\'' +
            '}';
  }
}
