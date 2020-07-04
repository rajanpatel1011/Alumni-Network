package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.SearchMembersBEAN;
import com.alumni.dao.SearchMembersDAO;

public class SearchMembersBO {

	public List<SearchMembersBEAN> getSearchMembers(String searchText, String optionSelected, int b_Id, int p_Id,
			int loginId) throws SQLException {
		SearchMembersDAO dao = new SearchMembersDAO();
		List<SearchMembersBEAN> bean = dao.getSearchMembers(searchText, optionSelected, b_Id, p_Id, loginId);
		return bean;
	}

}
