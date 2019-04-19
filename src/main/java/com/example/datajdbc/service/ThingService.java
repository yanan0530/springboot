package com.example.datajdbc.service;

import com.example.datajdbc.pojo.Thing;

import java.util.List;

public interface ThingService {
    List<Thing> getThingsAll();
    void addTing(Thing thing);
    void delThing(Integer id);
}
