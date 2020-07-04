package com.alumni.beans;

import java.util.Date;

public class GalleryAlbumUploadBEAN {

	int m_id;
	int permission;
	Date date_time;
	String Caption;
	String upload_pic;
	String Album_name;
	String Details;
	int a_id;
	Date AlbumCreatedTime;
	int DeleteFlag;
	String F_name;
	String l_name;
	String PermissionName;

	public int getM_id() {
		return m_id;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getCaption() {
		return Caption;
	}

	public void setCaption(String caption) {
		Caption = caption;
	}

	public String getUpload_pic() {
		return upload_pic;
	}

	public void setUpload_pic(String imagepath) {
		this.upload_pic = imagepath;
	}

	public String getAlbum_name() {
		return Album_name;
	}

	public void setAlbum_name(String album_name) {
		Album_name = album_name;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public Date getAlbumCreatedTime() {
		return AlbumCreatedTime;
	}

	public void setAlbumCreatedTime(Date albumCreatedTime) {
		AlbumCreatedTime = albumCreatedTime;
	}

	public int getDeleteFlag() {
		return DeleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		DeleteFlag = deleteFlag;
	}

	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getPermissionName() {
		return PermissionName;
	}

	public void setPermissionName(String permissionName) {
		PermissionName = permissionName;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

}
