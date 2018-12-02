package net.myproject.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import net.myproject.myapp.models.Get_UseNumVO;
import net.myproject.myapp.models.LoginVO;
import net.myproject.myapp.models.get_transactionVO;

@Service
public interface ManagerService {
	       
	       
           public void get_transaction(get_transactionVO get_transactionVO);
		   public LoginVO getUser(LoginVO loginVO) throws Exception;
		   public List<Get_UseNumVO> get_fintech_num() throws Exception;
		   public Get_UseNumVO transaction_list(String bank_name) throws Exception;
		   public void save_data(String p_id,String p_category, String branch_name, String trandate);
}
