package marius_project.prog2.repository;

import marius_project.prog2.model.Boards;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Boards_jdbc {

    private final DataSource dataSource;

    public Boards_jdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Boards> findAll() {
        List<Boards> boardsList = new ArrayList<>();
        String query = "SELECT * FROM Boards";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Boards board = mapRowToBoards(resultSet);
                boardsList.add(board);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boardsList;
    }

    public Boards findById(int id) {
        String query = "SELECT * FROM Boards WHERE id_boards = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRowToBoards(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Boards mapRowToBoards(ResultSet resultSet) throws SQLException {
        return new Boards(
                resultSet.getInt("id_boards"),
                resultSet.getString("Board_name"),
                resultSet.getInt("id_projects"),
                resultSet.getInt("list_id")
        );
    }
}
