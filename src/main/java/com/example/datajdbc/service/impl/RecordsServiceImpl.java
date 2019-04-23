package com.example.datajdbc.service.impl;

import com.example.datajdbc.mapper.RecordsMapper;
import com.example.datajdbc.pojo.Records;
import com.example.datajdbc.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
@Transactional
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordsMapper recordsMapper;
    @Override
    public List<Records> getRecordsAll() {
        return recordsMapper.getRecordsAll();
    }

    @Override
    public void insertRecords(Records records) {
        recordsMapper.saveRecords(records);
    }

    @Override
    public void delRecords(Integer id) {
        recordsMapper.delRecords(id);
    }

    @Override
    public void updateRecords(Records records) {
        recordsMapper.updateRecordsById(records);
    }
}
