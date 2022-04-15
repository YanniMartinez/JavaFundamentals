import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//primerXML();
		String oldString1 = "2022-26-12";

        String newString1 = oldString1.replace("2022", "2021");
        newString1 = newString1+"T";
        System.out.println(newString1);
	}
	
	public static void primerXML() {
		try {
		      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); //Crea instancia de BuilderFactor
		      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();	//Crea documento
		      
		      //Elemento raíz
		      Document doc = docBuilder.newDocument();
		      Element rootElement = doc.createElement("API");
		      doc.appendChild(rootElement);
		      
		      //Primer elemento
		      Element elemento1 = doc.createElement("Order");
		      rootElement.appendChild(elemento1);
		      
		      //Se agrega un atributo al nodo elemento y su valor
		      Attr attr = doc.createAttribute("id");
		      attr.setValue("valor del atributo");
		      elemento1.setAttributeNode(attr);
		      
		      //Segundo elemento
		      Element elemento2 = doc.createElement("elemento2");
		      elemento2.setTextContent("Contenido del elemento 2");
		      rootElement.appendChild(elemento2);
		      
		      //Se escribe el contenido del XML en un archivo
		      TransformerFactory transformerFactory = TransformerFactory.newInstance();
		      Transformer transformer = transformerFactory.newTransformer();
		      DOMSource source = new DOMSource(doc);
		      StreamResult result = new StreamResult(new File("output\\prueba.xml"));
		      transformer.transform(source, result);
		      
		    } catch (ParserConfigurationException pce) {
		      pce.printStackTrace();
		    } catch (TransformerException tfe) {
		      tfe.printStackTrace();
		    }
	}

}
