package com.mavenweb.service.caigou.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavenweb.model.drugsales.TabWholesaleDrug;
import com.mavenweb.service.caigou.ICaigouSolrService;

public class CaigouSolrService implements ICaigouSolrService {
	
	String urlString = "http://localhost:8983/solr/wholesale_drug_config_test";
	private final SolrClient client = new HttpSolrClient(urlString);
	private final ObjectMapper jsonMapper = new ObjectMapper();
	
	
	public void getCaigouBySolr() throws SolrServerException, IOException {
		
		List<TabWholesaleDrug> wholesaleDrugList = new LinkedList<TabWholesaleDrug>();
		
		SolrQuery solrQueryParams = new SolrQuery();
		
		QueryResponse resp = client.query(solrQueryParams);
		SolrDocumentList solrResult = resp.getResults();
		
		for(SolrDocument solrDocument:solrResult) {
			TabWholesaleDrug tabWholesaleDrug = TabWholesaleDrug.fromSolrDocument(solrDocument);
			wholesaleDrugList.add(tabWholesaleDrug);
			String str = jsonMapper.writeValueAsString(tabWholesaleDrug);
			System.out.println(str);
		}
		
		
	}
	
	
	
	public static void main(String args[]) throws SolrServerException, IOException {
		CaigouSolrService caigouSolrService = new CaigouSolrService();
		caigouSolrService.getCaigouBySolr();
	}
	
}
