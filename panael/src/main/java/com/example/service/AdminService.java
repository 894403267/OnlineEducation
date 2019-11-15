package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.dao.AdminDao;
import com.example.entry.Admin;
import com.example.entry.Product;
import com.example.entry.Student;
import com.example.entry.User;

@Service
public class AdminService {
	@Resource
	private AdminDao adminDao;
	
	public Admin checkLogin(String id) {
		Admin admin = adminDao.loginCheck(id);
		return admin;
	}

	
	public int insertTech(Product product) {
		return adminDao.insertTech(product);
	}
	
	public List<Product> findTechList(){
		return adminDao.findTechList();
	}
	
	public Product getEditTechInfo(int productid) {
		return adminDao.getEditTechInfo(productid);
	}

	//插入数据
	public int insertUser(User user) {
		return adminDao.insertUser(user);
	}
	
	//查询数据
	public List<User> searchUserList() {
		return adminDao.searchUserList();
	}
	
	//查询单个用户信息
	public User searchUserSelf(int user_id) {
		return adminDao.searchUserSelf(user_id);
	}
	
	public void updateProductName(Integer product_id, String product_name){
		adminDao.updateProductName(product_id, product_name);
	}
	
	public void updateProductDesc(Integer product_id, String product_desc){
		adminDao.updateProductDesc(product_id, product_desc);
	}
	
	public void updateProductImg(Integer product_id, String file_name){
		adminDao.updateProductImg(product_id, file_name);
	}
	
	public int create_chapter(){
		adminDao.create_chapter();
		return adminDao.getchapterid();
	}
	
	public void delete_chapter(Integer chapter_id){
		adminDao.delete_chapter(chapter_id);
	}
	
	public void delete_course(Integer product_id){
		adminDao.delete_course_chapter(product_id);
		adminDao.delete_course(product_id);		
	}
	
	public void edit_chapter(Integer chapter_id, Integer product_id, Integer video_id, Integer chapter_order, String chapter_name){
		adminDao.edit_chapter(chapter_id, product_id, video_id, chapter_order, chapter_name);
	}
	
	public int get_video_id(Integer chapter_id){
		return adminDao.get_video_id(chapter_id);
	}
	
	public int addCourse(){
		adminDao.addCourse();
		return adminDao.getcourseid();	
	}
	
	public int insertChapterVideo(String file_name){
		adminDao.insertChapterVideo(file_name);
		return adminDao.getvideoid();
	}
}
