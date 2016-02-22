package com.mavenweb.service.caigou;

import java.io.IOException;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

import com.mavenweb.commons.json.JsonResult;

public interface ICaigouSolrService {
	
	public JsonResult getCaigouBySolr(Map<String, Object> map) throws SolrServerException, IOException;
	
}
