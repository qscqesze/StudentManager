package junit.test;

import org.junit.Test;

import en.itcast.dao.StudentDao;
import en.itcast.domain.Student;
import en.itcast.exception.StudentNotExistException;

public class StudentDaoTest {

	@Test
	public void testAdd(){
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setExamid("121");
		s.setGrade(89);
		s.setIdcard("121");
		s.setLocation("±±¾©");
		s.setName("aa");
		dao.add(s);
		
	}
	
	@Test
	public void testFind(){
		StudentDao dao = new StudentDao();
		dao.find("222");
	}

	@Test
	public void testdelete() throws StudentNotExistException{
		StudentDao dao = new StudentDao();
		dao.delete("aa");
	}
}
