package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.edu.po.Student;

public interface StudentDao {
	public Student findStudentById(String id);
	public Student findStudentById2(String id);
	public List<Student> findStudentByCond2(RowBounds rowBounds,Student student);
	public int findStudentCountByCond2(Student student);
	
	public Student findStudentByIdAndPassword(Student student);
	public int addStudent(Student student);
	public int addStudent(List<Student> students);
	public Integer updateStudent1(Student student);
	public int deleteStudent(@Param("id") String id);
	

}
