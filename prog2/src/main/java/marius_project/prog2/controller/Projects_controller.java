package marius_project.prog2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import marius_project.prog2.model.Projects;
import marius_project.prog2.repository.Projects_interface;

import java.util.List;

@RestController
public class Projects_controller {

    private final Projects_interface projectsInterface;

    @Autowired
    public Projects_controller(Projects_interface projectsInterface) {
        this.projectsInterface = projectsInterface;
    }

    @GetMapping
    public List<Projects> getAllProjects() {
        return projectsInterface.findAll();
    }

    @GetMapping("/{id}")
    public Projects getProjectById(@PathVariable int id) {
        return projectsInterface.findById(id);
    }

    @PostMapping
    public void createProject(@RequestBody Projects project) {
        projectsInterface.insert(project);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable int id, @RequestBody Projects project) {
        Projects existingProject = projectsInterface.findById(id);
        if (existingProject != null) {
            existingProject.setProject_name(project.getProject_name());
            existingProject.setDestription(project.getDestription());
            existingProject.setCreate_date(project.getCreate_date());

            projectsInterface.update(existingProject);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id) {
        projectsInterface.delete(id);
    }
}
