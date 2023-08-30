package marius_project.prog2.repository;

import marius_project.prog2.model.Lists;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class Lists_jdbc {

    private final DataSource dataSource;

    public Lists_jdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<List> findAll() {
        List<Lists> lists = new ArrayList<>();
        String query = "SELECT * FROM Lists";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Lists list = mapRowToLists(resultSet);
                lists.add(list);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Collections.singletonList(lists);
    }

    public Lists findById(int id) {
        String query = "SELECT * FROM Lists WHERE list_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRowToLists(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Lists mapRowToLists(ResultSet resultSet) throws SQLException {
        return new Lists(
                resultSet.getInt("list_id"),
                resultSet.getString("list_name")
        );
    }
}
