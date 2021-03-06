package validacao;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DTD {
	public static void main(String[] args) throws ParserConfigurationException {

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setValidating(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		builder.setErrorHandler(new ErrorHandler() {
			@Override
			public void error(SAXParseException exception) throws SAXException {
				// do something more useful in each of these handlers
				exception.printStackTrace();
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
			}

			@Override
			public void warning(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
			}
		});
		try {
			Document doc = (Document) builder.parse("pessoa.xml");
			doc.getDocumentElement().normalize();
			System.out.println("Arquivo válido");
		} catch (SAXException | IOException e) {
			System.out.println("Arquivo inválido");
		}
	}
}
