package com.example.datajdbc.service;

import com.example.datajdbc.pojo.Records;

import java.util.List;

public interface RecordsService {
    List<Records> getRecordsAll();
    void insertRecords(Records records);

    void delRecords(Integer id);

    void updateRecords(Records records);
}
