package ejemplo_videojuegos;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejemplo4 {

	final static String DISTRIBUIDORA="Nintendo";
	
	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Documents\\Leng_MarcasSGI\\XMLyJava\\videojuegos.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			doc.getDocumentElement().normalize();
			NodeList juegos = doc.getElementsByTagName("juego");
			System.out.println("Videojuegos de "+DISTRIBUIDORA+": ");
			
			for (int i=0, conta=0; i<juegos.getLength(); i++) {
				Node nodo = juegos.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					if(element.getElementsByTagName("distribuidora").item(0).getTextContent().equals(DISTRIBUIDORA)) {
						System.out.println((++conta)+". "+element.getElementsByTagName("titulo").item(0).getTextContent());
					}
				}
			}
			
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
