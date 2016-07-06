package dao;

import java.util.List;

import model.Course;

public interface PlanDao {

	public List<Course> getCourses(String uid);


	public Course getCourseByNo(String courid);

}