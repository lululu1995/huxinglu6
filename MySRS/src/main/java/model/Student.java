package model;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
	private int id;
	private String name;
	private String password;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void update(Student s) throws SQLException{
		Connection conn=DbUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement("update student set id=?,name=?,password=?");
		stmt.setInt(1, s.getId());
		stmt.setString(2, s.getName());
		stmt.setString(3, s.getPassword());
		stmt.executeUpdate();
		stmt.close();
		conn.close();

	}

}
