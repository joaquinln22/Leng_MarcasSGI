package ejercicios_boletin;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class DistribucionLeer {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Downloads\\distribuciones.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			NodeList nDistribuciones = doc.getElementsByTagName("distribucion");
			
			// Creamos un array de paises, con tantos paises como elementos pais tenga el documento XML
			Linux listaDistribuciones[] = new Linux[nDistribuciones.getLength()];
			
			// Recorremos la lista de nodos (paises) del documento XML
			for (int i=0; i<nDistribuciones.getLength(); i++) {
				Node nodo = nDistribuciones.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					String id = element.getAttribute("id");
					String nom = element.getElementsByTagName("nombre").item(0).getTextContent();
					String web = element.getElementsByTagName("web").item(0).getTextContent();
					int nac = Integer.parseInt(element.getElementsByTagName("nacimiento").item(0).getTextContent());
					
					// Creamos un nuevo objeto Pais con los datos leídos desde el documento XML y lo mostramos por pantalla
					listaDistribuciones[i] = new Linux(id, nom, web, nac);
					System.out.println(listaDistribuciones[i].toString());
				}
			}
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
