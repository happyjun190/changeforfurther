package com.mavenweb.service.caigou.impl;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.mavenweb.commons.constants.ReturnCode;
import com.mavenweb.commons.json.JsonResult;
import com.mavenweb.model.drugsales.TabWholesaleDrug;
import com.mavenweb.service.caigou.ICaigouSolrService;

@Service
public class CaigouSolrService implements ICaigouSolrService {
	
	String urlString = "http://localhost:8983/solr/wholesale_drug_config_test";
	private final SolrClient client = new HttpSolrClient(urlString);
	//private final ObjectMapper jsonMapper = new ObjectMapper();
	
	@Before("com.mavenweb.service.aoptest.impl.beforeAdvice()")
	//@AfterReturning("com.mavenweb.service.aoptest.impl.afterFinallyAdvice()")
	public JsonResult getCaigouBySolr(Map<String, Object> map) throws SolrServerException, IOException {
		
		List<TabWholesaleDrug> wholesaleDrugList = new LinkedList<TabWholesaleDrug>();
		
		SolrQuery solrQueryParams = new SolrQuery("*:*");
		QueryResponse resp = client.query(solrQueryParams);
		SolrDocumentList solrResult = resp.getResults();
		
		for(SolrDocument solrDocument:solrResult) {
			TabWholesaleDrug tabWholesaleDrug = TabWholesaleDrug.fromSolrDocument(solrDocument);
			wholesaleDrugList.add(tabWholesaleDrug);
//			String str = jsonMapper.writeValueAsString(tabWholesaleDrug);
//			System.out.println(str);
		}
		
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		resultMap.put("listSize", wholesaleDrugList.size());
		resultMap.put("wholesaleDrugList", wholesaleDrugList);
		
		System.out.println("xxxxx");
		
		return new JsonResult(ReturnCode.SUCCESS, "获取活动信息成功", resultMap);
	}
	
	
//	public static void main(String args[]) throws SolrServerException, IOException {
//		CaigouSolrService caigouSolrService = new CaigouSolrService();
//		caigouSolrService.getCaigouBySolr();
//	}
	
}
