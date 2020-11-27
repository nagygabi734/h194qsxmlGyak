package hu.domparse.h194qs;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyH194QS {

public static void main(String[] args) {
	NodeList list;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// fájl beolvasása
			Document document = builder.parse(new File("XMLH194QS.xml"));
			document.getDocumentElement().normalize();
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("alkalmazott");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Alkalmazott adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					//Alkalmazottid eltárolása egy stringbe
					String id=element.getAttribute("alkalmazottid");
				
					System.out.println("Alkalmazott id: " + element.getAttribute("alkalmazottid"));
					System.out.println("Reszleg id: " + element.getAttribute("reszlegid"));

					System.out.println("Alkalmazottnév: "
							+ element.getElementsByTagName("alkalmazottnev").item(0).getTextContent());
					System.out.println(
							"Telefonszám: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());

					// Alkalmazottan belüli lakcím adatok kiirása
					Node nodelakcim = list.item(i);
					if (nodelakcim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementlakcim = (Element) node;
						//id vizsgálata és ha megegyezzik a1-el akkor irányítószám módosítás
						if(id.equals("a1")) {elementlakcim.getElementsByTagName("iranyitoszam").item(0).setTextContent("1111");}
						System.out.println("Irányítószám: "
								+ elementlakcim.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out.println(
								"Város: " + elementlakcim.getElementsByTagName("varos").item(0).getTextContent());
						System.out.println("Út: " + elementlakcim.getElementsByTagName("ut").item(0).getTextContent());
						System.out.println(
								"Házszám: " + elementlakcim.getElementsByTagName("hazszam").item(0).getTextContent());
					}
				
				}
			}
			//létehozza az xml fájt módosítva
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Source input=new DOMSource(document);
			Result output = new StreamResult(new File("XMLH194QSModify.xml"));	
			transformer.transform(input, output);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
