package com.example.datajdbc.controller;

import com.example.datajdbc.pojo.Records;
import com.example.datajdbc.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yn/records")
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @GetMapping("/list")
    public List<Records> getRecordsAll() {
        return recordsService.getRecordsAll();
    }

    @PostMapping("/save")
    public boolean saveRecords(@RequestBody List<Records> records) {
        System.out.println(records);
        for(int i=0;i<records.size();i++){
            if ( records.get(i).getId()==null) {
                recordsService.insertRecords(records.get(i));
            } else {
                recordsService.updateRecords(records.get(i));
            }
        }
        return true;
    }

    @GetMapping("/del")
    public boolean delRecordsByid(@RequestParam("id") Integer id){
        recordsService.delRecords(id);
        return true;
    }
}
