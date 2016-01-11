package com.mavenweb.service.caigou.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenweb.commons.constants.ReturnCode;
import com.mavenweb.commons.json.JsonResult;
import com.mavenweb.dao.drugsales.WholesaleDrugDAO;
import com.mavenweb.model.drugsales.TabWholesaleDrug;
import com.mavenweb.service.caigou.ICaigouService;

/**
 * 采购service implements
 * @author shenjun
 * 20160111
 */
@Service
public class CaigouService implements ICaigouService {

	@Autowired
	private WholesaleDrugDAO wholesaleDrugDAO;
	
	/**
	 * 通过活动id获取活动名称
	 */
	@Override
	public JsonResult getWholesaleDrugById(Map<String, Object> map) {
		//返回参数
		Map<String, Object> resutlMap = new HashMap<String, Object>();
		
		int wholesaleId = 1239;
		TabWholesaleDrug tabWholesaleDrug = wholesaleDrugDAO.getWholesaleDrugById(wholesaleId);
		
		resutlMap.put("wholesaleDrug", tabWholesaleDrug);
		return new JsonResult(ReturnCode.SUCCESS, "获取活动信息成功", resutlMap);
	}

}
