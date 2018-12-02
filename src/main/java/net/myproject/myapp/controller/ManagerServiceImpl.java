package net.myproject.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.myproject.myapp.models.Get_UseNumVO;
import net.myproject.myapp.models.LoginVO;
import net.myproject.myapp.models.get_transactionVO;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	@Qualifier("mybatis")
	AccessDAO dao;
	String start_date;
	String sysdate;
	Map<String,String> parameter= new HashMap<>(); 
	Tools tools = new Tools();

	@Override
	public List<Get_UseNumVO> get_fintech_num() throws Exception {
		try {
			return dao.get_fintech_num();
		} catch (Exception e) {
			throw new RuntimeException("이용번호를 가져오지 못했습니다.");
		}

	}

	public void get_transaction(get_transactionVO get_transactionVO) {// 페이지의 디폴트 값

		if (get_transactionVO.getInquiry_type() == null) {

			get_transactionVO.setInquiry_type("A");
		} else {
			// 유저가 입력한 값.
		}

		if (get_transactionVO.getTo_date() == null) {
			sysdate = tools.sysdate(); // sysdate 현재 날짜 
			get_transactionVO.setTo_date(sysdate);
		} else {
			// 유저가 입력한 값
		}
		if (get_transactionVO.getFrom_date() == null) {

			start_date = tools.start_date(sysdate); // sysdate로부터 한달전.
			get_transactionVO.setFrom_date(start_date);
		} else {
			// 유저가 입력한 값
		}
		if (get_transactionVO.getSort_order() == null) {
			get_transactionVO.setSort_order("D");
		} else {
			// 유저가 입력한 값

		}
		if (get_transactionVO.getPage_index() == null) {
			get_transactionVO.setPage_index("1");
		} else {
			// 유저가 입력한 값

		}
		if (get_transactionVO.getTran_dtime() == null) {
			get_transactionVO.setTran_dtime(sysdate + tools.Getsystime());
		} else {
			// 유저가 입력한 값

		}
	}
	
	

	@Override
	public LoginVO getUser(LoginVO loginVO) throws Exception {
		// TODO Auto-generated method stub
		LoginVO userInfo = dao.getUser(loginVO);
		if (userInfo == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 틀립니다.");
		}
		return userInfo;
	}

	@Override
	public Get_UseNumVO transaction_list(String bank_name) throws Exception {
		
		return dao.transaction_list(bank_name);
	}

	@Override
	public void save_data(String p_id,String p_category, String branch_name, String trandate) {
	          parameter.put("branch_name",branch_name);
	          parameter.put("trandate",	trandate);
	          parameter.put("p_id", p_id);
	          parameter.put("p_category", p_category);
	       
	          
		      dao.save_data(parameter);
	          dao.update_category(parameter);
	          
	          //사람들의 거래지점과 거래시간이 저장 그리고 소비성향이 저장된다. 해당 아이디로
		
	}

}
