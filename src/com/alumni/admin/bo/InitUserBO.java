package com.alumni.admin.bo;

import java.sql.SQLException;

import com.alumni.admin.beans.InitBEAN;
import com.alumni.admin.dao.InitUserDAO;

public class InitUserBO {

	public InitBEAN adduser(InitBEAN bean) throws SQLException {
		InitUserDAO dao = new InitUserDAO();
		InitBEAN bean1 = dao.adduser(bean);
		return bean1;
	}

}
