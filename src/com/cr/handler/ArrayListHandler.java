package com.cr.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.cr.entity.Area;

public  class ArrayListHandler implements ResultSetHandler<List<Area>> {
   /**
     * 处理dao里面查询的结果集 rs
     * @param rs 结果集
     * @return
     * @throws SQLException 
     */
	public List<Area> handle(ResultSet rs) throws SQLException{
		//定义一个大的结果集
		List<Area> areas  = new ArrayList<Area>();
		//定义一个小的实体对象
		Area area = null;
		//从结果集中取对应的字段
		while(rs.next()){
			area =  new Area(rs.getString("code"), rs.getString("name"), rs.getInt("layer"));
			areas.add(area);
		}
    	  return areas;
      }

}
