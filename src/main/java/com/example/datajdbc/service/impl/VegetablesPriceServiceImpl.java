package com.example.datajdbc.service.impl;

import com.example.datajdbc.mapper.IncomeMapper;
import com.example.datajdbc.mapper.VegetablesPriceMapper;
import com.example.datajdbc.pojo.VegetablesPrice;
import com.example.datajdbc.service.VegetablesPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VegetablesPriceServiceImpl implements VegetablesPriceService {
    @Autowired
    VegetablesPriceMapper vegetablesPriceMapper;
    @Autowired
    IncomeMapper incomeMapper;
    @Override
    public boolean insertVegetablesPrice(VegetablesPrice vegetablesPrice) {
        return vegetablesPriceMapper.insetVegetablePrice(vegetablesPrice);
    }

    @Override
    public void delVegetablesPriceById(Integer id) {
        vegetablesPriceMapper.delVegetablePriceById(id);
    }

    @Override
    public boolean updataVegetablePrice(VegetablesPrice vegetablesPrice) {
        return vegetablesPriceMapper.updateVegetablePrice(vegetablesPrice);
    }

    @Override
    public List<VegetablesPrice> selectVegetablePrice() {
        return vegetablesPriceMapper.selectVegetablePriceAll();
    }

    @Override
    public Map getVegetablePriceAndIncomeById(Integer id) {
        Map<String,List> m1=new HashMap();
        String [] m2=incomeMapper.getIncomeYears(id);
        Integer[] year={2018,2019};
        for(int i=0;i<m2.length;i++){
            m1.put(m2[i],vegetablesPriceMapper.getVegetablePriceAndIncomeById(id, m2[i]));
        }
        return  m1;
    }
}
