package com.mavenweb.service.caigou;

import java.util.Map;

import com.mavenweb.commons.json.JsonResult;

/**
 * 采购service interface
 * @author shenjun
 * 20160111
 */
public interface ICaigouService {
	
	/**
	 * 通过活动id获取活动名称
	 * @param id
	 * @return
	 */
	public JsonResult getWholesaleDrugById(Map<String, Object> map);
	
}
