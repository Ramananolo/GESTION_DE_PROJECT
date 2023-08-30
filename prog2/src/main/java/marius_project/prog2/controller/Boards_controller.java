package marius_project.prog2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import marius_project.prog2.model.Boards;
import marius_project.prog2.repository.Boards_jdbc;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class Boards_controller {

    private Boards_jdbc boards_jdbc;

    @Autowired
    public void BoardsController(Boards_jdbc boards_jdbc) {
        this.boards_jdbc = boards_jdbc;
    }

    public Boards_controller(Boards_jdbc boardsJdbc) {
        boards_jdbc = boardsJdbc;
    }

    @GetMapping
    public List<Boards> getAllBoards() {
        return boards_jdbc.findAll();
    }

    @GetMapping("/{id}")
    public Boards getBoardById(@PathVariable int id) {
        return boards_jdbc.findById(id);
    }
}
