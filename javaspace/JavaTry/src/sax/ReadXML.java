package sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException{
		
		
		SaxStudentHandler hnd = new SaxStudentHandler();
		hnd.read();
	}
}
