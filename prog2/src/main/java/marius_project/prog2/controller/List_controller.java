package marius_project.prog2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import marius_project.prog2.model.Lists;
import marius_project.prog2.repository.Lists_jdbc;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class List_controller {

    private final Lists_jdbc lists_jdbc;

    @Autowired
    public List_controller(Lists_jdbc lists_jdbc) {
        this.lists_jdbc = lists_jdbc;
    }

    @GetMapping
    public List<List> getAllLists() {
        return lists_jdbc.findAll();
    }

    @GetMapping("/{id}")
    public Lists getListById(@PathVariable int id) {
        return lists_jdbc.findById(id);
    }

}
