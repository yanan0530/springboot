package com.example.datajdbc.service;

import com.example.datajdbc.pojo.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaAll();
    void addArea(Area area);

    void delArea(Integer id);

    void updateAreaById(Area area);
}
