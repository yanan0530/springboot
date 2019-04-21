package com.example.datajdbc.service.impl;

import com.example.datajdbc.mapper.AreaMapper;
import com.example.datajdbc.pojo.Area;
import com.example.datajdbc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAreaAll() {
        return areaMapper.getAreaAll();
    }

    @Override
    public void addArea(Area area) {
        areaMapper.insertArea(area);
    }

    @Override
    public void delArea(Integer id) {
        areaMapper.deleteAreaById(id);
    }

    @Override
    public void updateAreaById(Area area) {
        areaMapper.updateArea(area);
    }
}
