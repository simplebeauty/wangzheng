package com.example.mylistview;

public class itemInfo {
	private String title;
	private String introduce;
	private int picture;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public String getIndroduce(){
		return introduce;
	}
	
	public void setIntroduce(String introduce){
		this.introduce=introduce;
	}
	
	public int getPicture(){
		return picture;
	}
	
	public void setPicture(int picture){
		this.picture=picture;
	}
	
	/**
	 * 
	 */
	public itemInfo(){
		super();
	}
	
	/**
	 * 构造函数重载
	 * @param title
	 * @param introduce
	 * @param picture
	 */
	public itemInfo(String title,String introduce,int picture){
		super();
		this.title=title;
		this.introduce=introduce;
		this.picture=picture;
	}
}
