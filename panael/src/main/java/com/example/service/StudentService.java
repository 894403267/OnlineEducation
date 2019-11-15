package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dao.StudentDao;
import com.example.entry.Student;
import com.example.entry.Product;
import com.example.entry.Video;
import com.example.entry.Problem;
import com.example.entry.Answer;
import com.example.entry.CourseDetail;

@Service
public class StudentService {
	@Resource
	private StudentDao studentDao;	
		
	public Map<String, Object> PageShow(int limit,int offset){
		Map<String, Object> map=new HashMap<>();
		List<Student> page=new ArrayList<>();
		List<Student> all=studentDao.allStudent();
		for (int i = offset; i < offset+limit; i++) {
			if (i<all.size()) {
				page.add(all.get(i));
			}
		}
		map.put("rows", page);
		map.put("total", all.size());
		return map;
	}
	
	public int insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}
	
	public int deleteStudent(String id) {
		return studentDao.deleteStudent(id);
	}
	
	public int updateStudent(HashMap<String, Object> map) {
		System.err.println(map);
		return studentDao.updateStudent(map);
	}
	
	public Student searchById(String id) {
		return studentDao.searchById(id);
	}
	
	public Video searchVideoByID(Integer video_id) {
		return studentDao.searchVideoByID(video_id);
	}
	
	public Product searchCourseByID(Integer product_id) {
		return studentDao.searchCourseByID(product_id);
	}
	
	public List<Problem> searchProblemByID(Integer product_id, Integer chapter_id) {
		return studentDao.searchProblemByID(product_id, chapter_id);
	}
	
	public List<Answer> searchAnswerByID(Integer problem_id) {
		return studentDao.searchAnswerByID(problem_id);
	}
	
	public List<Product> allCourse(){
		return studentDao.allCourse();
	}
	
	public List<CourseDetail> GetCourseDetail(@PathVariable("product_id") int course_id){
		
		return studentDao.GetCourseDetail(course_id);
	}
	
	public List<Product> searchCourse(String product_name){
		return studentDao.searchCourse(product_name);
	}
	
	public List<Product> CourseHistory(){
		return studentDao.CourseHistory();
	}
}
