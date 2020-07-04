package com.alumni.bo;

import com.alumni.beans.DocRequestAppBean;
import com.alumni.dao.DocRequestAppDAO;

public class DocRequestAppBO {

	public int DocRequest(DocRequestAppBean app, int m_id, String email) {
		DocRequestAppDAO DAO = new DocRequestAppDAO();
		int flag = DAO.sendDocRequest(app, m_id, email);
		return flag;

	}

}
