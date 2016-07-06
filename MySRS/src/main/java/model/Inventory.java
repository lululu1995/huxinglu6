package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List<Course> courses;

  public Inventory() {
    courses = new LinkedList();
  }

  public void addCourse (int courid, String courname,
		            String teaname) {
    Course Course = new Course();
    courses.add(Course);
  }

  public Course getCourse(int courid) {
    for (Iterator i = courses.iterator(); i.hasNext(); ) {
      Course Course = (Course)i.next();
      if (Course.getCourid()==(courid)) {
        return Course;
      }
    }
    return null;
  }

public List<Course> getGuitars() {
	return courses;
}

public void setGuitars(List<Course> courses) {
	this.courses = courses;
}
  
}
