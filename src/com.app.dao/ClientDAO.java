package com.app.dao;

import com.app.model.Client;
import com.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private Connection connection;

    public ClientDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             
            while (resultSet.next()) {
                Client client = new Client();
                client.setSsn(resultSet.getString("SSN"));
                client.setFullName(resultSet.getString("FullName"));
                client.setAddress(resultSet.getString("Address"));
                client.setRegistrationDate(resultSet.getDate("RegistrationDate"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Client getClient(String ssn) {
        String sql = "SELECT * FROM Client WHERE SSN = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ssn);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                Client client = new Client();
                client.setSsn(resultSet.getString("SSN"));
                client.setFullName(resultSet.getString("FullName"));
                client.setAddress(resultSet.getString("Address"));
                client.setRegistrationDate(resultSet.getDate("RegistrationDate"));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertClient(Client client) {
        String sql = "INSERT INTO Client (SSN, FullName, Address, RegistrationDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getSsn());
            preparedStatement.setString(2, client.getFullName());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setDate(4, new java.sql.Date(client.getRegistrationDate().getTime()));
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateClient(Client client) {
        String sql = "UPDATE Client SET FullName = ?, Address = ?, RegistrationDate = ? WHERE SSN = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getFullName());
            preparedStatement.setString(2, client.getAddress());
            preparedStatement.setDate(3, new java.sql.Date(client.getRegistrationDate().getTime()));
            preparedStatement.setString(4, client.getSsn());
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteClient(String ssn) {
        String sql = "DELETE FROM Client WHERE SSN = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ssn);
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
