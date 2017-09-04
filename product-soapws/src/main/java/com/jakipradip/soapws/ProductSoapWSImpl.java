package com.jakipradip.soapws;

import java.math.BigInteger;

import javax.jws.WebService;

import com.cubic.soap.product.service.ProductInfo;
import com.cubic.soap.product.service.ProductSearchCriteria;
import com.cubic.soap.product.service.ProductSearchResponseType;
import com.cubic.soap.product.service.ProductServicePortType;

@WebService(name="ProductService",
serviceName="ProductService",
targetNamespace="http://com.cubic.net/productservice/1.0",
portName="ProductServicePort",
endpointInterface="com.cubic.soap.product.service.ProductServicePortType",
wsdlLocation="WEB-INF/ProductService.wsdl")
public class ProductSoapWSImpl implements ProductServicePortType {
	
	@Override
	public ProductSearchResponseType searchProduct(ProductSearchCriteria searchCriteria) {
		ProductSearchResponseType response = new ProductSearchResponseType();
		response.getProductInfo().add(this.createProductInfo("Expo Marker", "Expo desc"));
		response.getProductInfo().add(this.createProductInfo("HP Laptop", "HP desc"));
		response.getProductInfo().add(this.createProductInfo("Epson Projector", "Epson desc"));
		return response;
	}
	
	private ProductInfo createProductInfo(final String productName, final String desc){
		ProductInfo info = new ProductInfo();
		info.setProductName(productName);
		info.setProductId(new BigInteger(""+System.currentTimeMillis()));
		info.setProductDesc(desc);
		return info;
	}
}
