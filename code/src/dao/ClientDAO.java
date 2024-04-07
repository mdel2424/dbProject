package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import util.DBConnection;

public class ClientDAO{

    private Connection connection;

    public ClientDAO() {
        connection = DBConnection.getConnection();

        if(connection == null){
            System.out.println("database is not connected");
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             
            while (resultSet.next()) {
                Client client = new Client();
                client.setSsn(resultSet.getInt("SSN"));
                client.setFullName(resultSet.getString("FullName"));
                client.setEmail(resultSet.getString("Address"));
                client.setRegistrationDate(resultSet.getDate("RegistrationDate"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Client getClient(int ssn) {
        String sql = "SELECT * FROM Client WHERE SSN = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ssn);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                Client client = new Client();
                client.setSsn(resultSet.getInt("SSN"));
                client.setFullName(resultSet.getString("FullName"));
                client.setEmail(resultSet.getString("Address"));
                client.setRegistrationDate(resultSet.getDate("RegistrationDate"));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertClient(Client client) {
        String sql = "INSERT INTO Client (SSN, FullName, email, RegistrationDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, client.getSsn());
            preparedStatement.setString(2, client.getFullName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setDate(4, new java.sql.Date(client.getRegistrationDate().getTime()));
            
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("User " +client.getEmail()+ " created");
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateClient(Client client) {
        String sql = "UPDATE Client SET FullName = ?, email = ?, RegistrationDate = ? WHERE SSN = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getFullName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(client.getRegistrationDate().getTime()));
            preparedStatement.setInt(4, client.getSsn());
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
