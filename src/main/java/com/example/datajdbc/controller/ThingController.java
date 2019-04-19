package com.example.datajdbc.controller;

import com.example.datajdbc.pojo.Thing;
import com.example.datajdbc.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThingController {

    @Autowired
    private ThingService thingService;

    @GetMapping("/thing")
    public List<Thing> getThingAll(){
        return thingService.getThingsAll();
    }

    @PostMapping("/thing")
    public boolean addThing(@RequestBody Thing thing){
        if (thing.getId()==null){
            thingService.addTing(thing);
        }else {

        }
        return true;
    }
    @GetMapping("/thingdel")
    public boolean delThing(@RequestParam("id") Integer id){
        thingService.delThing(id);
        return true;
    }

}
