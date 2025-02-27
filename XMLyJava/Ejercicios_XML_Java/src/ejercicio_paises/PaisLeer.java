package ejercicio_paises;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class PaisLeer {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Documents\\Leng_MarcasSGI\\XMLyJava\\paises.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			NodeList nPaises = doc.getElementsByTagName("pais");
			
			// Creamos un array de paises, con tantos paises como elementos pais tenga el documento XML
			Pais listaPaises[] = new Pais[nPaises.getLength()];
			
			// Recorremos la lista de nodos (paises) del documento XML
			for (int i=0; i<nPaises.getLength(); i++) {
				Node nodo = nPaises.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					String nom = element.getAttribute("nombre");
					String sis = element.getElementsByTagName("sistema").item(0).getTextContent();
					String mon = element.getElementsByTagName("moneda").item(0).getTextContent();
					String idi = element.getElementsByTagName("idioma").item(0).getTextContent();
					int sup = Integer.parseInt(element.getElementsByTagName("superficie").item(0).getTextContent());
					
					// Creamos un nuevo objeto Pais con los datos leídos desde el documento XML y lo mostramos por pantalla
					listaPaises[i] = new Pais(nom, sis, sup, mon, idi);
					System.out.println(listaPaises[i].toString());
				}
			}
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
