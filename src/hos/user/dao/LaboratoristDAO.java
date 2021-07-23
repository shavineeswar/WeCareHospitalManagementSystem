package hos.user.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import hos.user.model.Laboratorist;

public class LaboratoristDAO {


	private String jdbcURL = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1998Jayamini";
	
	private static final String INSERT_Laboratorist_SQL = "INSERT INTO Laboratorist" + "  (Lid, FullName, Username, Password, Email, Phone, Position) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Laboratorist_BY_ID = "select Lid,FullName,Username,Password,Email,Phone,Position from Laboratorist where Lid =?";
	private static final String SELECT_ALL_Laboratorist = "select * from Laboratorist";
	private static final String DELETE_Laboratorist_SQL = "delete from Laboratorist where Lid = ?;";
	private static final String UPDATE_Laboratorist_SQL = "update Laboratorist set FullName = ?,Username= ?, Password =?, Email =?, Phone =?, Position =? where Lid = ?;";
	
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
	
	public void insertLaboratorist(Laboratorist laboratorist) throws SQLException {
		System.out.println(INSERT_Laboratorist_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Laboratorist_SQL)) {
			preparedStatement.setString(1, laboratorist.getLid());
			preparedStatement.setString(2, laboratorist.getFullName());
			preparedStatement.setString(3, laboratorist.getUsername());
			preparedStatement.setString(4, laboratorist.getPassword());
			preparedStatement.setString(5, laboratorist.getEmail());
			preparedStatement.setString(6, laboratorist.getPhone());
			preparedStatement.setString(7, laboratorist.getPosition());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update doctor
	
	public boolean updateLaboratorist(Laboratorist laboratorist) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Laboratorist_SQL);) {
			statement.setString(7, laboratorist.getLid());
			statement.setString(1, laboratorist.getFullName());
			statement.setString(2, laboratorist.getUsername());
			statement.setString(3, laboratorist.getPassword());
			statement.setString(4, laboratorist.getEmail());
			statement.setString(5, laboratorist.getPhone());
			statement.setString(6, laboratorist.getPosition());
		

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select doc by id
	public Laboratorist selectLaboratorist(String Lid) {
		Laboratorist laboratorist = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Laboratorist_BY_ID);) {
			preparedStatement.setString(1, Lid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Lid1 = rs.getString("Lid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				laboratorist = new Laboratorist(Lid1, Fullname, Username, Password, Email, Phone,Position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return laboratorist;
	}
	
	//select doctors
	
	public List<Laboratorist> selectAllLaboratorist() {
		
		 List<Laboratorist> laboratorist = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Laboratorist);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Lid =rs.getString("Lid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				laboratorist.add( new Laboratorist(Lid, Fullname, Username, Password, Email, Phone,Position));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return laboratorist;
	}
	
	//delete user
	
	public boolean deleteLaboratorist(String Lid) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Laboratorist_SQL);	){
			statement.setString(1, Lid);
			rowDeleted = statement.executeUpdate() > 0 ;
		}
		
		return rowDeleted;
	}
	
	
}
