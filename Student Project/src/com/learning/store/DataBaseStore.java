package com.learning.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.model.Student;

public class DataBaseStore implements StudentStore {
	String url = "jdbc:mysql://127.0.0.1:3306/studentdb";
	String user = "root";
	String password = "Rakesh@143";
	Connection conn;

	public DataBaseStore() {
		try {
			conn=DriverManager.getConnection(url,user,password);
			if(conn!=null)
			{
				System.out.println("Connected to database");
			}
			else {
				System.out.println("Not connected to Database");
			}
		}
		 catch(SQLException e){
			e.printStackTrace(); 
		}
	}
	
	@Override
	public void insert(Student student) {
		String sql = "INSERT INTO student (name, address) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getAddress());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(int studentId) {
		String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A student was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(Student student) {
		String sql = "UPDATE student SET name = ?, address = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getAddress());
            stmt.setInt(3, student.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Student select(int studentId) {
		String sql = "SELECT id,name,address FROM student where id =?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, studentId);
        	ResultSet rs= stmt.executeQuery();
        	Student student=null;
        	while(rs.next()) {
        		int id=rs.getInt(1);
        		String name=rs.getString(2);
        		String address=rs.getString(3);
        		student=new Student(id, name, address);
        		System.out.println(student);
        		break;
        		//System.out.println();
//        		return student;
        	}
        	return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public int count() {
		String sql="SELECT COUNT(*) from student";
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public Student[] selectAll() {
		String sql="SELECT * FROM student";
		List<Student> students = new ArrayList<>();
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			Student student=null;
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String address=rs.getString("address");
				student=new Student(id, name, address);
				students.add(student);
				//Student student=new Student(id, name, address);
				System.out.println(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        //return students.toArray(new Student[0]);
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
