package com.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.utils.Page;
import com.edu.dao.StudentDao;
import com.edu.po.Student;
import com.edu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}

	@Override
	public Student findStudentById2(String id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById2(id);
	}

	@Override
	public Student findStudentByIdAndPassword(Student student) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByIdAndPassword(student);
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public int addStudents(List<Student> students) {
		// TODO Auto-generated method stub
		int count=0;
		for(Student student :students){
			System.out.println(student);
			count+=studentDao.addStudent(student);
			
		}
		return count;
	}

	@Override
	public Page<Student> findStudentByCond2(Integer page,Integer rows,Student student) {
		// TODO Auto-generated method stub
		
		RowBounds rowBounds = new RowBounds((page-1) * rows, rows);
		// 查询客户列表
		List<Student> students=studentDao.findStudentByCond2(rowBounds,student);
	

	// 查询课程列表总记录数
		Integer count = studentDao.findStudentCountByCond2(student);
		// 创建Page返回对象
		Page<Student> result = new Page<Student>();
		result.setPage(page);
		result.setRows(students);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}

	@Override
	public List<Student> findStudentByIds(String[] ids) {
		// TODO Auto-generated method stub
		List<Student> studnets=new ArrayList<Student>();
		for(String id:ids){
			
			studnets.add(studentDao.findStudentById(id));
		}
		
		return studnets;
	}

	@Override
	public int updateStudent1(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent1(student);
	}

	@Override
	public int deleteStudent(String id) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(id);
	}

	
}
