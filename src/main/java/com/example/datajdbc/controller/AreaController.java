package com.example.datajdbc.controller;

import com.example.datajdbc.pojo.Area;
import com.example.datajdbc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yn")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/area")
    public List<Area> getAreaAll() {
        return areaService.getAreaAll();
    }

    @PostMapping("/area/save")
    public boolean saveArea(@RequestBody Area area) {
        if (area.getId() == null) {
            areaService.addArea(area);
        } else {
            areaService.updateAreaById(area);
        }
        return true;
    }

    @GetMapping("/area/del")
    public boolean delArea(@RequestParam(value = "id", required = true) Integer id) {
        areaService.delArea(id);
        return true;
    }
}
