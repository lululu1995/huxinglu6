package model;

	import java.util.ArrayList;
	import java.util.Collection;

import util.DBUtil;

import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class Teacher {
		private int tid;
		private String teaname;
		private String teapsd;

		public int getTid() {
			return tid;
		}
		public void setTid(int tid) {
			this.tid = tid;
		}

		public String getTeaname() {
			return teaname;
		}
		public void setTeaname(String teaname) {
			this.teaname = teaname;
		}
		public String getTeapsd() {
			return teapsd;
		}
		public void setTeapsd(String teapsd) {
			this.teapsd = teapsd;
		}
		
		public void update(Teacher t) throws SQLException{
			Connection conn=DBUtil.getSqliteConnection();
			PreparedStatement stmt=conn.prepareStatement("update teacher set tid=?,teaname=?,teapsd=?");
			stmt.setInt(1, t.getTid());
			stmt.setString(2, t.getTeaname());
			stmt.setString(3, t.getTeapsd());
			stmt.executeUpdate();
			stmt.close();
			conn.close();

		}

	}


