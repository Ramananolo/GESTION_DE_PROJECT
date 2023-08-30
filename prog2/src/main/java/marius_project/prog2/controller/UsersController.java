package marius_project.prog2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import marius_project.prog2.model.Users;
import marius_project.prog2.repository.Users_jdbc;

import java.util.List;

@RestController
@RequestMapping("/users")  // Chemin de base pour les requêtes liées aux utilisateurs
public class UsersController {

    private final Users_jdbc usersRepository;

    @Autowired
    public UsersController(Users_jdbc usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {
        return usersRepository.findById(id);
    }

    @PostMapping
    public void createUser(@RequestBody Users user) {
        usersRepository.insert(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody Users user) {
        Users existingUser = usersRepository.findById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());

            usersRepository.update(existingUser);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        usersRepository.delete(id);
    }
}
