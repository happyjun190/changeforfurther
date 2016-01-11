package com.mavenweb.dao.drugsales;

import java.util.List;

import com.mavenweb.repositories.DrugsalesRepository;

@DrugsalesRepository
public interface WholesaleDrugDAO {
	
	/**
	 * 获取正在开展的采购活动id
	 * @param page
	 * @return
	 */
	public List<Integer> getStartWholesaleIdsList();
}
