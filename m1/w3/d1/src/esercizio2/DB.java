package esercizio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DB {

	String url = "jdbc:postgresql://localhost:5432/esercizio2?useSSL=false";
    String username = "postgres";
    String password = "postgres";
    Connection conn = null;
    
    public void connect() {
        try {
            System.out.println("Connecting to database " + url);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is successful!");
          }
          catch(Exception e) {
              e.printStackTrace();
          }
    }
    
    public void disconnect() {
        if( conn != null ) {
            try {
                conn.close();
                System.out.println("Disonnection is successful!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void insertStudent(String name, String lastname, String gender, LocalDate birthdate, double avg, int min_vote, int max_vote) {
    	try {
    		String sql = "INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote) VALUES (?, ?, ?, ?, ?, ?, ?)";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, name);
    		stmt.setString(2, lastname);
    		stmt.setString(3, gender);
    		stmt.setObject(4, birthdate);
    		stmt.setDouble(5, avg);
    		stmt.setInt(6, min_vote);
    		stmt.setInt(7, max_vote);
    		stmt.execute();
    		System.out.println("Insert is successful");
    	} catch(SQLException e) {
    		System.out.println("There was an error during inserting data");
    		e.printStackTrace();
    	}
    }
    
    public void updateStudents(int id, String name, String lastname) {
    	try {
    		String sql = "UPDATE school_students SET name = ?, lastname = ? WHERE id = ?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, name);
    		stmt.setString(2, lastname);
    		stmt.setInt(3, id);
    		stmt.execute();
    		System.out.println("Studens was modified succesful");
    	}catch (SQLException e) {
    		System.out.println("There was an error during updating data");
    		e.printStackTrace();
    	}
    }
    
    public void deleteStudent(int id) {
    	try {
    		String sql = "DELETE FROM school_students WHERE id = ?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, id);
    		stmt.execute();    	
    		System.out.println("Delete student is successful");
    	}catch(SQLException e) {
    	System.out.println("There was an error during deleting data");
    	e.printStackTrace();
    	}
    }
    
   /* public void getBest() {
    	try {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM school_students WHERE avg = ?");
    		while(rs.next()) {
    			double actualAVG = rs.getDouble(1);
    		}
    	}catch (SQLException e) {
    		System.out.println("There was an error during selecting data");
    		e.printStackTrace();
    	}
    }*/
}
