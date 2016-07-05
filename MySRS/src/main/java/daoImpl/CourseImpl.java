package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ICourse;
import model.Course;
import util.DBUtil;

public class CourseImpl implements ICourse {

	public List<Course> getAllCourses(){
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "select * from Course";
		List<Course> inventory = new ArrayList<Course>();
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				
			}			
			rs.close();
			pstmt.close();
			Conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e){
		    e.printStackTrace();	
		}finally{
			try{
		         if(Conn!=null)
		        	 Conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		return inventory;
	}
		
		
		
		
		 public void deleteGuitar(int ID) {
				// TODO Auto-generated method stub
				String sql="delete from Course where ID=?";
				Connection conn=DBUtil.getSqliteConnection();
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, ID);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}


		@Override
		public List<Course> getAllGuitars() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void addGuitar(int courid, String courname, String teaname) {
			// TODO Auto-generated method stub
			
		}

}