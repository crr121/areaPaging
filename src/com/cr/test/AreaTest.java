package com.cr.test;

import java.util.List;

import org.junit.Test;

import com.cr.dao.AreaDAO;
import com.cr.entity.Area;

public class AreaTest {
	AreaDAO ad = new AreaDAO();
	@Test
	public void testPage(){
		
		List<Area> areaInfo = ad.getAreaInfo(10, 1);
	for (Area area : areaInfo) {
		System.out.println(area);
	}
	}
	@Test
	public void pageCountTest(){
		Integer pageCount = ad.getPageCount(10);
		System.out.println(pageCount);
		
	}
}
