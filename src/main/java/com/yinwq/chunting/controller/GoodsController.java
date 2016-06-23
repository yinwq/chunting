package com.yinwq.chunting.controller;  
  
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinwq.chunting.entity.Goods;
import com.yinwq.chunting.service.IGoodsService;
import com.yinwq.chunting.util.JsonEntity;
import com.yinwq.chunting.util.PagedData;
  
  
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
		request.setAttribute("mainPage", "goods/goods_list.ftl");
        return "mainIndex";  
    }  
    
    @ResponseBody
    @RequestMapping(value = "/goods_list" , method=RequestMethod.POST)  
    public PagedData<Goods> goodsList(HttpServletRequest request,Model model,Goods goods){ 
		PagedData<Goods> page = goodsService.selectGoodsList(goods);
		return page;
    }  
    
    @RequestMapping("/to_add")  
    public String toAdd(HttpServletRequest request,Model model,Goods goods){ 
    	HttpSession session = request.getSession();
    	Object object = session.getAttribute("user");
    	if(object != null){ 
    		model.addAttribute("admin", object);  
    	}
    	if(goods.getId() != null){
    		goods = goodsService.getGoodsById(goods.getId());
    		model.addAttribute("goods",goods);
    	}
    	request.setAttribute("mainPage", "goods/add.ftl");
    	
    	return "mainIndex";  
    }  
    
    @RequestMapping("/add")
    @ResponseBody
    public JsonEntity add(HttpServletRequest request,Goods goods ,Model model){ 
    	JsonEntity json = new JsonEntity(true);
    	int id = 0;
    	if(goods.getId() == null){
	    	goods.setCreateTime(new Date());
	    	id = goodsService.insertGoods(goods);
    	}else{
	    	id = goodsService.updateGoods(goods);
    	}
    	json.addData("id", id);
    	return json;  
    }  
    @RequestMapping("/delete")
    @ResponseBody
    public JsonEntity delete(HttpServletRequest request,Goods goods ,Model model){ 
    	JsonEntity json = new JsonEntity(true);
    	int id = 0;
    	if(goods.getId() == null){
	    	json.setSuccess(false);
	    	System.out.println("参数缺失");
    	}else{
	    	id = goodsService.deleteGoods(goods.getId());
	    	if(id == 1){
	    		json.setSuccess(true);
	    	}
    	}
    	return json;  
    }  
    
}  