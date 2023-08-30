package marius_project.prog2.repository;
import marius_project.prog2.model.Boards;

import java.util.List;

public interface Boards_interface {
    List<Boards> findAll();
    Boards findById(int id);
    void  insert(Boards boards);
    void update(Boards boards);
    void delete(int id);
}
