package com.ilp04.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {

	//get connection
	
	public Connection getConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/bankdb";
		String userName ="root";
		String password ="experion@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL,userName,password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	//close connection
	public Connection closeConnection(Connection connection) {
		try {
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	//get all customer details
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList = new ArrayList<>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			while(resultSet.next()) {
				int customerCode =resultSet.getInt(1);
				String customerFirstName= resultSet.getString(2);
				String customerLastName= resultSet.getString(3);
				String address = resultSet.getString("address");
                long phNumber = resultSet.getLong("phonenumber");
                long adharNo = resultSet.getLong("aadhaarno");
 
                Customer customer = new Customer(customerCode, customerFirstName, customerLastName, address, phNumber, adharNo);
                customerList.add(customer);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return customerList;
	}
	
	
	// Insert customer
    public int insertCustomer(Connection connection, Customer customer) {
        String query = "INSERT INTO customer (customer_firstname, customer_lastname, address, phonenumber, aadhaarno) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getCustomer_firstname());
            preparedStatement.setString(2, customer.getCustomer_lastname());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getPhonenumber());
            preparedStatement.setLong(5, customer.getAadhaarno());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
    }
 
    //Update customer
//    public int updateCustomer(Connection connection, int customercode, String fieldName, Object newValue) {
//        String query = "UPDATE customer SET " + fieldName + " = ? WHERE customercode = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setObject(1, newValue);
//            preparedStatement.setInt(2, customercode);
//            return preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
    public int updateCustomer(Connection connection, int customercode, String fieldName, Object newValue) {
        String query = "UPDATE customer SET " + fieldName + " = '" + newValue + "' WHERE customercode = " + customercode;
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
