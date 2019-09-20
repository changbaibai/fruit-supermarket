package com.edu.db_util;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import com.edu.po.Student;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component
public class DbToExcel {
	/**
	 * 该方法实现将电子表中的数据导入对应的数据库内
	 * 
	 * @param excelpath:电子表路径
	 * @param table    ：数据库数据表名
	 * @param fieldList   ：数据库字段名串，在插入数据库中，各字段信息，并且用逗号间隔，
	 * @param columnCount    ：要添加的字段的个数
	 * @throws Exception
	 */
	public List<Student>  excelToDb(String excelpath) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		Workbook workbook = null;
		Sheet sheet = null;
		//conn = JdbcPoolUtils.getConnection();
		conn=null;
		
		List<Student> list=new ArrayList<Student>();
		
		workbook = Workbook.getWorkbook(new File(excelpath));
		sheet = workbook.getSheet(0);
		int r = sheet.getRows();
		
		for (int i = 1; i < r; i++) {
			Student student=new Student();
			student.setUsername(sheet.getCell(1, i).getContents());
			student.setPassword(sheet.getCell(2, i).getContents());
			
			
			list.add(student);
		}
		workbook.close();
		
		return list;
	}

	/**
	 * 该方法实现将数据库中的某数据表数据形成电子表Excel
	 * 
	 * @param table
	 *            :数据表名字
	 * @param fieldList
	 *            ：数据表字段名，采用字符串数组依次存放
	 * @param titles
	 *            ：所形成的电子表表头字段信息，采用字符串数组存放
	 * @param condition
	 *            ：查询数据库的条件，将满足该条件的记录存放到电子表中
	 * @param order
	 *            ：排序字段与排序方式（asc\desc）
	 * @param file
	 *            ：电子表名字
	 * @throws Exception
	 */
	public  void dBToExcel(List <Student> list,String[] titles, String file)
			throws Exception {
	
		WritableWorkbook wwb = null;
		WritableSheet ws = null;


		
		wwb = Workbook.createWorkbook(new File(file));
		ws = wwb.createSheet("sheet1", 0);

		for (int i = 0; i < titles.length; i++) {
			ws.addCell(new Label(i, 0, titles[i]));
		}
		int count = 1;
		
	
		
		Student student=new Student();
		for(int i=0;i<list.size();i++){
			student=list.get(i);
			ws.addCell(new Label(0, i+1,student.getId()));
			ws.addCell(new Label(1, i+1,student.getUsername() ));
			ws.addCell(new Label(2, i+1,student.getPassword() ));
		}		
		wwb.write();

		if (wwb != null)
			wwb.close();
	}

	
	}
	
	
	
	
	
	
	
	

