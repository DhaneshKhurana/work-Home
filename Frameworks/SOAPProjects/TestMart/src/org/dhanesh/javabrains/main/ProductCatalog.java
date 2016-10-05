package org.dhanesh.javabrains.main;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.dhanesh.javabrains.main.business.ProductServices;

@WebService(endpointInterface="org.dhanesh.javabrains.main.IProductCatalog")
public class ProductCatalog implements IProductCatalog {

	ProductServices pServices = new ProductServices();
	
	@Override
	public List<String> getProductCategaories(){
		return pServices.getProductCategaories();
	}
	
	@Override
	public List<String> getProducts(String category) throws InvalidInputException {
		if(category.equals("invalid")){
			throw new InvalidInputException("Invalud Input", "I submitted invalid input");
		}
		return pServices.getProducts(category);
	}
	
	@Override
	public boolean addProducts(String category, String product){
		return pServices.addProducts(category, product);
	}
}
