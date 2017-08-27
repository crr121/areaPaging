package com.cr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cr.dao.AreaDAO;
import com.cr.entity.Area;
import com.google.gson.Gson;

public class AreaPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

				this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//请求和响应的乱码问题
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//从js请求里面获取Ajax传递的参数pagesize curpage
		int pageSize = Integer.parseInt(req.getParameter("pageSize")) ;
		int curPage = Integer.parseInt(req.getParameter("curPage"));
		
		//调用DAO的查询方法
		AreaDAO ad = new AreaDAO();
		//当前的页面信息
		List<Area> areas = ad.getAreaInfo(pageSize, curPage);
		//获取页面总数
		Integer pageCount = ad.getPageCount(pageSize);
		
		//将查询的数据返回给页面
		//这里返回的数据相当于有两张表
		//一张是当前的页面信息，一张是页面的总数
		//我们需要将之合并成一个JSON对象通过resp返回到页面
		//先将对象areaInfo转为JSON格式的数据
		String areaInfo = new Gson().toJson(areas);
		
		//再将pagecount和area info合并成一个json对象
		//JSON格式的对象是一个字符串，所以除了pageCount,areaInfo（变量）都是字符串（常量）
		areaInfo = "{\"pageCount\":"+pageCount+",\"pageInfo\":"+areaInfo+"}";
		
		System.out.println(areaInfo);
		//准备好返回的数据还需要利用resp设置返回数据的格式为json格式
		resp.setContentType("text/json");
		
		//这里我们不仅要返回，还需要将返回的数据打印到当前的页面
		//所以这里我们还需要resp设置一个输出的函数
		PrintWriter out = resp.getWriter();
		//将areainfo输出
		out.print(areaInfo);
	}
}
