package dao;

import java.util.List;
import model.Course;

public interface ICourse {
	public List<Course> getAllGuitars();
	public void addGuitar(int courid, String courname,String teaname) ;
	public void deleteGuitar(int ID) ;

}
