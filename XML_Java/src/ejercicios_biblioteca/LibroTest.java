package ejercicios_biblioteca;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class LibroTest {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Desktop\\Leng_MarcasSGI\\XML_Java\\libros.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			NodeList nlibros = doc.getElementsByTagName("libro");
			
			// Creamos un array de libros, con tantos libros como elementos libro tenga el documento XML
			Libro listaLibros[] = new Libro[nlibros.getLength()];
			
			// Recorremos la lista de nodos (libros) del documento XML
			for (int i=0; i<nlibros.getLength(); i++) {
				Node nodo = nlibros.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					String cod = element.getAttribute("cod");
					String tit = element.getElementsByTagName("titulo").item(0).getTextContent();
					String aut = element.getElementsByTagName("autor").item(0).getTextContent();
					int anio = Integer.parseInt(element.getElementsByTagName("fechaPublicacion").item(0).getTextContent());
					
					// Creamos un nuevo objeto Libro con los datos leídos desde el documento XML y lo mostramos por pantalla
					listaLibros[i] = new Libro(cod, tit, aut, anio);
					System.out.println(listaLibros[i].toString());
				}
			}
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
