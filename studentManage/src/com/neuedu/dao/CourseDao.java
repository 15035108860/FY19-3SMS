package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Course;
import com.neuedu.entity.Student;

public interface CourseDao {

	//增加课程
	void addOneCourse(Course course);
	//修改课程
	void updateOneCourse(Course course);
	//删除课程
	void deleteOneCourse(int couid);
	//查询课程
	List<Course> getAllCourse();
	//通过课程号打印当前课程下面学生信息
	List<Student> getStudentInfoByCouId(int couid);
	//添加选这么课程的学生
	void addStudentInfoByCouId(int couid,int sid);
	//删除选这么课程的学生
	void deleteStudentInfoByCouId(int couid);
}
