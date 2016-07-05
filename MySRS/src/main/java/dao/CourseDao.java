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
import model.CourseCatalog;
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
	/*
	public List<Course> getHotBook() throws SQLException {
		List<Course> course = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from course order by frequency desc");
		try {
			while (rs.next()) {
				course c = this.getHotBookFromRs(rs);
				course.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return course;
	}
	
	private course getHotBookFromRs(ResultSet rs) {
		course c = new course();
		try {
			c.setBid(rs.getInt("bid"));
			
			c.setBookname(rs.getString("bookname"));
            c.setPho1(rs.getString("pho1"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static List<Course> selectBookByName(String bookname) throws SQLException{		
		Connection conn=DBUtil.getConnection();
		List<Course> result = new ArrayList<Course>();
		String bne="";
		bne="%"+bookname+"%";
		StringBuilder sb=new StringBuilder();
		sb.append("select * from course where bookname like ?");
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, bne);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			course books=new course();
			books.setBid(rs.getInt("bid"));
			books.setUsername(rs.getString("username"));
			books.setBookname(rs.getString("bookname"));
			books.setWriter(rs.getString("writer"));
			books.setPress(rs.getString("press"));
			books.setDescription(rs.getString("description"));
			books.setState(rs.getString("state"));
			books.setFrequency(rs.getInt("frequency"));
				result.add(books);
		}
		return  result;
	
}
	public List search(String keyword){
		List list=new ArrayList();
		Connection conn=DBUtil.getConnection();
		String sql="select * from course where bookname like'%'+?+'%' ";
		
		
		try {
			
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, keyword);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				course books=new course();
				books.setBid(rs.getInt("bid"));
				books.setUsername(rs.getString("username"));
				books.setBookname(rs.getString("bookname"));
				books.setWriter(rs.getString("writer"));
				books.setPress(rs.getString("press"));
				books.setDescription(rs.getString("description"));
				books.setState(rs.getString("state"));
				books.setFrequency(rs.getInt("frequency"));
				books.setPho1(rs.getString("pho1"));
				list.add(books);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	*/
