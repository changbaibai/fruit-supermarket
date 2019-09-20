package com.edu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.edu.common.utils.Page;
import com.edu.po.Student;

public interface StudentService {
	public Student findStudentById(String id);
	public Student findStudentById2(String id);
	public Student findStudentByIdAndPassword(Student student);
	public int addStudent(Student student);
	public int addStudents(List<Student> students);
	public Page<Student> findStudentByCond2(Integer page,Integer rows,Student student);
	public List<Student> findStudentByIds(String[] ids);
	public int updateStudent1(Student student);
	public int deleteStudent(@Param("id") String id);
	
	
}
