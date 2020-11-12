package hu.meiit.xpathqueryh194qs;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathQueryH194QS {
	
	public static void main(String[] args){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse("studentH194QS.xml");
			doc.getDocumentElement().normalize();

			 XPathFactory xpathfactory = XPathFactory.newInstance();
	            XPath xpath = xpathfactory.newXPath();

				XPathExpression expr = xpath.compile("//student[@rollno='593']");
				NodeList nList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("Rollno=593:");
				System.out.println("\nCurrent Element: "+nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element nElement = (Element) nNode;
					System.out.println("Student roll no: " + nElement.getAttribute("rollno"));

					System.out.println(
							"First Name: " + nElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println(
							"Last Name: " + nElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println(
							"Nick name: " + nElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks: " + nElement.getElementsByTagName("marks").item(0).getTextContent());
				}

			}

		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
