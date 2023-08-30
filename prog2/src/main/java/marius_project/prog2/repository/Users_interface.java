package marius_project.prog2.repository;
import marius_project.prog2.model.Users;

import java.util.List;

public interface Users_interface {
    List<Users> findAll();
    Users findById(int id);
    void  insert(Users users);
    void update(Users users);
    void delete(int id);
}
