package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;
import com.alumni.beans.ModeratorRequestBean;
import com.alumni.dao.ModeratorRequestDAO;

public class ModerratorRequestBO {

	public List<ModeratorRequestBean> DisplayModRequest() throws ClassNotFoundException, SQLException {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		List<ModeratorRequestBean> ModeratorRequestBean = DAO.users();
		return ModeratorRequestBean;
	}

	public ModeratorRequestBean SelcetUser(int R_Id) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		ModeratorRequestBean mb = DAO.userinfo(R_Id);

		return mb;

	}

	public void RejectedModRequest(ModeratorRequestBean bean) {

		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		DAO.RejectedModRequest(bean);
	}

	public ModeratorRequestBean selectedAsMod(int m_id) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		ModeratorRequestBean bean = DAO.selectedAsMod(m_id);
		return bean;
	}

	public ModeratorRequestBean mod1vote(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		DAO.mod1vote(bean, selectUserBean);
		return selectUserBean;

	}

	public ModeratorRequestBean mod2vote(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		DAO.mod2vote(bean, selectUserBean);
		return selectUserBean;

	}

	public ModeratorRequestBean checkvote(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		ModeratorRequestBean checkBean = DAO.checkvote(bean, selectUserBean);
		return checkBean;

	}

	public ModeratorRequestBean checkvote2(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		ModeratorRequestBean checkBean = DAO.checkvote2(bean, selectUserBean);
		return checkBean;

	}

	public void UserGrantedAsMod(ModeratorRequestBean selectUserBean2) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		DAO.UserGrantedAsMod(selectUserBean2);
	}

	public int AcceptByTwo(ModeratorRequestBean selectUserBean1) {
		ModeratorRequestDAO DAO = new ModeratorRequestDAO();
		int Flag = DAO.AcceptByTwo(selectUserBean1);
		return Flag;
	}

}
