package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entry.Admin;
import com.example.entry.Product;
import com.example.entry.Student;
import com.example.entry.User;

@Mapper
public interface AdminDao {
	public Admin loginCheck(String id);

	public int insertTech(Product product);
	public List<Product> findTechList();
	public Product getEditTechInfo(int productid);

	//插入用户
	public int insertUser(User user);
	//查询所有用户
	public List<User> searchUserList();
	//查询单个用户信息
	public User searchUserSelf(int user_id);
	
	public void edit_chapter(@Param("chapter_id")  Integer chapter_id, @Param("product_id")  Integer product_id, @Param("video_id")  Integer video_id, @Param("chapter_order")  Integer chapter_order, @Param("chapter_name")  String chapter_name);
	
    public void updateProductName(@Param("product_id") Integer product_id, @Param("product_name") String product_name);
    
    public void updateProductDesc(@Param("product_id") Integer product_id, @Param("product_desc") String product_desc);
    
    public void updateProductImg(@Param("product_id") Integer product_id, @Param("file_name") String file_name);
    
    public void create_chapter();
    
    public void delete_chapter(Integer chapter_id);
    
    public void delete_course_chapter(Integer product_id);
    
    public void delete_course(Integer product_id);
    
    public int insertChapterVideo(String file_name);
    
    public Integer get_video_id(Integer chapter_id);
    
    public void addCourse();
    
    public int getcourseid();
    
    public int getvideoid();
    
    public int getchapterid();
}




