package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eb.java.tool.DbUtil;


public class BookService {
private static BookService service;
	
	private BookService() {}
	
	public static BookService getInstance() {
		if(service == null) {
			service = new BookService();
		}
		return service;
	}
	
	public List<Book> getBooks(String username) {
		Connection conn = DbUtil.getConnection();
		
		Statement stmt = DbUtil.getStatement(conn);
		String sql = "select * from book where username='"+username+"'";
		ResultSet rs = DbUtil.getResultSet(stmt, sql);
	
		List<Book> books = new ArrayList<Book>();
		try {
			while (rs.next()) {
				Book b = getBookFromRs(rs);
				books.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(stmt);
			DbUtil.close(rs);
			DbUtil.close(conn);
			
			
		}

		return books;
	}
	public Book getBook(int bid) throws SQLException{
		Connection conn = DbUtil.getConnection();
		Statement stmt = DbUtil.getStatement(conn);
		String sql = "select * from book where bid='"+bid+"'";
		ResultSet rs = DbUtil.getResultSet(stmt, sql);
		Book b = new Book();
		while (rs.next()) {
		b.setBid(rs.getInt("bid"));
		b.setBookname(rs.getString("bookname"));
		b.setDescription(rs.getString("description"));
		b.setWriter(rs.getString("writer"));
		b.setState(rs.getString("state"));
		b.setCategoryid(rs.getInt("categoryid"));
		b.setPress(rs.getString("press"));
		b.setPho1(rs.getString("pho1"));
		b.setPho2(rs.getString("pho2"));
		b.setPho3(rs.getString("pho3"));
		}

		return b;
	}
	public List<Book> getBooks(int categoryid) {
		Connection conn = DbUtil.getConnection();
		
		Statement stmt = DbUtil.getStatement(conn);
		String sql = "select * from book where categoryid='"+categoryid+"'";
		ResultSet rs = DbUtil.getResultSet(stmt, sql);
	
		List<Book> books = new ArrayList<Book>();
		try {
			while (rs.next()) {
				Book b = getBookFromRs(rs);
				books.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(stmt);
			DbUtil.close(rs);
			DbUtil.close(conn);
			
			
		}

		return books;
	}
	private Book getBookFromRs(ResultSet rs) {
		Book b = new Book();
		try {
			
			b.setBid(rs.getInt("bid"));
			b.setUsername(rs.getString("username"));
			b.setBookname(rs.getString("bookname"));
			b.setDescription(rs.getString("description"));
			b.setWriter(rs.getString("writer"));
			b.setState(rs.getString("state"));
			b.setCategoryid(rs.getInt("categoryid"));
			b.setBorrower(rs.getString("borrower"));
			b.setPho1(rs.getString("pho1"));
			b.setPho2(rs.getString("pho2"));
			b.setPho3(rs.getString("pho3"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<Book> getBooks() {
		Connection conn = DbUtil.getConnection();
		
		Statement stmt = DbUtil.getStatement(conn);
		String sql = "select * from book";
		ResultSet rs = DbUtil.getResultSet(stmt, sql);
	
		List<Book> books = new ArrayList<Book>();
		try {
			while (rs.next()) {
				Book b = getBookFromRs(rs);
				books.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(stmt);
			DbUtil.close(rs);
			DbUtil.close(conn);
			
			
		}

		return books;
	}
}
