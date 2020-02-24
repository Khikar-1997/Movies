package com.company.service;


import com.company.MariaDbConstant;
import com.company.movie.Movie;

import java.sql.*;

class MoviesService {
    static MoviesService instance = new MoviesService();

    private MoviesService() {
    }

    void create(Movie movie) {
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "INSERT INTO films(name,genre,duration) VALUES(?,?,?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setString(2, movie.getGenre());
                preparedStatement.setString(3, movie.getDuretion());
                preparedStatement.executeQuery();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!!!!");
        }
    }

    void selectById(int id) {
        Movie movie = new Movie();
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "SELECT * FROM films WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    movie.setName(resultSet.getNString("name"));
                    movie.setGenre(resultSet.getString("genre"));
                    movie.setDuretion(resultSet.getString("duration"));
                }
                resultSet.close();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!");
        }
    }

    void updateById(Movie movie, int id) {
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "UPDATE films SET name = ?,genre = ?,duration = ? WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setString(2, movie.getGenre());
                preparedStatement.setString(3, movie.getDuretion());
                preparedStatement.setInt(4, id);
                preparedStatement.executeQuery();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!");
        }
    }

    void deleteById(int id) {
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null){
                String query = "Delete FROM films WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!!");
        }
    }
}
