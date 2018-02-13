package com.alumni.beans;

import java.util.Date;

public class DocRequestAppBean {


int doc_id;
String Data;
Date date_time;
String subject;
int accept;
int panding;
int Ready;
int rejected;
public int getDoc_id() {
	return doc_id;
}
public void setDoc_id(int doc_id) {
	this.doc_id = doc_id;
}
public String getData() {
	return Data;
}
public void setData(String data) {
	Data = data;
}
public Date getDate_time() {
	return date_time;
}
public void setDate_time(Date date_time) {
	this.date_time = date_time;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getAccept() {
	return accept;
}
public void setAccept(int accept) {
	this.accept = accept;
}
public int getPanding() {
	return panding;
}
public void setPanding(int panding) {
	this.panding = panding;
}
public int getReady() {
	return Ready;
}
public void setReady(int ready) {
	Ready = ready;
}
public int getRejected() {
	return rejected;
}
public void setRejected(int rejected) {
	this.rejected = rejected;
}








}

