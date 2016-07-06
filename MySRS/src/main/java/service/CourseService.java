package service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import dao.CourseCatalogDao;
import dao.CourseDao;
import dao.dataAccess;
import model.Course;
import model.CourseCatalog;

public class CourseService {

	private CourseDao cd = dataAccess.createCourseDao();
	private CourseCatalogDao ccd = dataAccess.createCourseCatalogDao();
	private CourseCatalog courseCatalog = ccd.getCourseCatalog();

	public CourseCatalog getCourseCatalog() {
		return courseCatalog;
	}

	public void setCourseCatalog(CourseCatalog courseCatalog) {
		this.courseCatalog = courseCatalog;
	}

	public String getAllCoursesJSON() {
		JSONArray ja = new JSONArray();
		List<Course> courses = cd.getAllCourses();

		for (Course c : courses) {
			JSONObject jo = new JSONObject();
			jo.put("courid", c.getCourid());
			jo.put("courname", c.getCourname());
			jo.put("grade", c.getGrade());
			ja.put(jo);
		}
		return ja.toString();
	}

	public String getCourseJSON(String courid) {
		JSONObject jo = new JSONObject();
		Course c = cd.getCourse(courid);
		jo.put("courid", c.getCourid());
		jo.put("courname", c.getCourname());
		jo.put("grade", c.getGrade());
		jo.put("preCourid", cd.getPrerequisites(c).get(0).getCourid());
		return jo.toString();
	}

	public boolean isCourseInSimilar(Course course) {
		List<Course> courses = cd.getAllCourses();
		return course.isCourseInSimilar(courses);
	}

	public String addCourseResult(String courid, String courname,  String teaname) {
		JSONObject jo = new JSONObject();
		Course c = new Course(courid, courname, teaname);
		jo.put("result", !isCourseInSimilar(c));
		if (!isCourseInSimilar(c)) {
			cd.addCourse(c, preCourid);
			courseCatalog.addCourse(c);
			jo.put("warning", "添加成功！");
		} else {
			jo.put("warning", "添加失败：已有相同的课程或课程ID重复！");
		}
		return jo.toString();
	}

	public void deleteCourse(String courid) {
		cd.deleteCourse(courid);
	}

	public void updateCourse(Course course, String preCourid) {
		cd.updateCourse(course);
		cd.updatePrerequisite(course, preCourid);
	}
}