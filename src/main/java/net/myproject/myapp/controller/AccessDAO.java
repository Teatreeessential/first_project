package net.myproject.myapp.controller;

import java.util.List;
import java.util.Map;

import net.myproject.myapp.models.Get_UseNumVO;
import net.myproject.myapp.models.LoginVO;

public interface AccessDAO {
	
	public LoginVO getUser(LoginVO loginVO) throws Exception; //최초 로그인

	public List<Get_UseNumVO> get_fintech_num() throws Exception; //핀테크 번호와 은행 명을 가져오는 곳
   
	public Get_UseNumVO transaction_list(String bank_name) throws Exception;

	public void save_data(Map<String,String> parameter);

	public void update_category(Map<String,String> parameter);
}
