package com.spinach.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.CategoryDAO;
import com.spinach.dao.ProductDAO;
import com.spinach.dao.StockDAO;
import com.spinach.dao.TypeDAO;
import com.spinach.dbo.Category;
import com.spinach.dbo.Product;
import com.spinach.dbo.Stock;
import com.spinach.dbo.Type;

public class ProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8753468506104304065L;
	
	
	private ProductDAO productDAO;
	private TypeDAO typeDAO;
	private StockDAO stockDAO;
	private CategoryDAO categoryDAO;
	
	private Integer id;
	private Integer typeId;
	private String productName;
	private String searchKeyword;
	
	private Integer productId;
	private Integer categoryId;
	private String name;
	private String description;
	private Integer priceBox;
	private Integer priceBottle;
	private Integer active;
	private String shortName;
	private String aboutProduct;
	
	//upload file
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
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
	
	public String searchRecord(){
		List<Product> productList = productDAO.findByLike("name", searchKeyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}
	
	//Admin permission
	public String saveRecord(){
		try{
			String osName = System.getProperty("os.name");
			String path = "C:/apache-tomcat-7.0.54/webapps/spinach/products/";
			if(!osName.contains("Windows")) path = "/usr/share/tomcat/webapps/spinach/products/";
			
			Type type = typeDAO.findById(typeId);
			Category category = categoryDAO.findById(categoryId);
			
			Product product = new Product();
			
			if(fileUploadFileName != null){
				File file = new File(path, name.replace(" ", "_")+".jpg");
		        if(fileUploadFileName.contains(".jpg") || fileUploadFileName.contains(".jpeg")){
		        	FileUtils.copyFile(fileUpload, file);
					product.setSrc("products/" + name.replace(" ", "_") + ".jpg");
		        }
			}
			
			product.setType(type);
			product.setCategory(category);
			product.setName(name);
			product.setDescription(description);
			product.setPriceBox(priceBox);
			product.setPriceBottle(priceBottle);
			product.setActive(active);
			product.setShortName(shortName);
			product.setAboutProduct(aboutProduct);
			product.setInsertDate(new Timestamp(System.currentTimeMillis()));
			product.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			productDAO.save(product);
			
			Stock stock = new Stock();
			stock.setNumber(0);
			stock.setProduct(product);
			stockDAO.save(stock);
			
		}catch(Exception e){
			e.printStackTrace();
			return "saveerror";
		}
		return "successsave";
	}
	
	public String updateRecord(){
		try{
			String osName = System.getProperty("os.name");
			String path = "C:/apache-tomcat-7.0.54/webapps/spinach/products/";
			if(!osName.contains("Windows")) path = "/usr/share/tomcat/webapps/spinach/products/";
			
			Type type = typeDAO.findById(typeId);
			Category category = categoryDAO.findById(categoryId);
			
			Product product = productDAO.findById(productId);

			if(fileUploadFileName != null){
				File file = new File(path, name.replace(" ", "_")+".jpg");
		        if(fileUploadFileName.contains(".jpg") || fileUploadFileName.contains(".jpeg")){
		        	FileUtils.copyFile(fileUpload, file);
					product.setSrc("products/" + name.replace(" ", "_") + ".jpg");
		        }
			}
			
			product.setType(type);
			product.setCategory(category);
			product.setName(name);
			product.setDescription(description);
			product.setPriceBox(priceBox);
			product.setPriceBottle(priceBottle);
			product.setActive(active);
			product.setShortName(shortName);
			product.setAboutProduct(aboutProduct);
			productDAO.update(product);
			
		}catch(Exception e){
			e.printStackTrace();
			return "updateerror";
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriceBox() {
		return priceBox;
	}

	public void setPriceBox(Integer priceBox) {
		this.priceBox = priceBox;
	}

	public Integer getPriceBottle() {
		return priceBottle;
	}

	public void setPriceBottle(Integer priceBottle) {
		this.priceBottle = priceBottle;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}


	public String getAboutProduct() {
		return aboutProduct;
	}

	public void setAboutProduct(String aboutProduct) {
		this.aboutProduct = aboutProduct;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
}
