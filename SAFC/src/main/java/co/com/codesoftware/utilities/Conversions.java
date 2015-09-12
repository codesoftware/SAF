package co.com.codesoftware.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Conversions {
	/**
	 * Funcion que convierte de Date a String
	 * @param date
	 * @param format
	 * @return
	 */
	public String dateToString(Date date,String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	/**
	 * Funcion que convierte de String a date
	 * @param date
	 * @param format
	 * @return
	 */
	public Date stringToDate(String date,String format){
		Date result = new Date();
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			result= formatter.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Metodo que convierte de Date a XML 
	 * @param date
	 * @return
	 */
	
	public XMLGregorianCalendar dateToXMLGC(Date date){
		 GregorianCalendar c = new GregorianCalendar();
		 try {
			 System.out.println(date);
			 c.setTime(date);
			 return  DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
