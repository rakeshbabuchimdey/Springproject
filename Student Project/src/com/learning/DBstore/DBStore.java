package com.learning.DBstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.learning.model.Student;
import com.learning.store.StudentStore;

public class DBStore implements StudentDB {
	String url = "jdbc:mysql://127.0.0.1:3306/studentdb";
	String user = "root";
	String password = "Rakesh@143";
	Connection conn;
	public DBStore() {
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

//select * from student;
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Student select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
