/**
 * 
 */
package br.poo.cic.poo.controlefinancas.comum;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author CaioYuri
 *
 */
public class Serializador {
	public static <T> String serializar(T o)
	{
		 
		try {
			JAXBContext context;
			context = JAXBContext.newInstance(o.getClass());
		

		    Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    	StringWriter sw = new StringWriter();
		    m.marshal(o, sw);
		    
		    return sw.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T deserializar(String o)
	{
		try {
			
			JAXBContext context;
			context = JAXBContext.newInstance(o.getClass());
		

		    Unmarshaller m = context.createUnmarshaller();
		    
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    	StringReader sr = new StringReader(o);
		    T obj = (T) m.unmarshal(sr);
		    
		    return obj;
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
