package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Course;
import util.DBUtil;

public class CourseDao {
private static CourseDao service;

	
	public static CourseDao getInstance() {
		if(service == null) {
			service = new CourseDao();
		}
		return service;
	}

	
	public List<Course> getCourse() throws SQLException {
		List<Course> courses = new ArrayList<Course>();
		Connection conn = DBUtil.getSqliteConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from course");
		try {
			while (rs.next()) {
				Course c = this.getCourseFromRs(rs);
				courses.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return courses;
	}
	
	private Course getCourseFromRs(ResultSet rs) {
		Course c = new Course();
		try {
			c.setCourid(rs.getInt("courid"));
			c.setCourname(rs.getString("courname"));
			c.setTeaname(rs.getString("teaname"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public void updateCourse(Course per) throws SQLException{
		Connection conn=DBUtil.getSqliteConnection();
		
		PreparedStatement stmt=conn.prepareStatement( "update course set courname=?,teaname=? where courid=?");
		 stmt.setString(1, per.getCourname());	
		 stmt.setString(2, per.getTeaname());
		 stmt.setInt(3, per.getCourid());
	
			stmt.executeUpdate();
		
			stmt.close();
			conn.close();
		}
	public static boolean deleteCourse(int courid) {
		int i = 0;
		Connection connection = DBUtil.getSqliteConnection();
		PreparedStatement pstat;
		try {
			pstat = connection
					.prepareStatement("delete from course where courid=?");
			pstat.setInt(1, courid);
			i = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i > 0;
	}
}
