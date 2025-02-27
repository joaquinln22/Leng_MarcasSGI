package ejemplo_videojuegos;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejemplo1 {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\JoaquinL\\Documents\\Leng_MarcasSGI\\XMLyJava\\videojuegos.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			
			doc.getDocumentElement().normalize();
			System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
			NodeList juegos = doc.getElementsByTagName("juego");
			System.out.println("Número de videojuegos: "+ juegos.getLength());
			
			for (int i=0; i<juegos.getLength(); i++) {
				Node nodo = juegos.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					System.out.println("\nTítulo: "+element.getElementsByTagName("titulo").item(0).getTextContent());
					System.out.println("Distribuidora: "+element.getElementsByTagName("distribuidora").item(0).getTextContent());
					System.out.println("Género: "+element.getElementsByTagName("genero").item(0).getTextContent());
					System.out.println("Edad mínima recomendada: "+element.getElementsByTagName("clasificacion").item(0).getTextContent());
					System.out.println("Plataforma principal: "+element.getElementsByTagName("plataforma").item(0).getTextContent());
				}
			}
			
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
