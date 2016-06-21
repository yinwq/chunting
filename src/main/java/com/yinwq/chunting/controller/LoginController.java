package com.yinwq.chunting.controller;  
  
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinwq.chunting.entity.Admin;
import com.yinwq.chunting.service.IAdminService;
  
  
@Controller  
@RequestMapping("/login")  
public class LoginController {  
    @Resource  
    private IAdminService adminService;  
      
    @RequestMapping("/loginAdmin")  
    public String Login(HttpServletRequest request,HttpServletResponse response,Admin admin , Model model){  
    	HttpSession session = request.getSession();
		Object object = session.getAttribute("user");
		if(object != null){
			model.addAttribute("user", object);  
		}else{
			Admin loginAdmin = adminService.loginAdmin(admin);
			if(loginAdmin == null){
				model.addAttribute("admin", admin);
				return "login";
			}
			model.addAttribute("admin", loginAdmin);
			session.setAttribute("user", loginAdmin);
		}
		model.addAttribute("mainPage", "admin/blank.ftl");
        return "mainIndex";
    } 
    
    @RequestMapping("toLogin")
    public String toLogin(HttpServletRequest request , HttpServletResponse response , Model model){
    	HttpSession session = request.getSession();
		Object object = session.getAttribute("user");
		if(object != null){ 
			model.addAttribute("admin", object);  
			request.setAttribute("mainPage", "admin/blank.ftl");
			return "mainIndex";
		}
		return "login";
    }
}  