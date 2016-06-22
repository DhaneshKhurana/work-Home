package sax.products;

import java.io.File;
import java.sql.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class products {
	
	//display
	public void display(){
		try{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser parser = spf.newSAXParser();
			parser.parse(new File("Products.xml"), new productHandler());
		
		}catch(Exception e){
			System.out.println("problem in creating parser :: " + e.getMessage());
		}
	}
	
	
	//Inner class extending Hadndler
	private class productHandler extends DefaultHandler{
		
		private int count =0;
		private String tagName="";
		private String day="", month="", year="";
		
		//start Document
		public void startDocument() throws SAXException {
			System.out.println("			Started reading");
		}
		
		//end Documents
		public void endDocument() throws SAXException {
			System.out.println("			Ended Reading");
		}
		
		//start element
		public void startElement(String arg0, String arg1, String arg2,
				Attributes arg3) throws SAXException {
			tagName=arg2;
			
			if(arg2.equals("prodcut")){
				System.out.println(arg2 + " count :: "+ count++ + " " + arg3.getLocalName(0) + " :: " + arg3.getValue(0) + " " + arg3.getLocalName(1) + " :: " + arg3.getValue(1));
				System.out.println("=====================================");
			}
		}
		
		//end element
		public void endElement(String arg0, String arg1, String arg2)
				throws SAXException {
			
			if(tagName.equals("prodcut")){
				System.out.println("======================================");
			}
			tagName="";
			
		}
		
		//characters
		@Override
		public void characters(char[] arg0, int arg1, int arg2)
				throws SAXException {
			
			if(tagName.equals("day")){
				day = new String(arg0, arg1, arg2);
			}
			else if(tagName.equals("month")){
				month = new String(arg0, arg1, arg2);
			}
			else if(tagName.equals("year")){
				year = new String(arg0, arg1, arg2);
				System.out.println("manufacturing date :: " + day+"\\"+month+"\\"+year);
			}
			else if(tagName.equals("exp")){
				System.out.println("expired in :: "+ new String(arg0, arg1, arg2) + " days.");
			}
			else if(tagName.equals("color")){
				System.out.println("carton color :: "+ new String(arg0, arg1, arg2));
			}
			else if(tagName.equals("company")){
				System.out.println("company :: "+ new String(arg0, arg1, arg2));
			}
			
		}
	}
	
	
	
}
