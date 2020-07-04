package com.alumni.admin.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.admin.beans.InitModBEAN;
import com.alumni.admin.dao.InitModDAO;

public class InitModBO {

	public List<InitModBEAN> getIntUserList() throws SQLException {
		InitModDAO dao = new InitModDAO();
		return dao.getIntUserList();
	}

	public int getMemId(int d) throws SQLException {
		InitModDAO dao = new InitModDAO();
		return dao.getMemId(d);
	}

	public void BecomeInitMod(InitModBEAN bean) throws SQLException {
		InitModDAO dao = new InitModDAO();
		dao.BecomeInitMod(bean);
	}
}
