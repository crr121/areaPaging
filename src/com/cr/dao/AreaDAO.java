package com.cr.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.cr.entity.Area;
import com.cr.util.JDBCUtil;


public class AreaDAO {
	private QueryRunner qr =  new QueryRunner();
	/**
	 * 获取当前页面需要显示的信息
	 * @param pageSize 页面显示的条数
	 * @param CurPage  当前的页数
	 * @return  返回查询后的结果集
	 */
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
	
	/**
	 * 得到页面总数
	 * @param pageSize 每页显示的条数
	 * @throws SQLException 
	 */
	public Integer getPageCount(int pageSize){
		String sql = " select ceil(count(1)/?) pageCount from area ";
		try {
			Map<String, Object> map = qr.query(JDBCUtil.getConnection(), sql , new MapHandler(),pageSize);
			 return ((BigDecimal)map.get("PAGECOUNT")).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}










