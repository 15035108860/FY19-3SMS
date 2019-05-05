package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Course;
import com.neuedu.entity.Student;

public class CourseDaoImpl implements CourseDao{

	private Connection conn;
	public CourseDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	
	//添加课程
	@Override
	public void addOneCourse(Course course) {
		String sql ="INSERT INTO course VALUES (?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, course.getcId());
			ps.setString(2, course.getCName());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//修改课程
	@Override
	public void updateOneCourse(Course course) {
		String sql = "UPDATE course SET cName=? WHERE cId = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, course.getCName());
			ps.setInt(2, course.getcId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//查询课程
	@Override
	public List<Course> getAllCourse() {
		
		List<Course> courses = new ArrayList<Course>();
		String sql = "SELECT * FROM course";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("cId");
				String name = rs.getString("cName");
				Course cou = new Course(id,name);
				courses.add(cou);
			}
			return courses;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}

	//通过课程号打印当前课程下面学生信息
	@Override
	public List<Student> getStudentInfoByCouId(int couid) {
		List<Student> students = new ArrayList<Student>();
		String sql = "SELECT * FROM student s JOIN courandstu c ON s.sid = c.sid WHERE cid = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setInt(1, couid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("sId");
				String name = rs.getString("sName");
				int age = rs.getInt("sAge");
				String sex = rs.getString("sSex");
				Student student = new Student(id, name, age, sex);
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	//添加选这么课程的学生
	@Override
	public void addStudentInfoByCouId(int couid,int sid) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO courandstu(sID,cId) VALUES(?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, sid);
			ps.setInt(2, couid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//删除选这门课程的学生
	@Override
	public void deleteStudentInfoByCouId(int couid) {
		String sql = "DELETE FROM courandstu WHERE cid=?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, couid);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate != 0) {
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//删除课程
	@Override
	public void deleteOneCourse(int couid) {
		String sql = "DELETE FROM course WHERE cId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, couid);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate != 0) {
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
