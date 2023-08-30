package marius_project.prog2.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {
    @Value("${DB_USERNAME:postgres}")
    private String username;

    @Value("${DB_PASSWORD:anna}")
    private String password;

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/trello",
                "postgres",
                "anna"
        );
    }
}
