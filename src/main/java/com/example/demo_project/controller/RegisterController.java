package com.example.demo_project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.ActiveAccountReq;
import com.example.demo_project.vo.LoginInfo;
import com.example.demo_project.vo.RegisterReq;
import com.example.demo_project.vo.RegisterRes;

@RestController
public class RegisterController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());//紀錄(import slf4j)
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value = "/api/register")
	public RegisterRes register(@RequestBody RegisterReq req, HttpSession httpSession) {
		RegisterRes check = checkParam(req);
		if(check != null) {
			return check;
		}
		Register reg = registerService.register(req.getAccount(), req.getPwd(), req.getName(), req.getAge(),
				req.getCity());
		if(reg == null) {//抓到impl的null
			return new RegisterRes(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
		}
		double random = Math.random()*10000;
		int verifyCode = (int)Math.round(random);
		
		httpSession.setAttribute("account", req.getAccount());
		httpSession.setAttribute("verify_code", verifyCode);

		return new RegisterRes(reg,RegisterRtnCode.SUCCESSFUL.getMessage(), verifyCode);
	}
	
	public RegisterRes checkParam(RegisterReq req) {
		RegisterRes res = new RegisterRes();
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getPwd())) {
			return new RegisterRes(RegisterRtnCode.PWD_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getName())) {
			return new RegisterRes(RegisterRtnCode.NAME_REQUIRED.getMessage());
		}
		return null;
	}
	
	@PostMapping(value = "/api/active_account")
	public RegisterRes activeAccount(@RequestBody RegisterReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		return registerService.activeAccount(req.getAccount());
	}
	
	@PostMapping(value = "/api/addRoleList")
	public RegisterRes addRole(@RequestBody RegisterReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		return registerService.addRole(req.getAccount(), req.getRoleList());
	}
	
	@PostMapping(value = "/api/login")
	public RegisterRes login(@RequestBody LoginInfo loginInfo, HttpSession httpSession) {
		if(!StringUtils.hasText(loginInfo.getAccount()) || !StringUtils.hasText(loginInfo.getPwd())) {
			return new RegisterRes("Parameter is error !");
		}
		Register result = registerService.findById(loginInfo.getAccount());
		if(result == null) {
			return new RegisterRes("UserInfo cannot find !!");
		}
		httpSession.setAttribute("user_account", result.getAccount());//第一個參數為字串
		httpSession.setMaxInactiveInterval(0);//設定帳號在暫存端儲存的時間
		return new RegisterRes(result, "Login success !");
	}
	
	@PostMapping(value = "/api/logout")
	public RegisterRes logout(HttpSession httpSession) {
		httpSession.removeAttribute("usser_account");//刪除account(key值)會找到value刪除
		return new RegisterRes("Logout success !");
	}
	
	@PostMapping(value = "/api/get_user_info")
	public RegisterRes getUserInfo(HttpSession httpSession) {
		Object attValue = httpSession.getAttribute("user_account");
		if(attValue != null) {
			String account = attValue.toString();
			Register result = registerService.findById(account);
			return new RegisterRes(result, "Get user info success !");
		}
//		String account = httpSession.getAttribute("user_account").toString();//取得user_account轉字串
//		Register result = registerService.findById(account);
		return new RegisterRes(new Register(), "Get user info success !");
	}
	@PostMapping(value = "/api/active_account2")
	public RegisterRes activeAccount2(@RequestBody ActiveAccountReq req, HttpSession httpSession) {
		if(httpSession.getAttribute("account")==null) {
			return new RegisterRes("account is null !");
		}
		int x = (int) httpSession.getAttribute("verify_code");
		if(httpSession.getAttribute("verify_code") == null) {
			return new RegisterRes("verify_code is null !");
		}
		if(x == req.getVerifyCode()) {
			RegisterRes result = registerService.activeAccount(httpSession.getAttribute("account").toString());
			return new RegisterRes("Active success !");
		}
		return new RegisterRes(new Register(), "Get user info success !");
	}
}
