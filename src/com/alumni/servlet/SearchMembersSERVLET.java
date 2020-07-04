package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.SearchMembersBEAN;
import com.alumni.bo.SearchMembersBO;

/**
 * Servlet implementation class SearchMembersSERVLET
 */
@WebServlet("/SearchMembersSERVLET")
public class SearchMembersSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMembersSERVLET() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");

		String searchText = request.getParameter("st");
		System.out.println("Search Text =" + searchText);
		String optionSelected = request.getParameter("optionseleced");
		SearchMembersBO bo = new SearchMembersBO();
		try {
			if (searchText.equals("")) {
				out.print("<div class='mem'>No Users</div>");
			} else {
				List<SearchMembersBEAN> bean = bo.getSearchMembers(searchText, optionSelected, loginBEAN.getB_id(),
						loginBEAN.getP_id(), loginBEAN.getM_id());
				// request.setAttribute("searchbean", bean);

				/*
				 * <% List<SearchMembersBEAN> bean = (List<SearchMembersBEAN>)
				 * request.getAttribute("searchbean"); if(bean == null){ %> <div class="mem"> No
				 * Users </div> <% }else{ for(SearchMembersBEAN sb:bean) { %>
				 * 
				 * <div class='mem'> <img alt='' src='<%= sb.getPicUrl() %>' width='150px'
				 * height='100px' /><br/> <label><a href='#'><%= sb.getFname() +'
				 * '+sb.getLname() %></a></label> <label><%= sb.getBranch() %></label>
				 * <label><%= sb.getYear() %></label> </div> <% } } %>
				 */

				if (bean == null) {
					out.print("<div class='mem'>No Users</div>");
				} else {
					for (SearchMembersBEAN sb : bean) {
						String link = "StudentSERVLET?id=" + sb.getmId();
						out.print("<div class='mem'>" + "<img alt='' src='" + sb.getPicUrl()
								+ "' width='150px' height='100px' /><br/>" + "<label><a href='" + link + "'>"
								+ sb.getFname() + " " + sb.getLname() + "</a></label>" + "<label>" + sb.getBranch()
								+ "</label>" + "<label>" + sb.getYear() + "</label>" + "</div>" + "");
					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
