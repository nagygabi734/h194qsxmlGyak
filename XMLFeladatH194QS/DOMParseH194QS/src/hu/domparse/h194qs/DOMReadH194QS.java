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
			// f�jl beolvas�sa
			Document document = builder.parse(new File("XMLH194QS.xml"));
			document.getDocumentElement().normalize();
			// Gy�k�r elem megkeres�se
			System.out.println("Root element : " + document.getDocumentElement().getNodeName());
			System.out.println("----------------");
			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("alkalmazott");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Alkalmazott adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
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
			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("apkapcs");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Apkapcs adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Alkalmazott id: " + element.getAttribute("alkalmazottid"));
					System.out.println("Projekt id: " + element.getAttribute("projektid"));

					System.out
							.println("Munka�ra: " + element.getElementsByTagName("munkaora").item(0).getTextContent());
				}
			}
			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("ceg");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// C�g adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("C�g id: " + element.getAttribute("cegid"));

					System.out.println("C�gn�v: " + element.getElementsByTagName("cegnev").item(0).getTextContent());
					// C�gen bel�li c�gc�m adatok kiir�sa
					Node nodelakcim = list.item(i);
					if (nodelakcim.getNodeType() == Node.ELEMENT_NODE) {
						Element elementlakcim = (Element) node;
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
			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("ceg_tulajdonos");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// C�g tulajdonos adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("C�g id: " + element.getAttribute("cegid"));

					System.out.println(
							"C�g tulajdonos: " + element.getElementsByTagName("tulajdonos").item(0).getTextContent());
				}
			}
			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("projekt");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				// Projekt adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Projekt id: " + element.getAttribute("projektid"));

					System.out.println(
							"Projekt n�v: " + element.getElementsByTagName("projektnev").item(0).getTextContent());
					System.out.println("Projekt felel�s: "
							+ element.getElementsByTagName("projektfelelos").item(0).getTextContent());
					System.out
							.println("Hat�rid�: " + element.getElementsByTagName("hatarido").item(0).getTextContent());
				}
			}

			// Aktu�lis elem meghat�roz�sa
			list = document.getElementsByTagName("reszleg");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("\nCurrent element: " + node.getNodeName());
				//R�szleg adatainak kiir�sa
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Reszleg id: " + element.getAttribute("reszlegid"));
					System.out.println("C�g id: " + element.getAttribute("cegid"));
					
					System.out.println(
							"R�szlegn�v: " + element.getElementsByTagName("reszlegnev").item(0).getTextContent());
					System.out.println("Telephely: "
							+ element.getElementsByTagName("telephely").item(0).getTextContent());
					System.out
							.println("M�szak: " + element.getElementsByTagName("muszak").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}