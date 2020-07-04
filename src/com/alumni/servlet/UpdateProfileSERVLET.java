package com.alumni.servlet;

import java.io.IOException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.alumni.bo.ProfileBO;
import com.alumni.beans.EducationBEAN;
import com.alumni.beans.JobBean;
import com.alumni.beans.LoginBEAN;
import com.alumni.beans.MemhobbiesBEAN;
import com.alumni.beans.OtherEducationBean;
import com.alumni.beans.ProfileBEAN;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class UpdateProfileSERVLET
 */
@WebServlet("/UpdateProfileSERVLET")
@MultipartConfig(location = "http://alumninetwork.datadoctorr.com/alumni/tmp/", fileSizeThreshold = 1024
		* 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class UpdateProfileSERVLET extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfileSERVLET() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	}

	private String getFileName(final Part part) {
		// final String partHeader = part.getHeader("content-disposition");
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		try {
			HttpSession session = request.getSession();
			LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
			// String username=request.getParameter("username");
			// int uid=Integer.parseInt(username);

			String password = request.getParameter("oldpwd");
			String conpassword = request.getParameter("newpwd");

			// String hidenpassword=request.getParameter("holdpwd");
			// String hideconpassword=request.getParameter("hnewpwd");

			String firstname = request.getParameter("fname");
			String middlename = request.getParameter("mname");
			String lastname = request.getParameter("lname");
			String Gen = request.getParameter("gender");
			String Gender = null;

			if (Gen.equals("Male")) {
				Gender = "m";
			} else {
				Gender = "f";
			}

			// SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			Date d = null;
			// String date=request.getParameter("dob");

			// d = sdf.parse(date);

			String mobilenumber = request.getParameter("mobno");
			String email = request.getParameter("em");

			String[] selctedhobbies = new String[10];
			// String[] memallhobies=new String[10];
			int h = 1;
			do {
				String tem = "hobbiesnameid" + h;
				selctedhobbies[h] = request.getParameter(tem);
				h++;
			} while (selctedhobbies[h - 1] != null);

			String add1 = request.getParameter("add1");
			String add2 = request.getParameter("add2");

			String degree1 = request.getParameter("degree");
			int degreeId = Integer.parseInt(degree1);
			String clg = request.getParameter("colname");
			int educationid = Integer.parseInt(request.getParameter("educationId"));

			int othereducationid = Integer.parseInt(request.getParameter("othereducationId"));
//		String degree2=request.getParameter("certi_cource");
			String branch2 = request.getParameter("branch_name");
			String passooutyear2 = request.getParameter("pas_year");
			String clg2 = request.getParameter("col_name");

			String jyear = request.getParameter("jyear");
			String jmonth = request.getParameter("jmonth");
			String keyskills = request.getParameter("key_skill");

			String checkotherhobbies = request.getParameter("checkotherhobbies");
			String other = request.getParameter("others_hobbies");

			int j = 1;
			String[] jobtypeStrings = new String[10];
			String[] jobstratmonth = new String[10];
			String[] jobstartyear = new String[10];
			String[] jobendmonth = new String[10];
			String[] jobendyear = new String[10];
			String[] industry = new String[10];
			String[] farea = new String[10];
			String[] profesId = new String[10];

			do {
				String update7 = "profeId" + j;
				profesId[j] = request.getParameter(update7);
//-----------------------------------------------------------------------------------------------------------------------			
				String update = "job_type" + j;
				if ("j".equals(update.substring(1))) {
					RequestDispatcher r1 = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=25"); // Enter
																												// Job
																												// type
					r1.forward(request, response);
					return;
				}
				jobtypeStrings[j] = request.getParameter(update);
//-------------------------------------------------------------------------------------------------------------------------		

				String update1 = "job_st_mon" + j;
				jobstratmonth[j] = request.getParameter(update1);
//-----------------------------------------------------------------------------------------------------------------------			
				String update2 = "job_st_yer" + j;
				jobstartyear[j] = request.getParameter(update2);
//------------------------------------------------------------------------------------------------------------------------			
				String update3 = "job_ed_month" + j;
				jobendmonth[j] = request.getParameter(update3);
//-----------------------------------------------------------------------------------------------------------------------			
				String update4 = "job_ed_yer" + j;
				jobendyear[j] = request.getParameter(update4);
//-----------------------------------------------------------------------------------------------------------------------			
				String update5 = "industry_name" + j;
				if ("j".equals(update.substring(1))) {
					RequestDispatcher r1 = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=26"); // Enter
																												// Industry
																												// name
					r1.forward(request, response);
					return;
				}
				industry[j] = request.getParameter(update5);
//-----------------------------------------------------------------------------------------------------------------------			
				String update6 = "f_area" + j;
				if ("j".equals(update.substring(1))) {
					RequestDispatcher r1 = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=27"); // Enter
																												// Funcation
																												// Area
					r1.forward(request, response);
					return;
				}
				farea[j] = request.getParameter(update6);

//-----------------------------------------------------------------------------------------------------------------------			
				j++;
			} while (jobtypeStrings[j - 1] != null);

			if ((StringUtils.isEmpty(password)) && ("".equals(conpassword) || null == (conpassword))) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=100"); // empty
																											// password
																											// flied
				r.forward(request, response);
				return;
			} else if (!password.equals(conpassword)) {
				RequestDispatcher editprofile = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=2"); // password
																													// not
																													// match
				editprofile.forward(request, response);
				return;
			} else if ("on".equals(checkotherhobbies) && StringUtils.isEmpty(other)) {
				RequestDispatcher editprofile = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=4"); // check
																													// box
																													// on
																													// empty
																													// text
																													// box
				editprofile.forward(request, response);
				return;
			} else if ("null".equals(checkotherhobbies) || null == (checkotherhobbies) && !"".equals(other)) {
				RequestDispatcher r1 = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=3"); // not checked
																										// and written
																										// text box
				r1.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(firstname)) {
				RequestDispatcher rs = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=5"); // empty first
																										// name
				rs.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(middlename)) {
				RequestDispatcher rs = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=6"); // empty middle
																										// name
				rs.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(lastname)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=7"); // empty last
																										// name
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(Gen)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=8"); // empty gender
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(mobilenumber)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=9");// empty mobile
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(email)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=10"); // empty email
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(add1)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=11"); // empty address
																										// line 1
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(add2)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=12"); // empty address
																										// line 2
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(degree1) || "".equals(degree1) || null == (degree1)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=13"); // empty highest
																										// degree 1
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(clg) || "".equals(clg) || null == (clg)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=14"); // empty first
																										// clgg
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(branch2) || "".equals(branch2) || null == (branch2)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=15"); // empty branch
																										// 2
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(passooutyear2) || "".equals(passooutyear2) || null == (passooutyear2)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=16"); // empty passout
																										// 2
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(clg2) || "".equals(clg2) || null == (clg2)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=17"); // empty clg 2
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(jyear) || "".equals(jyear) || null == (jyear)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=18"); // empty job
																										// year
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(jmonth) || "".equals(jmonth) || null == (jmonth)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=19"); // empty job
																										// month
				r.forward(request, response);
				return;
			} else if (StringUtils.isEmpty(keyskills) || "".equals(keyskills) || null == (keyskills)) {
				RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=20"); // empty
																										// keyskills
				r.forward(request, response);
				return;
			}
//----------------------------------- bean started------------------------------------	
			else {

				ProfileBEAN bean = new ProfileBEAN();
				ProfileBO bo = new ProfileBO();

				ProfileBO oldbo = new ProfileBO();
				ProfileBEAN oldbean = oldbo.fetch(lb.getM_id()); // old bean
//---------------------------- upload photo block-------------------------------------------------------------------------------	 		
				final String path = getServletContext().getRealPath("/") + "images\\profile\\";
				// final String path =
				// "http://alumninetwork.datadoctorr.com/alumni/imageUpload/";

				final Part filePart = request.getPart("profilepic");

				Collection<String> headers = filePart.getHeaderNames();
				for (String c : headers) {
					System.out.println("header" + c + " ---        " + filePart.getHeader(c));
				}
				final String fileName = getFileName(filePart);

				if ("".equals(fileName) || StringUtils.isEmpty(fileName) || null == fileName
						|| "null".equals(fileName)) {
					bean.setPic(oldbean.getPic());
				} else {

					OutputStream out = null;
					InputStream filecontent = null;

					String jpg = fileName.substring(fileName.length() - 3);
					String jpeg = fileName.substring(fileName.length() - 4);
					String png = fileName.substring(fileName.length() - 3);
					String JPG = fileName.substring(fileName.length() - 3);

					if (jpg.equals("jpg") || jpeg.equals("jpeg") || png.equals("png") || JPG.equals("JPG")
							|| png.equals("PNG") || jpeg.equals("JPEG")) {
						try {

							if (jpg.equals("jpg")) {
								out = new FileOutputStream(new File(path + File.separator + lb.getM_id() + "." + jpg));
								filecontent = filePart.getInputStream();

								int read = 0;
								final byte[] bytes = new byte[1024];

								while ((read = filecontent.read(bytes)) != -1) {
									out.write(bytes, 0, read);
								}

								String imgpath = "images/profile/" + lb.getM_id() + "." + jpg;

								bean.setPic(imgpath);
							}

							if (jpeg.equals("jpeg")) {
								out = new FileOutputStream(new File(path + File.separator + lb.getM_id() + "." + jpeg));
								filecontent = filePart.getInputStream();

								int read = 0;
								final byte[] bytes = new byte[1024];

								while ((read = filecontent.read(bytes)) != -1) {
									out.write(bytes, 0, read);
								}
								// String imgpath="images/profile/"+lb.getM_id()+"."+jpeg;
								String imgpath = "http://alumninetwork.datadoctorr.com/alumni/imageUpload/"
										+ lb.getM_id() + "." + jpeg;

								bean.setPic(imgpath);
							}
							if (png.equals("png")) {
								out = new FileOutputStream(new File(path + File.separator + lb.getM_id() + "." + png));
								filecontent = filePart.getInputStream();

								int read = 0;
								final byte[] bytes = new byte[1024];

								while ((read = filecontent.read(bytes)) != -1) {
									out.write(bytes, 0, read);
								}
								// String imgpath="images/profile/"+lb.getM_id()+"."+png;
								String imgpath = "http://alumninetwork.datadoctorr.com/alumni/imageUpload/"
										+ lb.getM_id() + "." + png;

								bean.setPic(imgpath);
							}

						} catch (FileNotFoundException fne) {
							fne.getStackTrace();
							System.out.println("IN FileNotFountEX" + fne);
							RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=23"); // file
																													// not
																													// found
							r.forward(request, response);
							return;
						}

						finally {
							if (out != null) {
								out.close();
							}
							if (filecontent != null) {
								filecontent.close();
							}
						}
					} else {

						RequestDispatcher r = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=24"); // jpg/jpeg/png
						r.forward(request, response);
						return;
					}

				}

				bean.setMemberId(lb.getM_id());

				if ("_".equals(password)) {
					bean.setPassword(oldbean.getPassword());
				} else {
					bean.setPassword(password);
				}

				bean.setFirstName(firstname);
				bean.setMiddleName(middlename);
				bean.setLastName(lastname);
				bean.setGender(Gender);
				bean.setDateAndBirth(d);
				bean.setMobileNumber(mobilenumber);
				bean.setEmailId(email);
				bean.setOtherHobbies(other);

				bean.setAddressLineOne(add1);
				bean.setAddressLineSecond(add2);

				EducationBEAN educatio = new EducationBEAN();
				educatio.setDegreeId(degreeId);

				educatio.setCollegeName(clg);
				educatio.setEducationId(educationid);
				educatio.setTempm_id(lb.getM_id());
				bean.setEducation(educatio);

				OtherEducationBean othereducation = new OtherEducationBean();
				// othereducation.setDegree(degree2);
				othereducation.setCourse(branch2);
				othereducation.setPassoutYear(passooutyear2);
				othereducation.setCollegeName(clg2);
				othereducation.setOtherEducationId(othereducationid);
				bean.setOthereducation(othereducation);

				List<JobBean> listofjob = new ArrayList<JobBean>();

				JobBean jobbean;

				j--;
				for (int k = 1; k < j; k++) {

					jobbean = new JobBean();
					int f = Integer.parseInt(profesId[k]);
					jobbean.setProId(f);
					jobbean.setJobType(jobtypeStrings[k]);
					jobbean.setStartedMonth(jobstratmonth[k]);
					jobbean.setStartedYear(jobstartyear[k]);
					jobbean.setEndedMonth(jobendmonth[k]);
					jobbean.setEndedYear(jobendyear[k]);
					jobbean.setIndustryName(industry[k]);
					jobbean.setFuncationArea(farea[k]);

					listofjob.add(jobbean);
				}

				bean.setJob(listofjob);

				List<MemhobbiesBEAN> listofhobbies = new ArrayList<MemhobbiesBEAN>();
				MemhobbiesBEAN memberhobbiesbean;

				h--;
				for (int m = 1; m < h; m++) {
					memberhobbiesbean = new MemhobbiesBEAN();
					int g = Integer.parseInt(selctedhobbies[m]);
					memberhobbiesbean.setHid(g);
					memberhobbiesbean.setMem_Id(lb.getM_id());
					listofhobbies.add(memberhobbiesbean);
				}

				bean.setMemhobbieshobbies(listofhobbies);
				bean.setTotalExprianceMonth(jmonth);
				bean.setTotalExprianceYear(jyear);
				bean.setKeySkills(keyskills);
				bo.updateprofile(bean);

				RequestDispatcher editprofile = request.getRequestDispatcher("profileSERVLET?flag=21"); // successfully
																										// updated
				editprofile.forward(request, response);
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception" + e);
			RequestDispatcher editprofile = request.getRequestDispatcher("EditProfileSERVLET?resultFlag=22"); // try
																												// again
			editprofile.forward(request, response);
			return;
		}
	} // ----------------------- else post method----------------

}// ------------------------- end sevlet class end-----------