package en.itcast.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import en.itcast.dao.StudentDao;
import en.itcast.domain.Student;
import en.itcast.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		System.out.println("添加用户(a) 删除用户(b) 查找用户(c)");
		System.out.print("请输入操作类型:");

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String type = bf.readLine();

			if ("a".equals(type)) {
				System.out.print("请输入学生姓名:");
				String name = bf.readLine();

				System.out.print("请输入学生准考证号:");
				String examid = bf.readLine();

				System.out.print("请输入学生所在地:");
				String location = bf.readLine();

				System.out.print("请输入学生身份证:");
				String idcard = bf.readLine();

				System.out.print("请输入学生成绩:");
				String grade = bf.readLine();

				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);

				StudentDao dao = new StudentDao();
				dao.add(s);

				System.out.println("添加成功");
			} else if ("b".equals(type)) {
				System.out.print("请输入要删除的学生姓名:");
				String name = bf.readLine();
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("删除成功.");
				} catch (StudentNotExistException e) {
					System.out.println("你删除的用户不存在.");
				}

			} else if ("c".equals(type)) {
				System.out.print("请输入你要查询的准考证id:");
				String examid = bf.readLine();
				StudentDao dao = new StudentDao();
				Student find_student = dao.find(examid);
				if(find_student.equals(null)){
					System.out.println("对不起，找不到该学生.");
				}else{
					System.out.println("该学生的姓名是:"+find_student.getName());
				}
			} else {
				System.out.println("不支持你的操作");

			}
		} catch (IOException e) {
			e.printStackTrace();
			;
			System.out.println("sorry");
		}

	}

}
