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
			// f�jl beolvas�sa
			Document document = builder.parse(new File("XMLH194QS.xml"));
			document.getDocumentElement().normalize();
			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("alkalmazott");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Alkalmazott adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					//Alkalmazottid elt�rol�sa egy stringbe
					String id=element.getAttribute("alkalmazottid");
				
					System.out.println("Alkalmazott id: " + element.getAttribute("alkalmazottid"));
					System.out.println("Reszleg id: " + element.getAttribute("reszlegid"));

					System.out.println("Alkalmazottn�v: "
							+ element.getElementsByTagName("alkalmazottnev").item(0).getTextContent());
					System.out.println(
							"Telefonsz�m: " + element.getElementsByTagName("telefonszam").item(0).getTextContent());

					// Alkalmazottan bel�li lakc�m adatok kiir�sa
					Node nodelakcim = list.item(i);
					if (nodelakcim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementlakcim = (Element) node;
						//id vizsg�lata �s ha megegyezzik a1-el akkor ir�ny�t�sz�m m�dos�t�s
						if(id.equals("a1")) {elementlakcim.getElementsByTagName("iranyitoszam").item(0).setTextContent("1111");}
						System.out.println("Ir�ny�t�sz�m: "
								+ elementlakcim.getElementsByTagName("iranyitoszam").item(0).getTextContent());
						System.out.println(
								"V�ros: " + elementlakcim.getElementsByTagName("varos").item(0).getTextContent());
						System.out.println("�t: " + elementlakcim.getElementsByTagName("ut").item(0).getTextContent());
						System.out.println(
								"H�zsz�m: " + elementlakcim.getElementsByTagName("hazszam").item(0).getTextContent());
					}
				
				}
			}
			//l�tehozza az xml f�jt m�dos�tva
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
