package com.spinach.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.KabupatenDAO;
import com.spinach.dao.ProvinsiDAO;
import com.spinach.dbo.Kabupaten;
import com.spinach.dbo.Provinsi;

public class JsonRegion extends ActionSupport{

	private Integer provinsiId;
	
	private JSONObject jsonResult;
	
	private ProvinsiDAO provinsiDAO;
	private KabupatenDAO kabupatenDAO;

	public String getRecordJson(){
		Provinsi provinsi = provinsiDAO.findById(provinsiId);
		List<Kabupaten> kabupatenList = kabupatenDAO.findByProperty("provinsi", provinsi);
		
		jsonResult = new JSONObject();
		List<List<Object>> list = new ArrayList<List<Object>>();
		for(int i=0 ; i<kabupatenList.size() ; i++){
			int id = kabupatenList.get(i).getKabupatenId();
			String name = kabupatenList.get(i).getName();
			List<Object> l = new ArrayList<Object>();
			l.add(id);
			l.add(name);
			list.add(l);
		}
		
		jsonResult.put("kabupatenList", list);
		
		return SUCCESS;

	}

	public Integer getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(Integer provinsiId) {
		this.provinsiId = provinsiId;
	}

	public JSONObject getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}

	@JSON(serialize = false)
	public ProvinsiDAO getProvinsiDAO() {
		return provinsiDAO;
	}

	public void setProvinsiDAO(ProvinsiDAO provinsiDAO) {
		this.provinsiDAO = provinsiDAO;
	}

	@JSON(serialize = false)
	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}
	
	
	
}
