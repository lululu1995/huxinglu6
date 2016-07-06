package dao;

import java.util.HashMap;

import model.Teacher;;

public interface PersonDao {
	
	public HashMap<String, Teacher> findAllTeachers();

}
