package marius_project.prog2.repository;

import marius_project.prog2.model.Projects;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Projects_interface {
    List<Projects>findAll();
    Projects findById(int id);
    void  insert(Projects projectS);
    void update(Projects projects);
    void delete(int id);

}
