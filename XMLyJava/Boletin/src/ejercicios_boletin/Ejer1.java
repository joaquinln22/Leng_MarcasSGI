package ejercicios_boletin;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Ejer1 {

	final static int NACIMIENTO=2000;
	
	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Downloads\\distribuciones.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			doc.getDocumentElement().normalize();
			NodeList distribuciones = doc.getElementsByTagName("distribucion");
			System.out.println("Distribuciones Linux anteriores al "+NACIMIENTO+": ");
			
			for (int i=0, conta=0; i<distribuciones.getLength(); i++) {
				Node nodo = distribuciones.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					int nacimiento=Integer.parseInt(element.getElementsByTagName("nacimiento").item(0).getTextContent());
					if(nacimiento<NACIMIENTO) {
						System.out.println((++conta)+". "+element.getElementsByTagName("nombre").item(0).getTextContent());
					}
				}
			}
			
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}
	}
}
