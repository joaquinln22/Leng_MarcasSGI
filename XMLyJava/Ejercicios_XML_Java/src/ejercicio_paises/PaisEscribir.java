package ejercicio_paises;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class PaisEscribir {

	public static void main(String[] args) {
		Pais listaPais[] = new Pais[2];
		listaPais[0] = new Pais("Uruguay", "república", 176215, "peso uruguayo", "español");
		listaPais[1] = new Pais("Jamaica", "monarquía", 10991, "dólar jamaicano", "inglés");
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			//Definimos el elemento raíz del documento
			Element eRaiz = doc.createElement("paises");
			doc.appendChild(eRaiz);
			
			// Recorremos la lista de nodos (paises) del documento XML
			for (int i=0; i<listaPais.length; i++) {
				//Definimos el nodo que contendrá los elementos
				Element ePais = doc.createElement("pais");
				eRaiz.appendChild(ePais);
				
				//Atributo nombre para el nodo pais
				Attr attr = doc.createAttribute("nombre");
				attr.setValue(listaPais[i].getNombre());
				ePais.setAttributeNode(attr);
				
				//Definimos cada uno de los elementos y le asignamos un valor
				Element eSistema = doc.createElement("sistema");
				eSistema.appendChild(doc.createTextNode(listaPais[i].getSistema()));
				ePais.appendChild(eSistema);
				
				Element eSuperficie = doc.createElement("superficie");
				eSuperficie.appendChild(doc.createTextNode(String.valueOf(listaPais[i].getSuperficie())));
				ePais.appendChild(eSuperficie);
				
				Element eMoneda = doc.createElement("moneda");
				eMoneda.appendChild(doc.createTextNode(listaPais[i].getMoneda()));
				ePais.appendChild(eMoneda);

				Element eIdioma = doc.createElement("idioma");
				eIdioma.appendChild(doc.createTextNode(listaPais[i].getIdioma()));
				ePais.appendChild(eIdioma);
			}
			//Clases necesarias para finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\JoaquinL\\Documents\\Leng_MarcasSGI\\XMLyJava\\paisesnuevos.xml"));
			
			transformer.transform(source, result);
		}catch (Exception e) {
			System.out.println("Error en la lectura del archivo XML");
		}

	}

}
