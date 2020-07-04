package com.alumni.admin.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.admin.beans.EventCreateBEAN;
import com.alumni.admin.beans.EventDisplayBEAN;
import com.alumni.admin.dao.EventDAO;

public class EventBO {

	public void CreateEvent(EventCreateBEAN bean) {
		EventDAO DAO = new EventDAO();
		DAO.CreateEvent(bean);

	}

	public List<EventDisplayBEAN> EventDisplay() throws SQLException {
		EventDAO DAO = new EventDAO();
		List<EventDisplayBEAN> list = DAO.eventDisplay();
		return list;

	}

	public void DeleteEvent(EventCreateBEAN bean) {
		EventDAO DAO = new EventDAO();
		DAO.DeleteEvent(bean);

	}

	public void eventvisibilltyON(int e_id) throws SQLException {
		EventDAO DAO = new EventDAO();
		DAO.eventVisibilityON(e_id);
	}

	public void eventvisibilltyOFF(int e_id) throws SQLException {
		EventDAO DAO = new EventDAO();
		DAO.eventVisibilityOFF(e_id);
	}

}
