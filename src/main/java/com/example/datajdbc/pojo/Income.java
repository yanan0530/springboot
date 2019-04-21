package com.example.datajdbc.pojo;

//收入单据
public class Income {
    private Integer id;
    private String datetime;
    private Integer vegetable;
    private Float money;
    private Float weight;
    private Float unitprice;
    private Integer sum;
    private Integer sumweight;
    private String name;//蔬菜中文名称
    private String itimeYearMounth;

    public String getItimeYearMounth() {
        return itimeYearMounth;
    }

    public void setItimeYearMounth(String itimeYearMounth) {
        this.itimeYearMounth = itimeYearMounth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSumweight() {
        return sumweight;
    }

    public void setSumweight(Integer sumweight) {
        this.sumweight = sumweight;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVegetable() {
        return vegetable;
    }

    public void setVegetable(Integer vegetable) {
        this.vegetable = vegetable;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }
}
