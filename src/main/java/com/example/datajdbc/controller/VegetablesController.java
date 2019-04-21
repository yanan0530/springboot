package com.example.datajdbc.controller;

import com.example.datajdbc.mapper.VegetablesMapper;
import com.example.datajdbc.pojo.Vegetables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yn")
public class VegetablesController {
    @Autowired
    VegetablesMapper vegetablesMapper;

    @GetMapping("/vegelist")
    public List<Vegetables> getVegeList() {
        List<Vegetables> list = vegetablesMapper.VegList();
        System.err.println(list);
        return list;
    }

    @PostMapping("/vege")
    public Boolean insetVege(@RequestBody Vegetables vegetables) {
        if (vegetables.getId() == null) {
            vegetablesMapper.InsetVege(vegetables);
        } else {
            vegetablesMapper.upVegeById(vegetables);
        }
        return true;
    }

    @GetMapping("/vegedel")
    public Boolean delVege(@RequestParam("id") Integer id) {
        return vegetablesMapper.delVegetById(id);
    }

    @GetMapping("/vegeinit")
    public List<Vegetables> initVege() {
        return vegetablesMapper.vegStateList();
    }
}
