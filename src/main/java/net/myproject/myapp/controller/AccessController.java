package net.myproject.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UrlPathHelper;

import net.myproject.myapp.models.Get_UseNumVO;
import net.myproject.myapp.models.LoginVO;
import net.myproject.myapp.models.get_transactionVO;

@Controller
@RequestMapping("transaction")
public class AccessController {

	@Autowired
	ManagerService service;
	Tools tools = new Tools();
	get_transactionVO get_transactionVO = new get_transactionVO();
	Get_UseNumVO Get_UseNumVO = new Get_UseNumVO();
	List<Get_UseNumVO> get_usernumVOs;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() { // 로그인화면이 뜨고

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute LoginVO loginVO, HttpSession session) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(loginVO.getId());
		try {
			LoginVO userInfo = service.getUser(loginVO);

			session.setAttribute("id", userInfo.getId());
			session.setAttribute("access_token", userInfo.getAccess_token());

			mav.addObject("msg", userInfo.getId() + " 사용자가 로그인 되었습니다.");
			mav.addObject("url", "view");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "login");
		}
		return mav;
	}

	@RequestMapping(value = "view", method = RequestMethod.GET) // 거래내역을 받아 view.jsp로 표기해주는 메서드
	public ModelAndView balance_show() { // 잔액을 보여주는 메서드

		ModelAndView mav = new ModelAndView("transaction/balance_view");

		try {
			get_usernumVOs = service.get_fintech_num(); // 핀테크 이용번호 정보를 가져오는 곳
			service.get_transaction(get_transactionVO); // 각종 파라미터의 디폴트 값 설정

		} catch (Exception e) {
			e.printStackTrace();

		}

		mav.addObject("get_transactionVO", get_transactionVO);
		mav.addObject("get_usernumVOs", get_usernumVOs);
		return mav;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView transaction_list(String bank_name) {
		ModelAndView mav = new ModelAndView("transaction/transaction_list");
		try {
			System.out.println(bank_name);
			Get_UseNumVO = service.transaction_list(bank_name); // 거래내역 불러오는 곳
			service.get_transaction(get_transactionVO);

		} catch (Exception e) {
			e.printStackTrace();

		}
		mav.addObject("get_transactionVO", get_transactionVO);
		mav.addObject("Get_UseNumVO", Get_UseNumVO);
		return mav;
	}

	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String save_data(String category, String branch_name, String trandate, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		service.save_data(id, category, branch_name, trandate);
		
		return "redirect:./list";
	}

	@RequestMapping(value = "piechart", method = RequestMethod.GET)
	public String piechart() {
		return "transaction/piechart";
	}

}
