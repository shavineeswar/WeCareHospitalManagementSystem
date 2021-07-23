package hos.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import hos.user.model.Pharmacist;

public class PharmacistDAO {


	private String jdbcURL = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1998Jayamini";
	
	private static final String INSERT_Pharmacist_SQL = "INSERT INTO Pharmacist" + "  (PHid, FullName, Username, Password, Email, Phone, Position) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Pharmacist_BY_ID = "select PHid,FullName,Username,Password,Email,Phone,Position from Pharmacist where PHid =?";
	private static final String SELECT_ALL_Pharmacist = "select * from Pharmacist";
	private static final String DELETE_Pharmacist_SQL = "delete from Pharmacist where PHid = ?;";
	private static final String UPDATE_Pharmacist_SQL = "update Pharmacist set FullName = ?,Username= ?, Password =?, Email =?, Phone =?, Position =? where PHid = ?;";
	
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
	
	public void insertPharmacist(Pharmacist pharmacist) throws SQLException {
		System.out.println(INSERT_Pharmacist_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Pharmacist_SQL)) {
			preparedStatement.setString(1, pharmacist.getPHid());
			preparedStatement.setString(2, pharmacist.getFullName());
			preparedStatement.setString(3, pharmacist.getUsername());
			preparedStatement.setString(4, pharmacist.getPassword());
			preparedStatement.setString(5, pharmacist.getEmail());
			preparedStatement.setString(6, pharmacist.getPhone());
			preparedStatement.setString(7, pharmacist.getPosition());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update doctor
	
	public boolean updatePharmacist(Pharmacist pharmacist) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Pharmacist_SQL);) {
			statement.setString(7, pharmacist.getPHid());
			statement.setString(1, pharmacist.getFullName());
			statement.setString(2, pharmacist.getUsername());
			statement.setString(3, pharmacist.getPassword());
			statement.setString(4, pharmacist.getEmail());
			statement.setString(5, pharmacist.getPhone());
			statement.setString(6, pharmacist.getPosition());
		

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select doc by id
	public Pharmacist selectPharmacist(String PHid) {
		Pharmacist pharmacist = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Pharmacist_BY_ID);) {
			preparedStatement.setString(1, PHid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String PHid1 = rs.getString("PHid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				pharmacist = new Pharmacist(PHid1, Fullname, Username, Password, Email, Phone,Position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pharmacist;
	}
	
	//select doctors
	
	public List<Pharmacist> selectAllPharmacist() {
		
		 List<Pharmacist> pharmacist = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Pharmacist);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String PHid =rs.getString("PHid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				pharmacist.add( new Pharmacist(PHid, Fullname, Username, Password, Email, Phone,Position));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pharmacist;
	}
	
	//delete user
	
	public boolean deletePharmacist(String PHid) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Pharmacist_SQL);	){
			statement.setString(1, PHid);
			rowDeleted = statement.executeUpdate() > 0 ;
		}
		
		return rowDeleted;
	}
	
	
	
}
