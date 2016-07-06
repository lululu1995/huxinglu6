package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DBUtil;


public class UserDao {
private static UserDao service;

	
	public static UserDao getInstance() {
		if(service == null) {
			service = new UserDao();
		}
		return service;
	}

	
	public List<User> getUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		Connection conn = DBUtil.getSqliteConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from [user]");
		try {
			while (rs.next()) {
				User c = this.getUserFromRs(rs);
				users.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return users;
	}
	
	private User getUserFromRs(ResultSet rs) {
		User c = new User();
		try {
			c.setUid(rs.getInt("uid"));
			c.setUsername(rs.getString("username"));
			c.setGrade(rs.getString("grade"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

    public void addUser(User us) throws SQLException{
  	  Connection conn=DBUtil.getSqliteConnection();

		 PreparedStatement stmt = conn.prepareStatement("insert into [user](username,password,email(?,?,?)");
			stmt.setString(1, us.getUsername());			
			stmt.setString(2,us.getPassword());
	
			//stmt.addBatch();
			//stmt.executeBatch();
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
    }

    public String selectUser(String Username) throws SQLException{		
		Connection conn=DBUtil.getSqliteConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from [user] where username=? ");
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, Username);
		ResultSet rs=ptmt.executeQuery();
		String pwd="";
		while(rs.next()){
			
			 pwd=	rs.getString("password");
			
		}
		return pwd;
	
}

public static List<User> getAllUsers() //获取所有类别
{
	List<User> allUsers=new ArrayList<User>();
	ResultSet rs = null;
	Connection connection = DBUtil.getSqliteConnection();
	PreparedStatement pstat;
	try {
			pstat = connection
					.prepareStatement("select * from [user]");
		rs = pstat.executeQuery();
		if(rs!=null){
			while(rs.next())
			//赋值
			{
				User us=new User();
				us.setUsername(rs.getString("username"));
				allUsers.add(us);
			}
		}
		rs.close();
		pstat.close();
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return allUsers;
}

public static boolean deleteUser(int uid) {
	int i = 0;
	Connection connection = DBUtil.getSqliteConnection();
	PreparedStatement pstat;
	try {
		pstat = connection
				.prepareStatement("delete from [user] where uid=?");
		pstat.setInt(1, uid);
		i = pstat.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i > 0;
}

}
