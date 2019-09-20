package com.edu.controller;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.utils.Page;
import com.edu.db_util.DbToExcel;
import com.edu.po.Student;
import com.edu.service.StudentService;
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DbToExcel dbToExcel;
	
	public DbToExcel getDbToExcel() {
		return dbToExcel;
	}


	public void setDbToExcel(DbToExcel dbToExcel) {
		this.dbToExcel = dbToExcel;
	}


	/**
	 * 根据id查询客户详情
	 */
	

	@RequestMapping("/toFileUpload.action")
	public String toFileUpload(Model model) {
		String forword="admin/fileUpload";
		return forword;
	}
	
	@RequestMapping("/downloadStudent.action")    //下载
	public ResponseEntity<byte[]> downloadStudent(Model model,String[] studentId,HttpServletRequest request)throws Exception {
		
		List<Student> students=studentService.findStudentByIds(studentId);
		String[] titles={"id","用户名","密码"};
		String path="F:/test/";
		String filename="test.xls";
		
		File filePath = new File(path);
		try {
			
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			File testFile = new File(path+filename);
			if(!testFile .exists()) {
			testFile.createNewFile();
			System.out.println("测试文件不存在");
			}
			
			dbToExcel.dBToExcel(students,titles,path+filename);
			
			  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 File file = new File(path+filename);
		    // 对文件名编码，防止中文文件乱码
		  filename = this.getFilename(request, filename);
		    // 设置响应头
		    HttpHeaders headers = new HttpHeaders();
		    // 通知浏览器以下载的方式打开文件
		    headers.setContentDispositionFormData("attachment", filename);
		    // 定义以流的形式下载返回文件数据
		    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		    // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
		   return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				   headers,HttpStatus.OK);
	}
	
	
	@RequestMapping("/toStudent.action")
	public String toStudent(Model model,Student student,@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="3")Integer rows) {
		
		String forword="admin/student";
		Page<Student> students=studentService.findStudentByCond2(page,rows,student);  //查询
		model.addAttribute("page", students);
		model.addAttribute("id", student.getId());	
		model.addAttribute("username", student.getUsername());	
		
		return forword;
	}
	
	@RequestMapping("/toEditStudent.action")
	public String editCourse(String id,Model model,HttpSession sesson) {
		
		Student student =studentService.findStudentById(id);
		System.out.println(student);
		model.addAttribute("student", student);
		//返回客户信息展示页面
		return "admin/editStudent";
	}	
	
	
	@ResponseBody
	@RequestMapping("/editStudent.action") //修改
	public Integer editStudent(@RequestBody Student student,Model model,HttpSession sesson) {
		
		return studentService.updateStudent1(student);
	}
	
	
	@RequestMapping("/deleteStudent.action")//删除
	public String deleteCourse(String id,Model model) {
		studentService.deleteStudent(id);
		
		return "redirect:toStudent.action";
	}
	
	
	@RequestMapping("/studentFileUpload.action")    //文件上传
	public String studentFileUpload(@RequestParam("uploadfile") List<MultipartFile> uploadfile,
			HttpServletRequest request) {
		
		
		// 判断所上传文件是否存在
		if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
			//循环输出上传的文件
			for (MultipartFile file : uploadfile) {
				// 获取上传文件的原始名称
				String originalFilename = file.getOriginalFilename();
				// 设置上传文件的保存地址目录
				
				String dirPath = "F:/test/";
				File filePath = new File(dirPath);
				
				System.out.println("dirPath:"+dirPath);
				
				// 如果保存文件的地址不存在，就先创建目录
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				// 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
				String newFilename = "_"+UUID.randomUUID() + 
                                                   "_"+originalFilename;
				try {
					// 使用MultipartFile接口的方法完成文件上传到指定位置
					file.transferTo(new File(dirPath + newFilename));
					List<Student> students=dbToExcel.excelToDb(dirPath + newFilename);
					
					studentService.addStudents(students);
					
				} catch (Exception e) {
					e.printStackTrace();
                       return "admin/error";
				}
			}
			// 跳转到成功页面
			return "admin/success";
		}else{
			return"admin/error";
		}
	}
	public String getFilename(HttpServletRequest request,
		 String filename) throws Exception { 
		// IE不同版本User-Agent中出现的关键词
		String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};  
		// 获取请求头代理信息
		String userAgent = request.getHeader("User-Agent");  
		for (String keyWord : IEBrowserKeyWords) { 
		if (userAgent.contains(keyWord)) { 
		//IE内核浏览器，统一为UTF-8编码显示
		return URLEncoder.encode(filename, "UTF-8");
		}
		}  
		//火狐等其它浏览器统一为ISO-8859-1编码显示
		return new String(filename.getBytes("UTF-8"), "ISO-8859-1");  
	}  
	
	
}
