package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import util.DBUtil;

public class CourseDao2 implements Serializable {

	// ��ѯ������Ʒ
	public static List<Course> Query() throws Exception {
		List<Course> result = new ArrayList<Course>(); // ��Ʒ����
		Connection conn = DBUtil.getSqliteConnection();
		PreparedStatement ptmt = conn.prepareStatement("select * from course");
		ResultSet rs = ptmt.executeQuery();
		// ѭ���õ���Ʒ
		while (rs.next()) {
			Course c = new Course();
			c.setCourid(rs.getInt("courid"));
			c.setCourname(rs.getString("courname"));
			c.setTeaname(rs.getString("teaname"));
			result.add(c);
		}
		return result; // ������Ʒ����
	}
	
	
		
}
