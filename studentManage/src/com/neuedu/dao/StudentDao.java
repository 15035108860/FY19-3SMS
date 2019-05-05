package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Student;


/**
 * 
 * StudentDao接口
 * **/

public interface StudentDao {

	
	//添加学生
	void addOneStudent(Student student);
	//修改学生
	void updateOneStudent(Student student);	
	//删除一个学生
	void deleteOneStudent(int id);
	//查询学生
	List<Student> getAllStudent();
	//根据id查询学生
	Student getStudentInfoByStuId(int stuid);
	//通过学生学号,查询选课情况
	List<String> getCourseInfoByStuId(int stuid);
	
}
