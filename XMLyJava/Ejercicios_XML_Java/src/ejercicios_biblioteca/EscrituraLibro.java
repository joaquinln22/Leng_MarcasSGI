package ejercicios_biblioteca;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class EscrituraLibro {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			//Definimos el elemento raíz del documento
			Element eRaiz = doc.createElement("biblioteca");
			doc.appendChild(eRaiz);
			
			//Definimos el nodo que contendrá los elementos
			Element eLibro = doc.createElement("libro");
			eRaiz.appendChild(eLibro);
			
			//Atributo cod para el nodo libro
			Attr attr = doc.createAttribute("cod");
			attr.setValue("L4");
			eLibro.setAttributeNode(attr);
			
			//Definimos cada uno de los elementos y le asignamos un valor
			Element eTitulo = doc.createElement("titulo");
			eTitulo.appendChild(doc.createTextNode("El Quijote de La Mancha"));
			eLibro.appendChild(eTitulo);
			
			Element eAutor = doc.createElement("autor");
			eAutor.appendChild(doc.createTextNode("Miguel de Cervantes"));
			eLibro.appendChild(eAutor);
			
			Element eFecha = doc.createElement("fechaPublicacion");
			eFecha.appendChild(doc.createTextNode("1605"));
			eLibro.appendChild(eFecha);
			
			//Clases necesarias para finaalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\JoaquinL\\Documents\\Leng_MarcasSGI\\XMLyJava\\librosnuevos.xml"));
			
			transformer.transform(source, result);
		}catch (Exception e) {
			System.out.println("Error en la escritura del archivo XML");
		}
	}

}
