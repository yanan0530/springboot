package com.example.datajdbc.service;

import com.example.datajdbc.pojo.VegetablesPrice;

import java.util.List;
import java.util.Map;

public interface VegetablesPriceService {
    boolean insertVegetablesPrice(VegetablesPrice vegetablesPrice);
    void delVegetablesPriceById(Integer id);
    boolean updataVegetablePrice(VegetablesPrice vegetablesPrice);
    List<VegetablesPrice> selectVegetablePrice();

    Map getVegetablePriceAndIncomeById(Integer id);
}
