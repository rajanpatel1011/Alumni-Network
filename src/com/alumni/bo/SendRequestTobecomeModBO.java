package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.beans.sendRequestToBecomeModbeans;
import com.alumni.dao.SendRequestTobecomeModDAO;

public class SendRequestTobecomeModBO {

	public void sendRequestToBecomeMod(sendRequestToBecomeModbeans bean) throws SQLException {
		SendRequestTobecomeModDAO dao = new SendRequestTobecomeModDAO();
		dao.sendRequestToBecomeMod(bean);
	}

	public sendRequestToBecomeModbeans check(sendRequestToBecomeModbeans bean) throws SQLException {
		SendRequestTobecomeModDAO dao = new SendRequestTobecomeModDAO();
		return dao.check(bean);
	}

	public sendRequestToBecomeModbeans canBeMod(sendRequestToBecomeModbeans bean) throws SQLException {
		SendRequestTobecomeModDAO dao = new SendRequestTobecomeModDAO();
		return dao.canBeMod(bean);
	}

	public sendRequestToBecomeModbeans mod(sendRequestToBecomeModbeans bean) throws SQLException {
		SendRequestTobecomeModDAO dao = new SendRequestTobecomeModDAO();
		return dao.Modacc(bean);
	}

}
