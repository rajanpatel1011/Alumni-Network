package com.alumni.admin.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.admin.beans.NewsBEAN;
import com.alumni.admin.dao.NewsDAO;

public class NewsBO {

	public List<NewsBEAN> news() throws ClassNotFoundException, SQLException {
		NewsDAO dao = new NewsDAO();
		List<NewsBEAN> bean = dao.news();
		return bean;
	}

	public NewsBEAN createNews(NewsBEAN bean) throws SQLException {
		NewsDAO dao = new NewsDAO();
		NewsBEAN bean1 = dao.createNews(bean);
		return bean1;
	}

}
