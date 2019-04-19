package com.example.datajdbc.service.impl;

import com.example.datajdbc.mapper.ThingMapper;
import com.example.datajdbc.pojo.Thing;
import com.example.datajdbc.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingServiceImpl implements ThingService {
    @Autowired
    private ThingMapper thingMapper;

    @Override
    public List<Thing> getThingsAll() {
        return thingMapper.getThingAll();
    }

    @Override
    public void addTing(Thing thing) {
        thingMapper.insertThing(thing);
    }

    @Override
    public void delThing(Integer id) {
        thingMapper.delThing(id);
    }
}