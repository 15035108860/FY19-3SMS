package com.neuedu.test;

import java.sql.Connection;
import java.util.List;

import com.neuedu.dao.CourseDaoImpl;
import com.neuedu.dao.StudentDaoImpl;
import com.neuedu.entity.Course;
import com.neuedu.entity.Student;
import com.neuedu.util.DBUtils;

public class Test {

	public static void main(String[] args) {
		Connection connection = DBUtils.getConnection();
		//StudentDaoImpl sdi = new StudentDaoImpl(connection);
		
		//Student student = new Student(6, "暮雨归", 19, "女");
		//sdi.addOneStudent(student);
		//sdi.updateOneStudent(student);
		//sdi.deleteOneStudent(5);
		
		//List<Student> allStudent = sdi.getAllStudent();
		//System.out.println(allStudent);
		//Student studentInfoByStuId = sdi.getStudentInfoByStuId(6);
		//System.out.println(studentInfoByStuId);
		//List<String> courseInfoByStuId = sdi.getCourseInfoByStuId(1);
		//System.out.println(courseInfoByStuId);
		
		CourseDaoImpl cdi = new CourseDaoImpl(connection);
		//Course cour = new Course(6, "Python");
		//cdi.addOneCourse(cour);
		//cdi.updateOneCourse(cour);
		//List<Course> allCourse = cdi.getAllCourse();
		//System.out.println(allCourse);
		//List<Student> studentInfoByCouId = cdi.getStudentInfoByCouId(1);
		//System.out.println(studentInfoByCouId);
		//cdi.addStudentInfoByCouId(3, 5);
		cdi.deleteStudentInfoByCouId(5);
	}
}
