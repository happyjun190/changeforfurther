package com.mavenweb.dao.drugsales;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mavenweb.model.drugsales.TabWholesaleDrug;
import com.mavenweb.repositories.DrugsalesRepository;

@DrugsalesRepository
public interface WholesaleDrugDAO {
	
	/**
	 * 获取正在开展的采购活动id
	 * @param page
	 * @return
	 */
	public List<Integer> getStartWholesaleIdsList();
	
	
	@Select("select * from ts_wholesale_drug where id =#{0}")
	public TabWholesaleDrug getWholesaleDrugById(int wholesaleId);
	
}
