package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.MsgBEAN;
import com.alumni.dao.MsgDAO;

public class MsgBO {

	public List<MsgBEAN> msg(int member_id) throws ClassNotFoundException, SQLException {

		MsgDAO mdao = new MsgDAO();
		List<MsgBEAN> mb = mdao.msg(member_id);
		return mb;
	}

}