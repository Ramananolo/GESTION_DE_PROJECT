package marius_project.prog2.repository;

import marius_project.prog2.model.Projects;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class Project_jdbc implements Projects_interface{
    private  final  DataSource dataSource;
    public Project_jdbc (DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Override
    public List<Projects> findAll() {
        List<Projects> projects = new ArrayList<>();
        String query = "SELECT * FROM projects";
        try (Connection connection =dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Projects project= mapRowToProjects(resultSet);
                projects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projects;
    }


    @Override
    public Projects findById(int id) {
        String query = "SELECT * FROM projects WHERE id_projects = ?";
        try (Connection connection =dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet =preparedStatement.executeQuery()) {
                if (resultSet.next()){
                    return mapRowToProjects(resultSet);
                }
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    private Projects mapRowToProjects(ResultSet resultSet) throws SQLException {
            Projects projects = new Projects(
                    resultSet.getInt("id_projects"),
                    resultSet.getString("project_name"),
                    resultSet.getString("Description"),
                    resultSet.getObject("create_date", LocalDate.class)
            );
        return projects;
    }

    // Autre methode CRUD



    @Override
    public void insert(Projects projects) {
      // Insertion avec l'utilisation une requête SQL
        String query = "INSERT INTO projects (id_projects, project_name ,Description , create_date) VALUES (?,?,?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
               preparedStatement.setInt(1,projects.getId_projects());
               preparedStatement.setString(2, projects.getProject_name());
               preparedStatement.setString(3, projects.getDestription());
               preparedStatement.setDate(4,java.sql.Date.valueOf(projects.getCreate_date()));

               preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Projects projects) {
          String query = "UPDATE projects SET  project_name = ? , create_date = ? WHERE id_projects = ? ";
          try (Connection connection = dataSource.getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                  preparedStatement.setString(1, projects.getProject_name());
                  preparedStatement.setDate(2,java.sql.Date.valueOf(projects.getCreate_date()));
                  preparedStatement.setInt(3,projects.getId_projects());

               preparedStatement.executeUpdate();
          }
          catch (SQLException e) {
              throw new RuntimeException(e);
          }
    }

    @Override
    public void delete(int id) {
         String query = "DELETE FROM projects WHERE id_projects = ?";
         try(Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);

                preparedStatement.executeUpdate();
         }
         catch (SQLException e){
             System.out.println(e);
         }
    }
}
