package marius_project.prog2.model;
import java.time.LocalDate;
public class Projects {
    private  int id_projects;
    private String project_name;
    private String Destription;
    private LocalDate create_date;

    public Projects(int idProjects, String project_name, String destription, LocalDate create_date) {
        this.id_projects = id_projects;
        this.project_name = project_name;
        Destription = destription;
        this.create_date = create_date;
    }

    public int getId_projects() {
        return id_projects;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getDestription() {
        return Destription;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setId_projects(int id_projects) {
        this.id_projects = id_projects;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setDestription(String destription) {
        Destription = destription;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id_projects=" + id_projects +
                ", project_name='" + project_name + '\'' +
                ", Destription='" + Destription + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
