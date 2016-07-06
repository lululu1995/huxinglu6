package dao;

import java.util.List;
import java.util.Map;

import model.Teacher;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;

public interface SectionDao {

	public List<Section> getSections();


	public int inSection(Student s, int sectionno);


	public ScheduleOfClasses getSchedule(int sectionno);


	public Section getSectionByNo(int sectionno);


	public List<Integer> getHasSectionNo(Student s);


	public List<Integer> getHasSectionNo(Teacher p);


	public Map<String, String> getSectionOfStudent();


	public List<String> querySectionByPro(int uid);


	public int updateSection(int courid, int secid, String week, String room, String seat, String time,
			int uid);


	public void addSection(int courid, int secid, String week, String room, String seat, String time,
			int uid);


	public void delSection(int secid);

}