package com.cr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cr.entity.Area;
import com.cr.util.JDBCUtil;



public class AreaDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/**
	 * 获取当前页面信息
	 * @param pageSize 每页显示条数
	 * @param curPage 当前页数
	 * @return
	 */
	public List<Area> getAreaInfo(int pageSize,int curPage){
		 
		List<Area> areas = new ArrayList<Area>();
		Area area = null;
		con = JDBCUtil.getConnection();
		 
		String sql = "select r,code,name,layer "
		        + " from (select rownum as r,code,name,layer from area) t "
		               + " where r between ? and ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, (curPage-1)*pageSize+1);
			ps.setInt(2, curPage*pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				area = new Area(rs.getString("code"), rs.getString("name"), rs.getInt("layer"));
				areas.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areas;
	}
	
	/**
	 * 获取页面总数
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	public Integer getPageCount(int pageSize){
		con = JDBCUtil.getConnection();
		int pageCount = 0;
		String sql = " select ceil(count(1)/?) pageCount from area ";
		 try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageSize);
			rs = ps.executeQuery();
			if(rs.next()){
				 pageCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageCount;
	}
	
	
	/*private QueryRunner qr =  new QueryRunner();
	*//**
	 * 获取当前页面需要显示的信息
	 * @param pageSize 页面显示的条数
	 * @param CurPage  当前的页数
	 * @return  返回查询后的结果集
	 *//*
	public  List<Area> getAreaInfo(int pageSize,int curPage){
	 
		String sql = "select r,code,name,layer "
				        + " from (select rownum as r,code,name,layer from area) t "
				               + " where r>=? and r<=? ";
		try {
			qr.query(JDBCUtil.getConnection(), sql, new ArrayListHandler(),(curPage-1)*pageSize+1,curPage*pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	*//**
	 * 得到页面总数
	 * @param pageSize 每页显示的条数
	 * @throws SQLException 
	 *//*
	public Integer getPageCount(int pageSize){
		String sql = " select ceil(count(1)/?) pageCount from area ";
		try {
			Map<String, Object> map = qr.query(JDBCUtil.getConnection(), sql , new MapHandler(),pageSize);
			 return ((BigDecimal)map.get("PAGECOUNT")).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
}










