package hos.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hos.user.model.Admin;


public class AdminDAO {

	private	String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private	String driverName = "com.mysql.cj.jdbc.Driver";
	private	String username = "root";
	private	String password = "1998Jayamini";
	
	private static final String INSERT_ADMIN_SQL = "INSERT INTO admin" + "  (Aid, FullName , Username , Password , Email ) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_ADMIN_BY_ID = "select Aid,FullName,Username,Password,Email  from admin where Aid=?";
	private static final String SELECT_ALL_ADMIN = "select * from admin";
	private static final String DELETE_ADMIN_SQL = "delete from admin where Aid  = ?;";
	private static final String UPDATE_ADMIN_SQL = "update admin set FullName=?, Username=?,Password=?,Email=?  where Aid=?;";
	
	public AdminDAO()
	{
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertAdmin(Admin admin) throws SQLException {
		System.out.println(INSERT_ADMIN_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
			preparedStatement.setString(1, admin.getAid());
			preparedStatement.setString(2, admin.getFullName());
			preparedStatement.setString(3, admin.getUsername());
			preparedStatement.setString(4, admin.getPassword());
			preparedStatement.setString(5, admin.getEmail());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			printSQLException(e);
		}
	}
	
	public List<Admin> selectAllAdmin() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Admin> admin = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMIN);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Aid = rs.getString("Aid");
				String FullName = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				
				admin.add(new Admin(Aid, FullName, Username,Password, Email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admin;
	}
	
	public Admin selectAdmin(String Aid) {
		Admin admin = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);) {
			preparedStatement.setString(1, Aid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Aid1 = rs.getString("Aid");
				String FullName = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");

				admin = new Admin(Aid1, FullName, Username, Password, Email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	public boolean updateAdmin(Admin admin) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL);) {
			statement.setString(5, admin.getAid());
			statement.setString(1, admin.getFullName());
			statement.setString(2, admin.getUsername());
			statement.setString(3, admin.getPassword());
			statement.setString(4, admin.getEmail());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deleteAdmin(String Aid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);) {
			statement.setString(1, Aid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
