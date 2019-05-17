package com.example.datajdbc.controller;

import com.example.datajdbc.pojo.VegetablesPrice;
import com.example.datajdbc.service.VegetablesPriceService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/yn/vp")
public class VegetablesPriceController {

    @Autowired
    VegetablesPriceService vegetablesPriceService;

    @PostMapping("save")
    public boolean insertVegetablesPrice(@RequestBody VegetablesPrice vegetablesPrice){
        if(vegetablesPrice.getId() == null){
                return vegetablesPriceService.insertVegetablesPrice(vegetablesPrice);
            }else{
                return vegetablesPriceService.updataVegetablePrice(vegetablesPrice);
            }
    }
    @GetMapping("del")
    public boolean delVegetablesPrice(@RequestParam("id") Integer id){
        vegetablesPriceService.delVegetablesPriceById(id);
        return true;
    }
    @GetMapping("list")
    public List<VegetablesPrice> selectVegetablesPrice(){
        return vegetablesPriceService.selectVegetablePrice();
    }

    @GetMapping("lists")
    public Map setVegetablesPriceAndIncomeById(@RequestParam(value = "id",defaultValue = "1") Integer id){
        return vegetablesPriceService.getVegetablePriceAndIncomeById(id);
    }

}
