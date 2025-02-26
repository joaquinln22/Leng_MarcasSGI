package ejercicios_biblioteca;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class EscrituraListaLibro {

	public static void main(String[] args) {
		Libro listaLib[] = new Libro[3];
		listaLib[0] = new Libro("Lágrimas en la lluvia", "Rosa Montero", 2011);
		listaLib[1] = new Libro("Sin noticias de Gurb", "Eduardo Mendoza", 1991);
		listaLib[2] = new Libro("La sombra del águila", "Arturo Pérez-Reverte", 1993);
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			// Definimos el elemento raíz del documento
			Element eRaiz = doc.createElement("biblioteca");
			doc.appendChild(eRaiz);
			
			for(int i=0; i<listaLib.length; i++) {
				//Definimos el nodo que contendrá los elementos
				Element eLibro = doc.createElement("libro");
				eRaiz.appendChild(eLibro);
				
				//Atributo cod para el nodo libro
				Attr attr = doc.createAttribute("cod");
				attr.setValue(listaLib[i].getCod());
				eLibro.setAttributeNode(attr);
				
				//Definimos cada uno de los elementos y le asignamos un valor
				Element eTitulo = doc.createElement("titulo");
				eTitulo.appendChild(doc.createTextNode(listaLib[i].getTitulo()));
				eLibro.appendChild(eTitulo);
				
				Element eAutor = doc.createElement("autor");
				eAutor.appendChild(doc.createTextNode(listaLib[i].getAutor()));
				eLibro.appendChild(eAutor);
				
				Element eFecha = doc.createElement("fechaPublicacion");
				eFecha.appendChild(doc.createTextNode(String.valueOf(listaLib[i].getFechaPublicacion())));
				eLibro.appendChild(eFecha);
			}
			//Clases necesarias para finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\JoaquinL\\Desktop\\Leng_MarcasSGI\\XML_Java\\librosnuevos2.xml"));
			
			transformer.transform(source, result);
		}catch(Exception e) {
			System.out.println("Error en la escritura del archivo XML");
		}
	}

}
