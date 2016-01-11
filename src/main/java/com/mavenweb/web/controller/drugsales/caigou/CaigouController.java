package com.mavenweb.web.controller.drugsales.caigou;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mavenweb.commons.constants.ReturnCode;
import com.mavenweb.commons.json.JsonResult;
import com.mavenweb.service.caigou.ICaigouService;

@Controller
@RequestMapping("/servlet/drugsales")
public class CaigouController {
	private final static Logger logger = LoggerFactory.getLogger(CaigouController.class);
	
	@Autowired
	private ICaigouService caigouService;
	
	/**
	 * 获取活动药品信息
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/getWholesaleDrugInfo", method = RequestMethod.POST)
	public @ResponseBody 
	JsonResult getWholesaleDrugInfo(HttpServletRequest request,@RequestBody Map<String, Object> map) {
		
		try {
			return caigouService.getWholesaleDrugById(map);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new JsonResult(ReturnCode.EXCEPTION, "获取用户优惠券列表失败！", null);
		}
		
	}
	
}
