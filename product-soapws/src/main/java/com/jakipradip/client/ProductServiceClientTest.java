package com.jakipradip.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.cubic.soap.product.service.ProductInfo;
import com.cubic.soap.product.service.ProductSearchCriteria;
import com.cubic.soap.product.service.ProductSearchResponseType;
import com.cubic.soap.product.service.ProductService;
import com.cubic.soap.product.service.ProductServicePortType;

public class ProductServiceClientTest {

	public static void main(String[] args) throws MalformedURLException {
		String endPoint = "http://localhost:9090/product-soapws/ProductService?wsdl";
		ProductService ps = new ProductService(new URL(endPoint));
		ProductServicePortType portType = ps.getProductServicePort();
		ProductSearchCriteria searchCriteria = new ProductSearchCriteria();
		
		searchCriteria.setProductName("s");
		
		ProductSearchResponseType responseType = portType.searchProduct(searchCriteria);
		for(ProductInfo info : responseType.getProductInfo() ){
			System.out.println(info.getProductId()+"==>"+info.getProductName()+"==>"+info.getProductDesc());
		}
		//System.out.println(responseType.getProductInfo());
		

	}

}
