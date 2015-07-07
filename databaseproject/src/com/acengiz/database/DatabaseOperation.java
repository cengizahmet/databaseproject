package com.acengiz.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.fabric.xmlrpc.base.Data;

public class DatabaseOperation {
	public static Connection connection = null; // manages connection
	public static Statement statement = null; // query statement
	public static ResultSet resultSet = null; // manages results
	public void openConnection(){


		try {
			// establish connection to database
			System.out.println("will establish connection to database");
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
			System.out.println("establishedd connection to database");



			System.out.println("afasfafaf");
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

	public void closeConnection(){

	}

	public void notes(){

	}
	
	public void ownNote(String accname, String accsurname){
		try {
			ResultSet rs = DatabaseOperation.resultSet;
			DatabaseOperation.statement = DatabaseOperation.connection.createStatement();
		

			// query database
			rs = DatabaseOperation.statement.executeQuery("SELECT name, surname,note FROM student");
			

			// process query results
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("number of columns is: " + numberOfColumns);
			//					if(rs != null)
			//							System.out.println("rs is not empty");


			while(rs.next()){

				if(rs.getString("name").equals(accname) && rs.getString("surname").equals(accsurname)){

					System.out.println("student note is: " + rs.getString("note"));

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeNote(String studentId, String name, String surname , String note){
		try {
			ResultSet rs = DatabaseOperation.resultSet;
			DatabaseOperation.statement = DatabaseOperation.connection.createStatement();
		

			// query database
			rs = DatabaseOperation.statement.executeQuery("SELECT name, surname,note, StudentID FROM student");
			

			// process query results
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("number of columns is: " + numberOfColumns);
			
			Statement statement2 = null;
			statement2 = connection.createStatement();

			while(rs.next()){

				if(rs.getString("name").equals(name) && rs.getString("surname").equals(surname) && rs.getString("StudentID").equals(studentId)){

					statement2.executeUpdate("UPDATE student SET note=" + note + " "+ "WHERE TC=" + studentId);
					System.out.println(rs.getString("note"));

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int addStudent(String name, String surname, int tcId){
		// last insert id	
		return 2423432;
	}

	public int login(String name, String surname) {
		// create Statement for querying database
		try {
			statement = connection.createStatement();
			System.out.println("created Statement for querying database");

			// query database
			resultSet = statement.executeQuery("SELECT name, surname,note, StudentID, academicianID FROM student");
			System.out.println("query database");

			// process query results
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("number of columns is: " + numberOfColumns);
			if(resultSet != null){
				System.out.println("Result set is not empty");
			}
			System.out.println(name);
			System.out.println(surname);
			while(resultSet.next()){
				
					if(resultSet.getString("name").equals(name) && resultSet.getString("surname").equals(surname)){
						System.out.println("ögrenci bulundu");
						if(resultSet.getInt("StudentID") != 0){
							System.out.println("kullanýcý öðrenci");
							return 1;
						}else if(resultSet.getInt("academicianID") != 0){
							System.out.println("kullanýcý öðrenci");
							return 2;
						}else{
							return 0;
						}
						
					}
				
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ögrenci bulunamadý");

		return 0;
	}

	

}
