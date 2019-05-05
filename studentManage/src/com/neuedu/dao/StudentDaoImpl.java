package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Student;
import com.neuedu.util.DBUtils;
/**
 * StudentDao接口的实现类
 * @author Administrator
 *
 */
public class StudentDaoImpl implements StudentDao {

	
	private Connection conn;
	public StudentDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	//增加学生
	@Override
	public void addOneStudent(Student student) {
		String sql = "INSERT INTO student VALUES(?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)){
			  ps.setInt(1, student.getSid());
			  ps.setString(2, student.getsName());
			  ps.setInt(3, student.getsAge());
			  ps.setString(4, student.getsSex());
			  ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//修改学生
	@Override
	public void updateOneStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "UPDATE student SET sName=?,sAge=?,sSex=? WHERE sId=?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, student.getsName());
			ps.setInt(2, student.getsAge());
			ps.setString(3, student.getsSex());
			ps.setInt(4, student.getSid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除学生
	@Override
	public void deleteOneStudent(int id) {
		String sql = "DELETE FROM student where sId=?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, id);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate != 0) {
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//查询所有学生
	@Override
	public List<Student> getAllStudent() {
		List<Student> stus = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("sID");
				String name = rs.getString("sName");
				int age = rs.getInt("sAge");
				String sex = rs.getString("sSex");
				Student student = new Student(id, name, age, sex);
				stus.add(student);
			}
			return stus;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据id查询学生
	@Override
	public Student getStudentInfoByStuId(int stuid) {
		String sql = "SELECT * FROM student WHERE sId = ?";
		Student student = new Student();
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, stuid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("sID");
				String name = rs.getString("sName");
				int age = rs.getInt("sAge");
				String sex = rs.getString("sSex");
				student = new Student(id, name, age, sex);	
			}
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//通过学生学号,查询选课情况
	@Override
	public List<String> getCourseInfoByStuId(int stuid) {
		List<String> result = new ArrayList<String>();
		String sql = "SELECT cName FROM course c JOIN courandstu cs ON c.cId=cs.cid WHERE sid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stuid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String string = rs.getString("cName");
				result.add(string);
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
