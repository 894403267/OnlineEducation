package com.example.entry;

public class Chapter extends BaseNode {

	private int chapter_id;
	
	private int product_id;
	
	private Integer video_id;
	
	private Integer chapter_order;
	
	private String chapter_name;

	public int getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Integer getVideo_id() {
		return video_id;
	}

	public void setVideo_id(Integer video_id) {
		this.video_id = video_id;
	}
	
	public Integer getChapter_order() {
		return chapter_order;
	}

	public void setChapter_order(Integer chapter_order) {
		this.chapter_order = chapter_order;
	}
	
	public String getchapter_name() {
		return chapter_name;
	}

	public void setchapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	
}
