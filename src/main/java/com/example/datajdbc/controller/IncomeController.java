package com.example.datajdbc.controller;

import com.example.datajdbc.mapper.IncomeMapper;
import com.example.datajdbc.pojo.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class IncomeController {
    @Autowired
    IncomeMapper incomeMapper;

    @GetMapping("/income")
    public List<Income> getIncomeList() {
        return incomeMapper.getIncomeList();
    }

    @PostMapping("/incomesave")
    public boolean insertIncome(@RequestBody Income income) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (income.getDatetime() == null) {
            income.setDatetime(df.format(date));
        }
        if (income.getId() == null) {
            incomeMapper.insertIncome(income);
        } else {
            incomeMapper.upIncomeById(income);
        }
        return true;
    }

    @GetMapping("/delincome")
    public boolean delIncomeById(@RequestParam("id") Integer id) {
        incomeMapper.delIncomeById(id);
        return true;
    }

    @GetMapping("/incomeall")
    public List<Income> getIncomeAll() {
        return incomeMapper.getIncomeAll();
    }

    @GetMapping("/incomeyear")
    public List<Income> getIncomeYear(@RequestParam("year") Integer year) {
        return incomeMapper.getIncomeYearMounth(year);
    }

    @GetMapping("incomes")
    public List<Income> getIncomeAllByConditions(@RequestParam(value = "type", defaultValue = "year") String type, @RequestParam(value = "date", defaultValue = "2019") String condistion) {
        return incomeMapper.getIncomeAllByConditions(type, condistion);
    }
}
