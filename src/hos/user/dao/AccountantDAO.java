package hos.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hos.user.model.Accountant;

public class AccountantDAO {
	

	private String jdbcURL = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1998Jayamini";
	
	private static final String INSERT_Accountant_SQL = "INSERT INTO Accountant" + "  (Aid, FullName, Username, Password, Email, Phone, Position) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Accountant_BY_ID = "select Aid,FullName,Username,Password,Email,Phone,Position from Accountant where Aid =?";
	private static final String SELECT_ALL_Accountant = "select * from Accountant";
	private static final String DELETE_Accountant_SQL = "delete from Accountant where Aid = ?;";
	private static final String UPDATE_Accountant_SQL = "update Accountant set FullName = ?,Username= ?, Password =?, Email =?, Phone =?, Position =? where Aid = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//create doctor
	
	public void insertAccountant(Accountant accountant) throws SQLException {
		System.out.println(INSERT_Accountant_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Accountant_SQL)) {
			preparedStatement.setString(1, accountant.getAid());
			preparedStatement.setString(2, accountant.getFullName());
			preparedStatement.setString(3, accountant.getUsername());
			preparedStatement.setString(4, accountant.getPassword());
			preparedStatement.setString(5, accountant.getEmail());
			preparedStatement.setString(6, accountant.getPhone());
			preparedStatement.setString(7, accountant.getPosition());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update doctor
	
	public boolean updateAccountant(Accountant accountant) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Accountant_SQL);) {
			statement.setString(7, accountant.getAid());
			statement.setString(1, accountant.getFullName());
			statement.setString(2, accountant.getUsername());
			statement.setString(3, accountant.getPassword());
			statement.setString(4, accountant.getEmail());
			statement.setString(5, accountant.getPhone());
			statement.setString(6, accountant.getPosition());
		

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select doc by id
	public Accountant selectAccountant(String Aid) {
		Accountant accountant = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Accountant_BY_ID);) {
			preparedStatement.setString(1, Aid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Aid1 = rs.getString("Aid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				accountant = new Accountant(Aid1, Fullname, Username, Password, Email, Phone,Position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountant;
	}
	
	//select doctors
	
	public List<Accountant> selectAllAccountant() {
		
		 List<Accountant> accountant = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Accountant);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Aid =rs.getString("Aid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				accountant.add( new Accountant(Aid, Fullname, Username, Password, Email, Phone,Position));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountant;
	}
	
	//delete user
	
	public boolean deleteAccountant(String Aid) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Accountant_SQL);	){
			statement.setString(1, Aid);
			rowDeleted = statement.executeUpdate() > 0 ;
		}
		
		return rowDeleted;
	}
	
	

}
