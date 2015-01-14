package com.spinach.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.ProductDAO;
import com.spinach.dao.StockDAO;
import com.spinach.dao.TypeDAO;
import com.spinach.dbo.Product;
import com.spinach.dbo.Stock;

@SuppressWarnings("rawtypes")
public class ProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8753468506104304065L;
	
	
	private ProductDAO productDAO;
	private TypeDAO typeDAO;
	private StockDAO stockDAO;
	
	private int id;
	private int typeId;
	private String productName;
	private String searchKeyword;
	
	public String homeRecords(){
		List<Product> productList1 = new ArrayList<Product>();
		List<Product> productList2 = new ArrayList<Product>();
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Product> products = productDAO.findByProperty("type.typeId", 1);
		for(int i=0 ; i<products.size() ; i++){
			productList1.add(products.get(i));
			if(productList1.size() > 3){
				break;
			}
		}
		
		products = productDAO.findByProperty("type.typeId", 2);
		for(int i=0 ; i<products.size() ; i++){
			productList2.add(products.get(i));
			if(productList2.size() > 2){
				break;
			}
		}

		
		request.setAttribute("productList1", productList1);
		request.setAttribute("productList2", productList2);
		
		return SUCCESS;
	}
	
	/*public String allRecords(){
		List<Product> productList = new ArrayList<Product>();
		HttpServletRequest request = ServletActionContext.getRequest();
		productList = productDAO.findAll();
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}*/

	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Product> productList = productDAO.findAll();
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}
	
	public String getRecord(){
		Product product = null;

		if(productName != null && !"".equals(productName)){
			product = (Product) productDAO.findByName(productName).get(0);
		} else {
			product = productDAO.findById(id);
		}
		
		Stock stock = (Stock) stockDAO.findByProperty("product", product).get(0);
		int remainder = stock.getNumber();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("product", product);
		request.setAttribute("remainder", remainder);

		
		
		return SUCCESS;
	}
	
	/*public String searchRecord(){
		List<Product> productList = productDAO.findByLike("name", productName);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}*/
	
	public String searchRecord(){
		List<Product> productList = productDAO.findByLike("name", searchKeyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}
	
	
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
}
