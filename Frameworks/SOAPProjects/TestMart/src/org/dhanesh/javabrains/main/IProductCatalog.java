package org.dhanesh.javabrains.main;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService	
public interface IProductCatalog {

	@WebMethod(action="fetchPC", operationName="fetchProductCategories")
	List<String> getProductCategaories();

	@WebMethod
	@WebResult(partName="categoryList")
	List<String> getProducts(@WebParam(partName="category")String category) throws InvalidInputException;

	boolean addProducts(String category, String product);
}