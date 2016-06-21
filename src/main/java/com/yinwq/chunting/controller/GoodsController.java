package com.yinwq.chunting.controller;  
  
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinwq.chunting.entity.Goods;
import com.yinwq.chunting.service.IGoodsService;
  
  
@Controller  
@RequestMapping("/goods")  
public class GoodsController {  
	
	@Resource
	private IGoodsService goodsService;
	
    @RequestMapping("/list")  
    public String list(HttpServletRequest request,Model model,Goods goods){ 
    	HttpSession session = request.getSession();
    	Object object = session.getAttribute("user");
		if(object != null){ 
			model.addAttribute("admin", object);  
		}
		List<Goods> goodsList = goodsService.selectGoodsList(goods);
		model.addAttribute("goodsList", goodsList);
		request.setAttribute("mainPage", "goods/goods_list.ftl");
        return "mainIndex";  
    }  
    
    @ResponseBody
    @RequestMapping("/goods_list")  
    public List<Goods> goodsList(HttpServletRequest request,Model model,Goods goods){ 
    	HttpSession session = request.getSession();
    	Object object = session.getAttribute("user");
		if(object != null){ 
			model.addAttribute("admin", object);  
		}
		List<Goods> goodsList = goodsService.selectGoodsList(goods);
		return goodsList;
    }  
    
    @RequestMapping("/to_add")  
    public String toAdd(HttpServletRequest request,Model model){ 
    	HttpSession session = request.getSession();
    	Object object = session.getAttribute("user");
    	if(object != null){ 
    		model.addAttribute("admin", object);  
    	}
    	request.setAttribute("mainPage", "goods/add.ftl");
    	
    	return "mainIndex";  
    }  
    
    @RequestMapping("/add")  
    public String add(HttpServletRequest request,Goods goods ,Model model){ 
    	HttpSession session = request.getSession();
    	Object object = session.getAttribute("user");
    	if(object != null){ 
    		model.addAttribute("admin", object);  
    	}
    	goods.setCreateTime(new Date());
    	goodsService.insertGoods(goods);
    	request.setAttribute("mainPage", "goods/goods_list.ftl");
    	return "redirect:/goods/list.jhtml";  
    }  
    
}  