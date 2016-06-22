package sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxStudentHandler extends DefaultHandler{
	
	volatile String tagName;

	public void read() throws ParserConfigurationException, SAXException{
		SAXParserFactory sfx = SAXParserFactory.newInstance();
		SAXParser parser = sfx.newSAXParser();
		
		try {
			parser.parse(new File("class.xml"), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startDocument() throws SAXException {
		System.out.println("*******Started reading the file************ ");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("******Ended reading the file********* ");
	}
	
	
	public void startElement(String uri, String localName, String qname,
			Attributes attrs) throws SAXException {
		this.tagName= qname;
		if(tagName.equalsIgnoreCase("student")){
			System.out.println("======Element started=====");
			System.out.println("uri :: " + uri);
			System.out.println("localName :: " + localName);
			System.out.println("qname :: " + qname);
			System.out.println("attribute id :: " + attrs.getValue(0));
		}
	}

	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		this.tagName="";
		if(arg2.equals("student"))
			System.out.println("======Element ended======");
	}
	
	public void characters(char[] ch, int start, int end) throws SAXException {
		if(this.tagName.equals("name")){
			System.out.println("name :: " + new String(ch, start, end));
		}
		else if(this.tagName.equals("rollNo")){
			System.out.println("Roll No. :: " + new String(ch, start, end));
		}
		else if(this.tagName.equals("class")){
			System.out.println("class :: " + new String(ch, start, end));
		}
	}
	
}
