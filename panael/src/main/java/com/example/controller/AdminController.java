package com.example.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.entry.User;
import com.example.entry.Product;
import com.example.service.AdminService;

@CrossOrigin(origins= {"http://localhost:8080","null"})
@Controller
public class AdminController {
	
	@Resource
	private AdminService adminService;
	private List<Product> techList;
	private List<Product> techListForEdit;
	private int productId;
	private Product product;
	/**
	 * @return the productid
	 */
	public int getProductId() {
		return productId;
	}

	public List<User> findUserList;
		
	public List<User> getFindUserList() {
		return findUserList;
	}
	public void setFindUserList(List<User> findUserList) {
		this.findUserList = findUserList;
	}
	@RequestMapping("/userIndex.php")
	public String userIndex() {
		return "admin/user_list";
	}
	/**
	 * @param productid the productid to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the techList
	 */
	public List<Product> getTechList() {
		return techList;
	}

	/**
	 * @param techList the techList to set
	 */
	public void setTechList(List<Product> techList) {
		this.techList = techList;
	}

	/**
	 * @return the techListForEdit
	 */
	public List<Product> getTechListForEdit() {
		return techListForEdit;
	}

	/**
	 * @param techListForEdit the techListForEdit to set
	 */
	public void setTechListForEdit(List<Product> techListForEdit) {
		this.techListForEdit = techListForEdit;
	}
	
	//查询用户列表数据
	@RequestMapping(value="/searchUserList",method=RequestMethod.POST)
	@ResponseBody
	public List<User> searchUserList() {
		findUserList = adminService.searchUserList();
		for(User user : findUserList) {
			  String userName = user.getUser_name();
     		  int userId = user.getUser_id();
			  user.setUser_name("<a onclick = editUser(" + userId + ")>" + userName + " </a>");
		}
		return findUserList;
	}
	
	//查询单个用户数据
	/*@RequestMapping(value="/searchUserSelf")
	@ResponseBody
	public Object searchUserSelf(int user_id) {
		User user = adminService.searchUserSelf(user_id);
		return user;
	}
	*/
	//插入数据
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public int insertUser(User user) {
        //获取本地时间，赋值到User表内
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		user.setCreate_time(time.format(new Date()));
		user.setUpdate_time(time.format(new Date()));
		return adminService.insertUser(user);
	}
	
//	@RequestMapping(value = "judge", method = RequestMethod.POST)
//	@ResponseBody
//	public String jumpPage(@RequestBody Map<String, String> map,HttpServletResponse response) {
//		String id = map.get("id");
//		String password = map.get("password");
//		Cookie cookie=new Cookie("id", map.get("id"));
//		cookie.setMaxAge(600);
//		response.addCookie(cookie);
//		return "1";
//		
//		Admin admin = adminService.checkLogin(map.get("id"));		
//		if (admin == null) {
//			return "0";
//		} 
//		else {
//			if (admin.getPassword().equals(map.get("password"))) {
//				Cookie cookie=new Cookie("id", map.get("id"));
//				cookie.setMaxAge(600);
//				response.addCookie(cookie);
//				return "1";
//			} else {
//				return "-1";
//			}
//		}
//	}
	
	
	
	@RequestMapping("/techList.php")
	public String techList() {
		return "admin/tech_list";
	}
	
	@RequestMapping("/addTech.php")
	public String addTech() {
		return "admin/add_tech";
	}
		
	@RequestMapping(value="/findTechList",method=RequestMethod.POST)
	@ResponseBody
	public List<Product> findTechList() throws Exception {
		techList = adminService.findTechList();
		for (Product product : techList) {
			int product_id = product.getProduct_id();
			String product_nm = product.getProduct_name();
			product.setProduct_name("<a href='editTech/"+ product_id +"'>" + product_nm +"</a>");
		}
		
		return techList;
	}
	
	@RequestMapping(value="/insertTech",method=RequestMethod.POST)
	@ResponseBody
	public int insertTech(Product product) {
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		product.setCreate_time(time.format(new Date()));
		product.setUpdate_time(time.format(new Date()));
		return adminService.insertTech(product);
	}
	
	@RequestMapping("/editTech/{product_id}")
	public String editTechForView() {
		return "admin/edit_tech";
	}
	
	@RequestMapping("/edit_course")
	@ResponseBody    
	public String edit_course_info(@RequestParam(value="image_file", required=false) MultipartFile image_file, @RequestParam("product_id") Integer product_id, @RequestParam("product_name") String product_name, @RequestParam("product_desc") String product_desc, HttpServletRequest request) {
		String file_name;
        
		if (image_file != null) {
			file_name = image_file.getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("");       
	        String path1 = path.replaceAll("\\\\", "&");
	        String path2 = path1.substring(0, path1.lastIndexOf("&"));
	        String path3 = path2.substring(0, path2.lastIndexOf("&"));
	        String path4 = path3 + "&" + "resources&static" + "&course_img&" + file_name;
	        String path5 = path4.replaceAll("&", "\\\\");
            File saveFile = new File(path5);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
            	image_file.transferTo(saveFile);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "图片上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "图片上传失败," + e.getMessage();
            }
            adminService.updateProductImg(product_id, file_name);
        }
  
		adminService.updateProductName(product_id, product_name);
		adminService.updateProductDesc(product_id, product_desc);
		
		return "课程信息修改成功";
	}
	
	@RequestMapping("/create_chapter")
	@ResponseBody
	public int create_chapter() {	
		return adminService.create_chapter();
	}
	
	@RequestMapping("/edit_chapter")
	@ResponseBody
	public String edit_chapter(@RequestParam(value="video_file", required=false) MultipartFile video_file, @RequestParam("chapter_id") Integer chapter_id, @RequestParam("chapter_name") String chapter_name, @RequestParam("chapter_order") Integer chapter_order, @RequestParam("product_id") Integer product_id, HttpServletRequest request) {	
        String file_name;
        Integer video_id = null;
		if (video_file != null) {
			file_name = video_file.getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("");       
	        String path1 = path.replaceAll("\\\\", "&");
	        String path2 = path1.substring(0, path1.lastIndexOf("&"));
	        String path3 = path2.substring(0, path2.lastIndexOf("&"));
	        String path4 = path3 + "&" + "resources&static" + "&chapter_video&" + file_name;
	        String path5 = path4.replaceAll("&", "\\\\");
            File saveFile = new File(path5);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
            	video_file.transferTo(saveFile);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "视频上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "视频上传失败," + e.getMessage();
            }
            video_id = adminService.insertChapterVideo(file_name);
        } 
		
		adminService.edit_chapter(chapter_id, product_id, video_id, chapter_order, chapter_name);
		 return "章节修改成功";
	}
	
	@RequestMapping("/delete_chapter")
	@ResponseBody
	public String delete_chapter(Integer chapter_id){
		adminService.delete_chapter(chapter_id);
		return "章节删除成功";
	}
	
	@RequestMapping("/addCourse")
	@ResponseBody
	public int addCourse(){
		return adminService.addCourse();	
	}
	
	@RequestMapping("/delete_course")
	@ResponseBody
	public String delete_course(Integer product_id){
		 adminService.delete_course(product_id);
		 return "课程删除成功";
	}
		
	@RequestMapping("/get_video_id")
	@ResponseBody
	public int get_video_id(Integer chapter_id){
		return adminService.get_video_id(chapter_id);
	}
}

