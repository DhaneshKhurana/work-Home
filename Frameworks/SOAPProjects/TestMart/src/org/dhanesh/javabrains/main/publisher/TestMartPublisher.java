package org.dhanesh.javabrains.main.publisher;

import javax.xml.ws.Endpoint;

import org.dhanesh.javabrains.main.ProductCatalog;

public class TestMartPublisher {

	public static void main(String[] args){
		Endpoint.publish("http://localhost:9090/dhanno", new ProductCatalog());
	}
}
