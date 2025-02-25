package ejercicios_biblioteca;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class Biblioteca {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Desktop\\Leng_MarcasSGI\\xml\\biblioteca1.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			doc.getDocumentElement().normalize();
			System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
			NodeList libros = doc.getElementsByTagName("libro");
			System.out.println("Número de libros: "+ libros.getLength());
			
			for (int i=0; i<libros.getLength(); i++) {
				Node nodo = libros.item(i);
				System.out.println("\nElemento: " + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					System.out.println("Título: "+element.getElementsByTagName("titulo").item(0).getTextContent());
					System.out.println("Autor: "+element.getElementsByTagName("autor").item(0).getTextContent());
					System.out.println("Fecha: "+element.getElementsByTagName("fechaPublicacion").item(0).getAttributes().item(0).getTextContent());
				}
			}
			
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
