package marius_project.prog2.repository;

import java.util.List;

public interface List_interface {
    List<List> findAll();
    List findById(int id);
    void  insert(List lists);
    void update(List list);
    void delete(int id);
}
