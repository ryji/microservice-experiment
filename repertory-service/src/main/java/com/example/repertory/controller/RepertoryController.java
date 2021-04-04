package com.example.repertory.controller;

import com.example.repertory.model.Repertory;
import com.example.repertory.services.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/repertory")
public class RepertoryController {

    @Autowired
    RepertoryService repertoryService;

    @GetMapping("/{id}")
    public Repertory getRepertory(@PathVariable(value = "id") Long id) {

        return repertoryService.getRepertoryById(id);
    }

    @PostMapping("/ids")
    public List<Repertory> getRepertoryList(@RequestBody List<Long> ids) {

        return repertoryService.getRepertoryListByIds(ids);
    }


    @PostMapping(value = "/")
    public Repertory updateRepertory(@RequestBody Repertory repertory) {
        return repertoryService.updateRepertory(repertory);
    }

    @PutMapping(value = "/")
    public Repertory addRepertory(@RequestBody Repertory repertory) {
        return repertoryService.addRepertory(repertory);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRepertoryById(@PathVariable(value = "id") Long id) {
        return repertoryService.deleteRepertoryById(id);
    }

}
