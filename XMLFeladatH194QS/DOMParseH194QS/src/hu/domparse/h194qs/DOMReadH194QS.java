package hu.domparse.h194qs;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadH194QS {

	public static void main(String[] args) {
		NodeList list;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// fájl beolvasása
			Document document = builder.parse(new File("XMLH194QS.xml"));
			document.getDocumentElement().normalize();
			// Gyökér elem megkeresése
			System.out.println("Root element : " + document.getDocumentElement().getNodeName());
			System.out.println("----------------");
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("alkalmazott");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Alkalmazott adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
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
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("apkapcs");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Alkalmazott id: " + element.getAttribute("alkalmazottid"));
					System.out.println("Projekt id: " + element.getAttribute("projektid"));

					System.out
							.println("Munkaóra: " + element.getElementsByTagName("munkaora").item(0).getTextContent());
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("ceg");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Cég adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Cég id: " + element.getAttribute("cegid"));

					System.out.println("Cégnév: " + element.getElementsByTagName("cegnev").item(0).getTextContent());
					// Cégen belüli cégcím adatok kiirása
					Node nodelakcim = list.item(i);
					if (nodelakcim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementlakcim = (Element) node;
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
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("ceg_tulajdonos");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Cég tulajdonos adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Cég id: " + element.getAttribute("cegid"));

					System.out.println(
							"Cég tulajdonos: " + element.getElementsByTagName("tulajdonos").item(0).getTextContent());
				}
			}
			// Aktuális elem meghatározása
			list = document.getElementsByTagName("projekt");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Projekt adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Projekt id: " + element.getAttribute("projektid"));

					System.out.println(
							"Projekt név: " + element.getElementsByTagName("projektnev").item(0).getTextContent());
					System.out.println("Projekt felelõs: "
							+ element.getElementsByTagName("projektfelelos").item(0).getTextContent());
					System.out
							.println("Határidõ: " + element.getElementsByTagName("hatarido").item(0).getTextContent());
				}
			}

			// Aktuális elem meghatározása
			list = document.getElementsByTagName("reszleg");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				//Részleg adatainak kiirása
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Reszleg id: " + element.getAttribute("reszlegid"));
					System.out.println("Cég id: " + element.getAttribute("cegid"));
					
					System.out.println(
							"Részlegnév: " + element.getElementsByTagName("reszlegnev").item(0).getTextContent());
					System.out.println("Telephely: "
							+ element.getElementsByTagName("telephely").item(0).getTextContent());
					System.out
							.println("Mûszak: " + element.getElementsByTagName("muszak").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}