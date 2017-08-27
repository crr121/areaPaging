package com.cr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.cr.entity.Area;
import com.cr.util.JDBCUtil;


public class AreaDAO {
	private QueryRunner qr =  new QueryRunner();
	/**
	 * 获取area的所有信息
	 * @param pageSize 页面显示的条数
	 * @param CurPage  当前的页数
	 * @return  返回查询后的结果集
	 */
	public  List<Area> getAreaInfo(int pageSize,int CurPage){
	 
		String sql = "select r,code,name,layer "
				        + " from (select rownum as r,code,name,layer from area) t "
				               + " where r>=? and r<=? ";
		try {
			qr.query(JDBCUtil.getConnection(), sql, new ArrayListHandler(),(CurPage-1)*pageSize+1,CurPage*pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
